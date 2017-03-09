import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class AStar {

    static final boolean DEBUG = false;

    private int numNodesExpanded;  // number of nodes removed from open set
    private PriorityQueue<Node> openSet;
    private PriorityQueue<Node> closedSet;

    public AStar() {
        // init open set as empty
        openSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.analysis() - o2.analysis();
            }
        });

        // init closed set as empty
        closedSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.analysis() - o2.analysis();
            }
        });
    }


    /**
     * Executes an A* search, beginning at the source Node and seeking a Node
     * that satisfies the isGoal requirement.
     */
    public boolean search(Node source) {
        // TODO return type?
        // source node f (full analysis) is weight=0 + heuristic
        // add source to open set
        System.out.println("Searching from node: " + source + "\n");
        openSet.add(source);
        // while open set isn't empty
        while (!openSet.isEmpty()) {
            // get n = smallest element from open set
            Node temp = openSet.poll();
            numNodesExpanded++;
            if(DEBUG)System.out.println("Expanding node: " + temp);

            // (add n to closed set)
            closedSet.add(temp);

            if (temp.isGoal()) {
                // return n or path to n or whatever we return
                System.out.println("Found goal node! " + numNodesExpanded + " expansions to reach.");
                int reversals = 0;
                // TODO not this
                while (temp != null) {
                    System.out.println(temp);
                    temp = temp.getParent();
                    reversals++;
                }
                System.out.println(reversals-1 + " reversals");
                return true;
            }
            // generate successors of n
            ArrayList<Node> successors = temp.genChildren();
            for (Node n : successors) {
                improve(temp, n);
            }
        }
        System.out.println("No solution found");
        return false;  // no solution found
    }


    /**
     * Relaxation procedure. Updates the path and associated costs between
     * nodes from and to
     */
    private void improve(Node from, Node to) {
        // 'to' generated already but not yet expanded, and this is a better path
        if (openSet.contains(to)) {
            if (from.getCost() + 1/*+ w(from, to)*/ < to.getCost()) {
                if(DEBUG)System.out.println("Found better path to an open node");
                to.setParent(from);
                // set f (to) = from.getCost() + w(from, to) + h(to)  // update solution estimate
                to.setCost(from.getCost() + 1/*w(from, to)*/);
            }
        }
        // 'to' already expanded, but this is a better path
        else if (closedSet.contains(to)) {
            if (from.getCost() + 1/*+ w(from, to)*/ < to.getCost()) {
                if(DEBUG)System.out.println("Found better path to a closed node");
                to.setParent(from);
                // set f (to) = from.getCost() + w(from, to) + h(to)  // update solution estimate
                closedSet.remove(to);
                openSet.add(to);
            }
        }
        // 'to' not seen before
        else {
            if(DEBUG)System.out.println("New node discovered!");
            to.setParent(from);
            // set f (to) = from.getCost() + w(from, to) + h(to)  // set solution estimate
            openSet.add(to);
        }
    }

    /**
     * Constructs and returns the most recent path discovered.
     * Returns null if no search has been made, or no path was discovered.
     */
    public void getPath() {
        /*TODO return type*/
    }


}
