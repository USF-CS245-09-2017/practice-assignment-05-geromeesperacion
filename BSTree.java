/**
 * 
 * @author geromeesperacion
 *
 */

/*
 * This class is used to construct a binary search tree.  It contains the
 * functions for adding, removing, and finding a value in the tree.
 */
public class BSTree {
	
	private BSTNode root;
	
	//constructor
	public BSTree() {
		this.root = null;
	}
	
	/*
	 * inserts a node into the BST
	 */
	public BSTNode insert(String value, BSTNode node) {
		
		//base case
		if(node == null) {
			return new BSTNode(value);
		}
		
		if(value.compareTo(node.data) < 0) {
			node.left = insert(value, node.left);
			return node;
		} else {
			node.right = insert(value, node.right);
			return node;
		}
	}

	public void insert(String value) {
		root = insert(value, root);
	}
	
	/*
	 * finds the node in the tree and returns true if found
	 */
	public boolean find(String value, BSTNode node) {
		
		//base case
		if(node == null) {
			return false;
		}
		
		if(value.compareTo(node.data) == 0) {
			return true;
		} else if(value.compareTo(node.data) < 0) {
			return find(value, node.left);
		} else {
			return find(value, node.right);
		}
	}
	
	public boolean find(String value) {
		return find(value, root);
	}
	
	/*
	 * deletes the node from the tree
	 */
	private BSTNode delete (String value, BSTNode node) {
		
		//base case
		if(node == null) {
			return null;
		}
		
		if(value.compareTo(node.data) == 0) {
			if(node.left == null) {
				return node.right;
			} else if(node.right == null) {
				return node.left;
			} else {
				if(node.right.left == null) {
					node.data = node.right.data;
					node.right = null;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
			
		} else if(value.compareTo(node.data) < 0) {
			node.left = delete(value, node.left);
			return node;
		} else {
			node.right = delete(value, node.right);
			return node;
		}
		
	}
	
	public void delete(String value) {
		root = delete(value, root);
	}
	
	/*
	 * removes the smallest value node on the tree
	 */
	public String removeSmallest(BSTNode node) {
		
		//base case
		if(node.left.left == null) {
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		
		return removeSmallest(node.left);
	}
	
	/*
	 * returns contents stored in BST in sorted order
	 */
	public String toStringInOrder(BSTNode node) {
		String result = "";
		
		if(node != null) {
			result = result + toStringInOrder(node.left);
			result = result + node.data + " ";
			result = result + toStringInOrder(node.right);
		}
		
		return result;
	}
	
	public String toStringInOrder() {
		return toStringInOrder(root).trim();
	}
	
	/*
	 * returns a copy of contents stored in BST in pre-order
	 * i.e. root node, followed by left child, then right child
	 */
	public String toStringPreOrder(BSTNode node) {
		
		String result = "";
		
		if(node != null) {
			result = result + node.data + " ";
			result = result + toStringPreOrder(node.left);
			result = result + toStringPreOrder(node.right);
			
		}
		
		return result;
	}
	
	public String toStringPreOrder() {
		return toStringPreOrder(root).trim();
	}
}
