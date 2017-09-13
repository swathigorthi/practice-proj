package codingInterview;

import java.util.ArrayList;
import java.util.List;


//Problem 3.2
public class StackWithMin {
  List<NodeWithMin> list = new ArrayList<>();
   int size = 0;
   NodeWithMin top;
   
   public int getMinimum() throws Exception{
	   if(top!=null){
		   return top.getMin();
	   }
	   else{
		   throw new Exception("Stack is empty!");
	   }
   }
   
 public int peek() throws Exception{
	 try{
		 return top.getValue();
	 }
	 catch(Exception e){
		 throw new Exception("Stack is empty");
	 }
 }
 
 public void push(int value){
	  if(top !=null){
			 if(value< top.getMin()){
				 NodeWithMin node = new NodeWithMin(value, value);
				 top = node;
				 list.add(node);
				 size++;
			 }
			 else{
				 NodeWithMin node = new NodeWithMin(value, top.getMin());
				 top = node;
				 list.add(node);
				 size++;
			 }
	  } else{
		 NodeWithMin node = new NodeWithMin(value, value);
		 top = node;
		 list.add(node);
		 size++;
	}
 }
 
 public int pop() throws Exception{
	 try{
		 int value = top.getValue();
		 list.remove(size-1);
		 size--;
		 top = list.get(size-1);
		 return value;
	 }
	 catch(Exception e){
		 throw new Exception("Stack is empty");
	 }
 }
}
