
public class TreeNode<E> {

	E data;
	TreeNode<E> left;
	TreeNode<E> right;
	
	private TreeNode(E d, TreeNode<E> l, TreeNode<E> r) {
		data = d;
		left = l;
		right = r;
	}
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(E dataNode) {
		this(dataNode, null, null);
	}
	
	/**
	 * used for making deep copies
	 * @param other - node to make copy of
	 */
	public TreeNode(TreeNode<E> other) {
		this(other.data, other.left, other.right);
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public E getData() {
		return data;
	}
}
