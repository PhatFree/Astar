import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Properties;


public class AStar
{

    // TODO moar vars
    private int numNodesExpanded;  // number of nodes removed from open set
    PriorityQueue<Node> openSet;
    PriorityQueue<Node> closedSet;

    public AStar()
    {
	// init open set as empty
        openSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return ((Node) o1).getCost() - ((Node) o2).getCost();
            }
        });

        // init closed set as empty
        closedSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return ((Node) o1).getCost() - ((Node) o2).getCost();
            }
        });
    }



    /**
     * Executes an A* search, beginning at the source Node and seeking a Node
     * that satisfies the isGoal requirement.
     */
    public boolean search(Node source)
    {
	    // TODO return type
	    // source node f (full analysis) is weight=0 + heuristic
	    // add source to open set
        openSet.add(source);
	    // while open set isn't empty
		// get n = most smol element from open set
        Node temp = openSet.poll();
		// (add n to closed set)
        closedSet.add(temp);

		// if n is a goal node
        if(temp.isGoal())
        {    // return n or path to n or whatever we return
        }
        openSet.addAll(temp.genChildren());    // generate successors of n
		    // for each successor k
			// improve ( n, k )
    if (openSet.isEmpty())
        return false;
	return false;  // no solution found
    }


    /**
     * Relaxation procedure. Updates the path and associated costs between
     * nodes from and to
     */
    public void improve(Node from, Node to)
    {
	// to generated already but not yet expanded, and this is a better path
	if (to is in open) and (g(from) + w(from,to) < g(to))
		to -> setParent( from )
		set f(to) = g(from) + w(from,to) + h(to)  // update solution estimate
	// to already expanded, this is a better path
	else if (to is in closed) and (g(from) + w(from,to) < g(to))
		to -> setParent( from )
		set f(to) = g(from) + w(from,to) + h(to)  // update solution estimate
		closed -> remove( to )
		open -> add( to )
	// to not seen before
	else
		to -> setParent( from )
		set f(to) = g(from) + w(from,to) + h(to)  // set solution estimate
		open -> add( to )

	return null;
    }

    /**
     * Constructs and returns the most recent path discovered.
     * Returns null if no search has been made, or no path was discovered.
     */
    public void getPath()
    {
	/*TODO return type*/
	return null;
    }


}
