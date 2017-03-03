/**
 * Created by jeffdev on 3/3/17.
 */
public class Node {

    private int numBreakpoint;
    private int stack[];

    public Node(int i, int a[]){
        numBreakpoint = i;
        stack = a;
    }


    int getNumBreakpoint(){ return numBreakpoint; }
    int[] getStack(){ return stack; }

}
