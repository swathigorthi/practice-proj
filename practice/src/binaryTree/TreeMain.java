package binaryTree;

public class TreeMain {

	public static void main(String[] args) {
	 Node n11= new Node(11);
	 Node n12 = new Node(12);
	 Node n8 = new Node(8, null, n11);
	 Node n10 = new Node(10, null, n12);
	 Node n9 = new Node(9);
	 Node n4 = new Node(4);
	 Node n5 = new Node(5);
	 Node n6 = new Node(6, n8, n9);
	 Node n7 = new Node(7, null, n10);
	 Node n2 = new Node(2, n4,n5);
	 Node n3 = new Node(3, n6,n7);
	 Node n1 = new Node(1, n2, n3);
	 
	 Tree t = new Tree(n1);
	 System.out.println(t.findCommonAncestor(n6, n3).value);
	 
		
		

	}

}
