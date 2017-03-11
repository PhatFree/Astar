import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class AStar {

    private PriorityQueue<Node> openSet;
    private PriorityQueue<Node> closedSet;

    public AStar() {
        // init open set as empty
        openSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.analysis() < o2.analysis() ? -1 :
                        o1.analysis() > o2.analysis() ? 1 :
                                0;  // o1 == o2
            }
        });

        // init closed set as empty
        closedSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.analysis() < o2.analysis() ? -1 :
                        o1.analysis() > o2.analysis() ? 1 :
                                0;  // o1 == o2
            }
        });
    }


    /**
     * Executes an A* search, beginning at the source Node and seeking a Node
     * that satisfies the isGoal requirement.
     */
    public Node search(Node source) {
        // source node f (full analysis) is (weight=0) + heuristic
        // add source to open set
        openSet.add(source);
        // while open set isn't empty
        while (!openSet.isEmpty()) {
            // get n = smallest element from open set
            Node n = openSet.poll();
            System.out.println("Expanding node "+n+" (cost: " + n.analysis() + ")");
            closedSet.add(n);

            if (n.isGoal()) {
                return n;
            }
            // generate successors of n
            ArrayList<Node> successors = n.genChildren();
            for (Node k : successors) {
                improve(n, k);
            }
        }
        return null;  // no solution found
    }


    /**
     * Relaxation procedure. Updates the path and associated costs between
     * nodes from and to.
     */
    private void improve(Node from, Node to) {
        System.out.print(to);
        //System.out.print("improve subroutine:");
        // 'to' generated already but not yet expanded, and this is a better path
        if (openSet.contains(to)) {
            if (from.getCost() + 1/*w(from, to)*/ < to.getCost()) {
                System.out.print("\tupdating element in openset");
                if (!openSet.remove(to)) {
                    System.out.println("Error locating element");
                    System.exit(3);
                }
//                to.setParent(from);
                // set f (to) = from.getCost() + w(from, to) + h(to)
//                to.setCost(from.getCost() + 1/*w(from, to)*/);  // update solution estimate

                // update openSet's 'to'
                openSet.add(to);
            }
        }
        // 'to' already expanded, but this is a better path
        else if (closedSet.contains(to)) {
            if (from.getCost() + 1/*w(from, to)*/ < to.getCost()) {
                System.out.print("\tupdating element in closedset");
//                "Removed closed element with cost: " + to.
//                to.setParent(from);
                // set f (to) = from.getCost() + w(from, to) + h(to)
//                to.setCost(from.getCost() + 1/*w(from, to)*/);  // update solution estimate

                if (!closedSet.remove(to)) {
                    System.out.println("Error locating element");
                    System.exit(4);
                }
                openSet.add(to);
            }
        }
        // 'to' not seen before
        else {
            System.out.print("\tnew element");
//            to.setParent(from);
            // set f (to) = from.getCost() + w(from, to) + h(to)
//            to.setCost(from.getCost() + 1/*w(from, to)*/);  // set solution estimate
            openSet.add(to);
        }
        System.out.println("");
    }


}
