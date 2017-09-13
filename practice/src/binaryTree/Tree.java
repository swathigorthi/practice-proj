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
        	   inOrder(root.left);
           System.out.println(root.value);
    		   inOrder(root.right);
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
   
   public static class MinMaxValue{
	   private int value;
	   public MinMaxValue(int value){
		   this.value = value;
	   }
	   public void setValue(int value){
		   this.value = value;
	   }
	   public int getValue(){
		   return value;
	   }
   }
   
   public boolean isBalanced(){
	   MinMaxValue min = new MinMaxValue(Integer.MAX_VALUE);
	   MinMaxValue max = new MinMaxValue(Integer.MIN_VALUE);
	   findDepth(root, 0,min , max);
	   return (max.getValue()-min.getValue()) <=1;
   }
   
  
   
   public void findDepth(Node node, Integer depth, MinMaxValue min, MinMaxValue max){
	   System.out.println(node.value+","+depth+","+min.getValue() + "," + max.getValue());
	   if(node.left ==null && node.right == null){
		   System.out.println("Altered min max");
		   min.setValue(Math.min(min.getValue(), depth));
		   max.setValue(Math.max(max.getValue(), depth));
		   System.out.println(node.value+","+depth+","+min.getValue() + "," + max.getValue());
	   }
	   else{
		   if(node.left!=null){
			   findDepth(node.left, depth+1, min, max);
		   }
		   if(node.right!=null){
			   findDepth(node.right, depth+1, min, max);
		   }
	   }
   }
   
   public static class Result{
	   private boolean n1Found;
	   private  boolean n2Found;
	   private Node ca;
	public Result(boolean n1Found, boolean n2Found, Node ca) {
		super();
		this.n1Found = n1Found;
		this.n2Found = n2Found;
		this.ca = ca;
	}
	public boolean isN1Found() {
		return n1Found;
	}
	public void setN1Found(boolean n1Found) {
		this.n1Found = n1Found;
	}
	public boolean isN2Found() {
		return n2Found;
	}
	public void setN2Found(boolean n2Found) {
		this.n2Found = n2Found;
	}
	public Node getCa() {
		return ca;
	}
	public void setCa(Node ca) {
		this.ca = ca;
	}
   }
   
   public Node findCommonAncestor(Node n1, Node n2){
	   Result res = find(root, n1,n2);
	   return res.ca;
   }
   
   public Result find(Node n, Node n1, Node n2){
	   if(n.equals(n1)){
		   Result lr = n.left!=null ? find(n.left, n1, n2) : new Result(false, false, null);
		   Result rr = n.right!=null ? find (n.right, n1, n2) : new Result(false, false, null);
		   return new Result(n.equals(n1),lr.n2Found||rr.n2Found ,null);
	   }
	   if(n.equals(n2)){
		   Result lr = n.left!=null ? find(n.left, n1, n2) : new Result(false, false, null);
		   Result rr = n.right!=null ? find (n.right, n1, n2) : new Result(false, false, null);
		   return new Result(lr.n1Found || rr.n1Found,n.equals(n2) ,null);
	   }
	   Result lr = n.left!=null ? find(n.left, n1, n2) : new Result(false, false, null);
	   Result rr = n.right!=null ? find (n.right, n1, n2) : new Result(false, false, null);
	   
	   Result r = new Result(lr.n1Found || rr.n1Found, lr.n2Found||rr.n2Found , null);
	   if(lr.getCa() !=null){
		   r.setCa(lr.getCa());
	   }
	   else if(rr.getCa() !=null){
		   r.setCa(rr.getCa());
	   }
	   if(r.n1Found && r.n2Found && r.getCa() == null){
		   r.setCa(n);;
	   }
	   return r;
   }
}
