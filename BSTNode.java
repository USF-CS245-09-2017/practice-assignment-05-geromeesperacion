/**
 * 
 * @author geromeesperacion
 *
 */

/*
 * This class allows users to create a node for a binary search tree.
 */
public class BSTNode {
		
	protected String data;
	protected BSTNode left;
	protected BSTNode right;
	
	//constructor
	public BSTNode(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public String getData() {
		return data;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setLeft(BSTNode data) {
		left = data;
	}
	
	public void setRight(BSTNode data) {
		right = data;
	}
	
}
