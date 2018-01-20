package de.tuberlin.ise.prog1.data;

public class TreeTester {
	public static void main(String[] args) {
		IntData[] rawTree = IntData.makeFromIntArray(7,2,1,5,6,12,15);
		
		@SuppressWarnings("rawtypes")
		BinTree tree = new BinTree();
		
		for (int i = 0; i < rawTree.length; i++) {
			tree.insert(rawTree[i]);
		}
		
		System.out.println(tree);
		
//		tree.delete(new IntData(15));
//		System.out.println(tree);
//		
//		tree.delete(new IntData(7));
//		System.out.println(tree);
	}
}