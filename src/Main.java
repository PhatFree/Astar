import java.io.FileReader;
import java.util.*;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        // initialize data structure
        String in_filename = "src/input_case3.txt";

        if (args.length > 0)
            in_filename = args[0];
        System.out.println("source file: " + in_filename);

        int size = 0;
        int cakes[] = {};
        Scanner in;
        try {
            in = new Scanner(new FileReader(in_filename));
            size = in.nextInt();
            if (size == 0) {
                System.out.println("Error: input size is zero");
            }
            cakes = new int[size];
            for (int i = 0; i < size; i++) {
                cakes[i] = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: failed to open file");
            System.exit(1);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Error: input improperly formatted. " +
                    "Requires an integer length followed by #length integers");
            System.exit(2);
        }

        System.out.print("The list:");
        for (int i = 0; i < size; i++)
            System.out.print(" " + cakes[i]);
        System.out.println();

        //create root node
        Node root = new Node(cakes, size, null);

        // do the A* search
        AStar seeker = new AStar();
        Node goal = seeker.search(root);
        System.out.println();

        if (goal == null)
            System.out.println("No solution found");
        else {
            ArrayList<Node> path = goal.getPath();
            System.out.println("Path from root to goal:");
            for (Node node : path) {
                System.out.println(node);
            }
            System.out.println("Total Number of Reversals: " + (path.size() - 1));
        }
    }
}
