package binaryTree;

public class TreeMain {

	public static void main(String[] args) {
		Node node1 = new Node(4);
		Node node2 = new Node(5);
		Node node3 = new Node(6);
		Node node4 = new Node(7);
		Node node5 = new Node(2, node1, node2);
		Node node6 = new Node(3, node3, node4);
		Node node7 = new Node(1, node5, node6);
		Tree tree = new Tree(node7);
		tree.inOrder();
		
		

	}

}
