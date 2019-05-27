/**
* This program develops a custom class of movies. It will read a comma-separated text file of movies with the title, year, rating, and review.
* Then it will output the information in a binary tree in another text file. The user can specify if the order is preorder, postorder, or inorder.
*
* CSC 1351 Programming project No 4
* Section 1
*
* @author Xinmei Guo
* @since 4/1/2019
*
*
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog04_bstOrderedList {

	
	/**
	 * GetInputFile
	 * Takes user input for text file name and returns aOrderedList 
	 * Checks that file name is valid and asks user to re-enter if it isn't.
	 */
	
	public Scanner GetInputFile(String UserPrompt) throws FileNotFoundException{
		File inFile = new File(UserPrompt);
		
		try {
			Scanner in = new Scanner(inFile);
			return in;
		}
		
		catch(IOException e){
			String menu;
			String[] yesNo = {"y", "n"}; 
			System.out.printf("File specified %s does not exist. Would you like to continue? (y/n)", UserPrompt);
			
	        //Checks that user input is valid
	        Scanner inYN = new Scanner(System.in);
	        menu = isMenuValid(inYN, yesNo, "y or n");
	        if (menu.equals("y")) {
	        	Scanner in2 = new Scanner(System.in);
	        	System.out.println("Enter file name");
	        	String UserPrompt2 = in2.next();
	        	return GetInputFile(UserPrompt2);
	        }
			throw(e);
		}
	}
	
	/**
	 * ScanToList
	 * Takes Scanner in and scans into list
	 * Checks that file name is valid and asks user to re-enter if it isn't.
	 * @param list: llOrderedList created from reading input file
	 * @param splitted: array of words from reading the line separated by commas
	 */

	public bstOrderedList ScanToList(Scanner in) {
		String[] splitted;
		bstOrderedList list = new bstOrderedList();
		while (in.hasNextLine()) {
				//split with comma as delimiter
	        	splitted = in.nextLine().split(",");
	        	//Add this to list
	        	if (splitted[0].equals("A")) {
	        		//make a new Movie
	        		Movie movie = new Movie(splitted[1], Integer.parseInt(splitted[2]), splitted[3], Integer.parseInt(splitted[4]));
	        		list.add(movie);
	        	} 
	        	//Delete this from list
	        	else if (splitted[0].equals("D")) {
	        		Movie removeThisMovie = new Movie(splitted[1], Integer.parseInt(splitted[2]),"",0);
	        		list.remove(removeThisMovie);
	        	}		  
		   }//while		 
		return list; 
	}
	
	
	/**
	 * IsMenuValid
	 * Makes sure user enters y or no when typing input or output file name
	 */
	
    public static String isMenuValid(Scanner in, String[] m, String mName) {
        while(true) {
            String d = in.next();   
            for (int i = 0; i < m.length; i++) {
                if (d.equals(m[i])) 
                    return d;
            }
            System.out.printf("Invalid %s (%s) entered.\n", mName, d); 
            System.out.printf("Enter %s: ", mName);
        }//while
    }// end isMenuValid
	
    
	/**
	 * GetOutputFile
	 * User can choose where to save file and what name to use
	 * If user chose invalid location, they can try again
	 * @returns PrintWriter out
	 */	
	
	public PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException{		
		try {
			PrintWriter out = new PrintWriter(UserPrompt);
			return out;
		}
		catch(IOException e) {
			System.out.println("You need to save a txt file!");
			
			String menu;
			String[] yesNo = {"y", "n"}; 
			System.out.printf("You entered an invalid file name. File name should be in the format of name.txt\n Would you like to continue? (y/n)", UserPrompt);
			
	        //Checks that user input is valid
	        Scanner inYN = new Scanner(System.in);
	        menu = isMenuValid(inYN, yesNo, "y or n");
	        if (menu.equals("y")) {
	        	Scanner in = new Scanner(System.in);
	        	System.out.println("Enter file name");
	        	UserPrompt = in.next();
	        	return GetOutputFile(UserPrompt);
	        }
			throw(e);
		}
	}
	
	/**
	 * PrintToText
	 * Prints PrintWriter to output text file
	 */	
	
	
	public void PrintToText(PrintWriter out, bstOrderedList list, String sorting) {
		out.print(list.toString(sorting));
	}
    
	public void PrintArray(PrintWriter out, bstOrderedList list, String sorting) {
		Comparable[] array = list.toArray(sorting);
		for (int i = 0; i < array.length; i++) {	
			out.println(array[i]);
		}
	}
	
    
	public static void main(String[] args) throws FileNotFoundException {
		// Define variables
		String address, outname, sorting, compactPretty;
		bstOrderedList movielist;
		String[] menuOrder = {"preorder", "inorder", "postorder"};
		String[] inorderFormat = {"compact", "prettyprint"};
		Comparable [] array;
		
		//Asks for name of input file 
        System.out.println("Enter input filename (input.txt): ");
		Scanner in = new Scanner(System.in);
		address = in.next();
		
		//Opens input file and puts it in aOrderedList
		Prog04_bstOrderedList a = new Prog04_bstOrderedList();
		Scanner in2 = a.GetInputFile(address);
		movielist = a.ScanToList(in2);
		
		//Gets name of output file from user
		Scanner in3 = new Scanner(System.in);
        System.out.println("Enter output filename (output.txt): ");
		outname = in3.next();

		//Gets PrintWriter 
		PrintWriter outhere = a.GetOutputFile(outname);
		
		//Asks user what order binary tree should be in
		System.out.println("What order? (preorder/inorder/postorder)");
		Scanner in4 = new Scanner(System.in);
		sorting = isMenuValid(in4, menuOrder, "preorder/inorder/postorder");

		//Prints to output text file
		a.PrintToText(outhere, movielist, sorting);

		//Closing scanners
		in.close();
		in2.close();
		in3.close();
		in4.close();
		outhere.close();
		
	}

}
