import java.util.ArrayList;

public class bstOrderedList {
	
	private Node root; //root element in binary search tree
	static int count;
	
	
	class Node {
		public Node leftChild;
		public Comparable data;
		public Node rightChild;
		
	    public void addNode(Node newNode)
	      {  
	         int c = newNode.data.compareTo(data);
	         if (c < 0)
	         {  
	            if (leftChild == null) {
	            	leftChild = newNode;
	            	}
	            else {
	            	leftChild.addNode(newNode);
	            	}
	         }
	         else if (c > 0)
	         {  
	            if (rightChild == null) {
	            	rightChild = newNode;
	            	}
	            else {
	            	rightChild.addNode(newNode);
	            	}
	         }
	         count++;
	      }//addNode
	}//class Node
	
	//Constructor
	public bstOrderedList() {
		root = null;
		count = 0;
	}

	
	public void add(Comparable newObject) {
		Node newNode = new Node();
		newNode.data = newObject;
		newNode.leftChild = null;
		newNode.rightChild = null;
		if (root == null) {
			root = newNode;
		}
		else {
			root.addNode(newNode);
		}
	}//add
	
	 public void remove(Comparable newObject) {
	      // Find node to be removed

	      Node toBeRemoved = root;
	      Node parent = null;
	      boolean found = false;
	      while (!found && toBeRemoved != null)
	      {
	         int d = toBeRemoved.data.compareTo(newObject);
	         if (d == 0) { found = true; }
	         else 
	         {
	            parent = toBeRemoved;
	            if (d > 0) { toBeRemoved = toBeRemoved.leftChild; }
	            else { toBeRemoved = toBeRemoved.rightChild; }
	         }
	      }

	      if (!found) { return; }

	      // toBeRemoved contains newObject

	      // If one of the children is empty, use the other

	      if (toBeRemoved.leftChild == null || toBeRemoved.rightChild == null)
	      {
	         Node newChild;
	         if (toBeRemoved.leftChild == null) 
	         {
	            newChild = toBeRemoved.rightChild;
	         }
	         else 
	         {
	            newChild = toBeRemoved.leftChild;
	         }

	         if (parent == null) // Found in root
	         {
	            root = newChild;
	         }
	         else if (parent.leftChild == toBeRemoved)
	         {
	            parent.leftChild = newChild;
	         }
	         else 
	         {
	            parent.rightChild = newChild;
	         }
	         return;
	      }
	      
	      // Neither subtree is empty

	      // Find smallest element of the right subtree

	      Node smallestParent = toBeRemoved;
	      Node smallest = toBeRemoved.rightChild;
	      while (smallest.leftChild != null)
	      {
	         smallestParent = smallest;
	         smallest = smallest.leftChild;
	      }

	      // smallest contains smallest child in right subtree
	         
	      // Move contents, unlink child

	      toBeRemoved.data = smallest.data;
	      if (smallestParent == toBeRemoved) 
	      {
	         smallestParent.rightChild = smallest.rightChild; 
	      }
	      else 
	      {
	         smallestParent.leftChild = smallest.rightChild; 
	      }
	      count--;
	   }//remove
	 
	 /**
	  * Size
	  * @return count - size of binary tree
	  */
		
	public int size() {
		return count;
	}//size
		
	public int nodeCount(Node node, int n) {
		if (root != null) {
			n++;
			n = nodeCount(node.leftChild, n);
			n = nodeCount(node.rightChild, n);
		}
		return n;
	}//nodeCount
		
	//returns true if the list is empty, false otherwise
	public boolean isEmpty() {
		if (root==null) {
			return true;
		}
		else {
			return false;
		}
	}//isEmpty
	
	/*
	 * toString
	 * Prints binary tree in user-specified order
	 * Order can be: preorder, inorder, postorder
	 * @returns String 
	 */
	
	
	public String toString(String sorting) {

		if (sorting.equals("preorder")){
			return printPreorder(root);
		}
		else if (sorting.equals("inorder")) {			
			return printInorder(root);
		}
		else { //postorder
			return printPostorder(root);
		}
	}

	
	//inorder
	private String printInorder(Node parent) {
		if (parent == null) {
			return "";
		}
		else {
			String s = printInorder(parent.leftChild) + "\r\n"+ parent.data + "\r\n"+ printInorder(parent.rightChild);
			return s;
		}
	}
	
	//preorder
	private String printPreorder(Node parent) {
		if (parent == null) {
			return "";
		}
		else {
			String s = parent.data + "\r\n" + printPreorder(parent.leftChild) + "\r\n"+ printPreorder(parent.rightChild);
			return s;
		}
	}
	
	//postorder
	private String printPostorder(Node parent) {
		if (parent == null) {
			return "";
		}
		else {
			String s = parent.data + "\r\n" + printPostorder(parent.leftChild) + "\r\n"+ printPostorder(parent.rightChild);
			return s;
		}
	}
	
	/**
	 * Converts binary tree to array
	 * @param sorting
	 * @return array
	 */
	
	public Comparable[] toArray(String sorting) {
		// TODO Auto-generated method stub
		Comparable [] array = listToArray(sorting, root);
		return array;
	}
	
	private Comparable[] listToArray(String sorting, Node parent) {
		
		//constructs the contents of the tree in the order provided by sorting parameter
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		
		if (sorting.equals("preorder")){
			list = preorder(parent);
		}
		else if (sorting.equals("inorder")) {
			list = inorder(parent);
		}
		else if (sorting.equals("postorder")) {
			list = postorder(parent);
		}
		
		Comparable [] array= ArrayListToArray(list);
		
		return array;
	}

	private ArrayList<Comparable> postorder(Node parent) {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		if (parent == null) {
			return list;
		}
		else {
			postorder(parent.leftChild);
			postorder(parent.rightChild);
			list.add(parent.data);
			
		}
		return list;
	}
	
	private ArrayList<Comparable> preorder(Node parent) {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		if (parent == null) {
			return list;
		}
		else {
			list.add(parent.data);
			preorder(parent.leftChild);
			preorder(parent.rightChild);
			return list;
		}
	}
	
	private ArrayList<Comparable> inorder(Node parent) {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		if (parent == null) {
			return list;
		}
		else {
			inorder(parent.leftChild);
			list.add(parent.data);
			inorder(parent.rightChild);
			return list;
		}
	}
	
	
	/**
	 * ArrayListToArray
	 * Takes in input from Scanner into an array list
	 * Transfers content from array list to array
	 * @param in: Scanner
	 * @param array: array with tokens from input text file
	 */
	
	
	public Comparable[] ArrayListToArray(ArrayList<Comparable> list){
		
		 Comparable [] array = new Comparable[count];
		 for (int i=0; i<count; i++) {
			 array[i] = list.get(i);
		 }
		 return array;
	}
	
}
