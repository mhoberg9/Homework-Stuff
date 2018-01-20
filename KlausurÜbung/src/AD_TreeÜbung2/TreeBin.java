package AD_TreeÜbung2;

public class TreeBin {
	
	Node root;

	public void insert (int value){
		if (root == null){
			root = new Node ();
			root.value = value;
		} else {
			insert (value, root);
		}
		
	}
	
	public void insert (int value, Node currentNode){
		if (value > currentNode.value){
			if (currentNode.right == null){
				currentNode.right = new Node();
				currentNode.right.value = value;
			} else {
				insert (value, currentNode.right);
			}
		}
		
		if (value < currentNode.value){
			if(currentNode.left == null){
				currentNode.left = new Node();
				currentNode.left.value = value;
			} else {
				insert(value, currentNode.left);
			}	
		}
		
	}
	
	public Node findNode(int value){
		if (root == null){
			return null;
		}
		
		if (root.value == value){
		return root;
			} else {
				findNode (value, root);
			}
		return null;
	}
	
	public Node findNode(int value, Node currentNode){
		
		if (value > currentNode.value){
			if (currentNode.right != null){
			findNode(value, currentNode.right);
			} else {
				return null;
			}
		}
		if (value < currentNode.value ){
			if(currentNode.left != null){
				findNode(value, currentNode.left);
			} else {
				return null;
			}
		}
		if (value == currentNode.value){
			return currentNode;
		}
		
		
		
//		if (value > currentNode.value){
//			if (currentNode.right != null){
//				if(currentNode.right.value == value){
//					return currentNode.right;
//				} else {
//					findNode(value, currentNode.right);
//				}
//			} else {
//				return null;
//			}
//		}
//		if (value < currentNode.value){
//			if (currentNode.left != null){
//				if (currentNode.left.value == value){
//					return currentNode.left;
//				} else {
//					findNode (value, currentNode.left);
//				}
//			} else {
//				return null;
//			}
//		}
	return null;
	}
	
	public String toString(){
		
		return null;
	}
}
