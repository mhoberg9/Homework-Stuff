package de.tuberlin.ise.prog1.data;


/**
 * A Binary Tree Class that stores {@link TreeData}-Objects
 */
public class BinTree <T extends TreeData> {
	Node <T> root;
	int size = 0;

    /**
     * Insert a new TreeData Object into the three
     * @param data object to be inserted
     */
	
	public void insert(TreeData data){
		if(root == null){
			root = new Node <T>(data);
		} else {
			root.insert(new Node <T>(data));
		}
		size++;
	}
	
    /**
     * Number of elements in the Tree
     * @return
     */
	public int size(){
	    return this.size;
    }

	private void toString(Node <T> node,StringBuilder builder){
		builder.append("[");
		if(node != null){
			
			if(node.getLeft() != null){
				toString(node.getLeft(),builder);
				builder.append("<");
			} else {
				builder.append("NULL<");
			}
			
			builder.append(node.getData());
			
			if(node.getRight() != null){
				builder.append(">");
				toString(node.getRight(),builder);
			} else {
				builder.append(">NULL");
			}
			
		}
		builder.append("]");
	}
	
    /**
     * @return String representaton of this Tree
     */
	public String toString(){
		StringBuilder b = new StringBuilder();
		toString(root,b);
		return b.toString();
	}

    /**
     * Searchs for a Node that contains a TreeData element that is equal to the
     * given element.
     * @param s Element to be serached for
     * @return the first Node that contains an equivalent element or null if non can be found
     */
	private Node <T> findNode(TreeData s){
		if(TreeData.compareTo(root.getData(),s) == 0){
			return root;
		} else {
			return  root.find(s);
		}
		
	}

    /**
     * finds a TreeData Object equivalent to the one specified
     * @param s
     * @return
     */
	public TreeData find(TreeData s){
		Node <T> node = findNode(s);
		if(node != null){
		    return node.getData();
        } else {
		    return null;
        }
	}

	/**
     * Removes the node that matches the given data form this tree
     * @param data
     * @return the deleted data element or null
     */
	public TreeData delete(TreeData data){
	    //we only need to do something if a root exists
		if(root != null){
		    Node <T> node = findNode(data);


            //we only need to modify size if we actually deleted anything
            if(node != null){
                root = root.delete(data);
                size--;
                return node.getData();
            }
		}
        return null;
    }
}
