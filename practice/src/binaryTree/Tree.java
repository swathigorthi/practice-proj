package binaryTree;

import java.util.HashSet;
import java.util.Set;

public class Tree {
    public Node root;
    
    public Tree(int valueue){
    	Node root = new Node(valueue);
    	this.root = root;
    }
    
    public Tree(Node root){
    	this.root = root;
    }
    
    public void inOrder(){
    	inOrder(root);
    }
    
    public void inOrder(Node root){
        if(root!=null){
    	   Node left = root.left;
    	   Node right = root.right;
           if(left!=null){
        	   inOrder(left);
           }
           System.out.println(root.value);
    	   if(right!=null){
    		   inOrder(right);
    	   }
    	}
    }
    
    public Tree getSampleBinaryTree(){
    	Node node1 = new Node(4);
		Node node2 = new Node(5);
		Node node3 = new Node(6);
		Node node4 = new Node(7);
		Node node5 = new Node(2, node1, node2);
		Node node6 = new Node(3, node3, node4);
		Node node7 = new Node(1, node5, node6);
		Tree tree = new Tree(node7);
		return tree;
    }
    
    public static boolean isBST(Node root){
        Node left = root.left;
           Node right = root.right;
        if(left!=null && left.value >root.value)  {
               return false;
           }
           if(right!=null && right.value<root.value){
               return false;
           }
       Set<Node> allRoots = new HashSet<Node>();
       allRoots.add(root);
       boolean isLeftBST = root.left==null ||isBST(root.left, true, allRoots);
       boolean isRightBST = root.right==null || isBST(root.right, false, allRoots);
       return  isLeftBST && isRightBST;
   }
   
   public static boolean isBST(Node root, boolean isLeft, Set<Node> allRoots){
        Node left = root.left;
           Node right = root.right;
           if(left!=null && left.value >root.value)  {
               return false;
           }
           if(right!=null && right.value<root.value){
               return false;
           }
       
       
        if(!allRoots.isEmpty()){
            if(isLeft){
                for(Node n: allRoots){
                       if(left!=null && left.value>n.value){
                           return false;
                       }
                       if(right!=null && right.value>n.value){
                           return false;
                       }     
                   }
            }
            else{
                for(Node n: allRoots){
                       if(left!=null && left.value<n.value){
                           return false;
                       }
                       if(right!=null && right.value<n.value){
                           return false;
                       }     
                   }
            }       
           allRoots.add(root);
           boolean isLeftBST = left==null ||isBST(left, isLeft, allRoots);
           boolean isRightBST = right==null || isBST(right, isLeft, allRoots);
           return  isLeftBST && isRightBST;
       }
       
       return true;
   }
}
