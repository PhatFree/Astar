import java.util.ArrayList;

/**
 * Created by jeffdev on 3/3/17.
 */
public class Node {

    //number of break points in our stack
    private int numBreakpoints;
    private int cost;
    private Node parent;

    //Our pancake stack
    private int stack[];

    public Node(int stack[], int cost, Node parent) {
        //constructor
        this.cost = cost;
        this.stack = stack;
        this.parent = parent;
        countBreakpoints();
    }


    public ArrayList<Node> genChildren() {
        ArrayList<Node> children = new ArrayList<>();
        // TODO fix this loop, or something
        for (int i = 0; i < stack.length - 1; i++)
            if (isBreak(i) || i == 0)
                for (int j = i + 1; j < stack.length ; j++)
                    if (isBreak(j) || j == stack.length - 1)
                        children.add(new Node(flipBreakpoint(i, j), cost + 1, this));
        if(AStar.DEBUG)System.out.println("\tChildren of: " + this);
        if(AStar.DEBUG)System.out.println("\t" + children);
        return children;
    }


    private int[] flipBreakpoint(int start, int end) {
        //create a temp array and flip it
        int tempStack[] = stack.clone();
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int temp = tempStack[start + i];
            tempStack[start + i] = tempStack[end - i];
            tempStack[end - i] = temp;
        }
        return tempStack;
    }

    private boolean isBreak(int index) {
        //The breakpoint is after the number at the index.
        if (index < 0 || index >= stack.length-1)
            return false;
        if (stack[index + 1] == stack[index] + 1)// || stack[index + 1] == stack[index] - 1)
            return false;
        return true;
    }

    private void countBreakpoints() {
        //find out how many break points we have
        numBreakpoints = 0;
        for (int i = 0; i < stack.length - 1; i++)
            if (isBreak(i))
                numBreakpoints++;
    }


    public boolean isGoal() {// if the array is in ascending order return true
        for (int i = 0; i < stack.length - 1; i++)
            if (stack[i] > stack[i + 1])
                return false;
        return true;
    }

    // Analysis of worthiness. Cost incurred so far + heuristic estimate of goal
    public int analysis() {
        return cost + numBreakpoints;
    }

    int getNumBreakpoints() { return numBreakpoints; }

    int getCost() { return cost; }

    void setCost(int cost) { this.cost = cost; }

    int[] getStack() { return stack; }

    Node getParent() { return parent; }

    void setParent(Node parent) { this.parent = parent; }

    @Override
    public String toString() {
        String str = numBreakpoints + ":[";
        for (int x : stack)
            str += x + ", ";
        return str.substring(0, str.length() - 2) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node other = (Node) obj;
            if (stack.length != other.stack.length)
                return false;
            for (int i = 0; i < stack.length; i++)
                if (stack[i] != other.stack[i])
                    return false;
            return true;
        }
        return false;
    }
}
