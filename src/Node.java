import java.util.ArrayList;

/**
 * Created by jeffdev on 3/3/17.
 */
public class Node {

    //number of break points in our stack
    private int numBreakpoint;
    private int cost;
    private Node parent;

    //Our pancake stack
    private int stack[];

    private Node(int stack[], int cost, Node parent){
    //constructor
        this.cost = cost;
        this.stack = stack;
        this.parent = parent;


    }

    public ArrayList genChildren(){
        ArrayList<Node> children = new ArrayList<Node>();

        for (int i = 0; i < stack.length - 2; i++)
            for ( int j = i; j <stack.length - 2 ; j++)
                if(stack[j] > stack[j+1])
                    children.add(new Node(flipBreakpoint(i,j),cost+1,this));
        return children;
    };


    private int[] flipBreakpoint(int start, int end){
        //create a temp array and flip it
        int tempStack[] = stack;
        for (int i = start; i < tempStack[(end-start)/2]; i++) {
            int temp = tempStack[i];
            tempStack[i] = tempStack[end-i];
            tempStack[end-i] = temp;
        }
        return tempStack;

    }

    public boolean isBreak(int index){
        //The breakpoint is after the number at the index.
        return false;
    }

    private int countBreakpoint(){
        return 0;
    }

    void setNumBreakpoint(int i){ numBreakpoint = i;}
    int getNumBreakpoint(){ return numBreakpoint; }
    int[] getStack(){ return stack; }
    Node getParent(){return parent;}



}
