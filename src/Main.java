import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // initialize data structure
	String in_filename = "src/input.txt";
	String out_filename = "output.txt";

	if (args.length > 0)
	    in_filename = args[0];
	if (args.length > 1)
	    out_filename = args[1];
	System.out.println("source file: " + in_filename);
	System.out.println("output file: " + out_filename);
	
	int size = 0;
	int cakes[] = {};
	Scanner in = null;
	try {
	    in = new Scanner(new FileReader(in_filename));
	    size = in.nextInt();
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
	    System.out.println("Error: input improperly formatted");
	    System.exit(1);
	}

	System.out.print("The list:");
	for (int i = 0; i < size; i++)
	    System.out.print(" " + cakes[i]);
	System.out.println();

	//create root node
	Node root = new Node(cakes,size,null);

	// do the A* search

	// write the output to out_file
	// 	sequence of reversals to complete the sort
	//	number of nodes expanded in the search
	//		(aka nodes deleted from the OPEN set)
    }
}
