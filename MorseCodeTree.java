import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root;

	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode - a copy of newNode will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * @param code - the code for the new node to be added, example ".-."
	 * @param letter - the letter for the corresponding code, example "r"
	 * @return the MorseCodeTree with the new node added
	 */
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code. A '.' (dot) means traverse to the left. A "-" (dash)
	 * means traverse to the right. The code ".-" would be stored as the right child
	 * of the left child of the root Algorithm for the recursive method:
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if (code.length() == 1) {
			
			if (goLeft(code))
				root.left = new TreeNode(letter);
			else
				root.right = new TreeNode(letter);
			
		} else {
			
			String newCode = code.substring(1);
			if (goLeft(code))
				addNode(root.left, newCode, letter);
			else
				addNode(root.right, newCode, letter);
		}
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	public String fetch(String code) {
		System.out.println(":" + code + ":");
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code A '.' (dot) means traverse to the left. A "-"
	 * (dash) means traverse to the right. The code ".-" would fetch the data of the
	 * TreeNode stored as the right child of the left child of the root
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {

		if (code.equals(""))
			return root.data;
		else if (goLeft(code))
			return fetchNode(root.left, code.substring(1));
		else
			return fetchNode(root.right, code.substring(1));
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * @param data - data of node to be deleted
	 * @return reference to the current tree
	 * @throws java.lang.UnsupportedOperationException
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * @return reference to the current tree
	 * @throws java.lang.UnsupportedOperationException
	 */
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level
	 * by level based on the code. The root will have a value of "" (empty string)
	 * level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i");
	 * insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. Look at the
	 * tree and the table of codes to letters in the assignment description.
	 */
	public void buildTree() {
		
		root = new TreeNode("");
		String[] codes = { ".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--.", "---",
				"....", "...-", "..-.", ".-..", ".--.", ".---", "-...", "-..-", "-.-.", "-.--", "--..", "--.-" };
		String[] letters = { "e", "t", "i", "a", "n", "m", "s", "u", "r", "w", "d", "k", "g", "o", "h", "v", "f", "l",
				"p", "j", "b", "x", "c", "y", "z", "q" };
		
		for (int i = 0; i < 26; i++)
			insert(codes[i], letters[i]);
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> asArrList = new ArrayList();
		LNRoutputTraversal(root, asArrList);
		return asArrList;
		
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if (root == null)
			return;
		
		LNRoutputTraversal(root.left, list);
		list.add(root.data);
		LNRoutputTraversal(root.right, list);
		
	}

	private boolean goLeft(String code) {
		return code.charAt(0) == '.';
	}
}
