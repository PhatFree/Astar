
public class AStar
{

    // TODO moar vars
    private int numNodesExpanded;  // number of nodes removed from open set

    public AStar()
    {
	// init open set as empty
	// init closed set as empty
	;
    }



    /**
     * Executes an A* search, beginning at the source Node and seeking a Node
     * that satisfies the isGoal requirement.
     */
    public void search(Node source)
    {
	// TODO return type
	// source node f (full analysis) is weight=0 + heuristic 
	// add source to open set
	// while open set isn't empty
		// get n = most smol element from open set
		// (add n to closed set)

		// if n is a goal node
			// return n or path to n or whatever we return
		// generate successors of n
		// for each successor k
			// improve ( n, k )

	return null;  // no solution found
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
