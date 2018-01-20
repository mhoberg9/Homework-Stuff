package BinTree_Übung;

public class BTree {

	Node root;

	public void insert(int value) {
		if (root == null) {
			root = new Node();
			root.value = value;
		} else {
			insert(value, root);
		}
	}

	public void insert(int value, Node currentNode) {
		if (value > currentNode.value) {
			if (currentNode.right == null) {
				currentNode.right = new Node();
				currentNode.right.value = value;
			} else {
				insert(value, currentNode.right);
			}
		} else if (value < currentNode.value) {
			if (currentNode.left == null) {
				currentNode.left = new Node();
				currentNode.left.value = value;
			} else {
				insert(value, currentNode.left);
			}
		}
	}

	public Node findNode(int value) {
		if (root.value == value){
			return root;
		}
		
		if (root == null){
		return null;
		} else {
			findNode(value, root);
		}
	return null;
	}
	
	public Node findNode (int value, Node currentNode){
		
		if (value > currentNode.value){
			findNode(value, currentNode.right);
		}
		
		if (value < currentNode.value){
			findNode(value, currentNode.right);
		}
		
		if (value == currentNode.value){
			return currentNode;
		}
		
		return null;
	}
	
	

	public String toStrint() {

		return null;
	}
}
