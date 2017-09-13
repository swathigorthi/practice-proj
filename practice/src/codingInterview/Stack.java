package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class Stack {
  List<Integer> list = new ArrayList<>();
  int size =0;
  Integer top;
  
  public void push(int value){
		  top = value;
		  list.add(top);
		  size++;
	 
  }
  
  public int pop() throws Exception{
	  try{
		  int value = top.intValue();
		  list.remove(size-1);
		  size--;
		  top = size>=1 ? list.get(size-1) : null;
		  return value;
	  }
	  catch (Exception e){
		  throw new Exception("Stack is empty!");
	  }
  }
  
  public int peek() throws Exception{
	  try{
		  return top.intValue();
	  }
	  catch(Exception e){
		  throw new Exception("Stack is empty!");
	  }
  }
  
  public int getSize(){
	  return size;
  }
  
  public Stack sort() throws Exception{
	  Stack temp = new Stack();
	  try{
		  while(getSize() >0){
			  if(temp.getSize()==0){
				  temp.push(this.pop());
			  }
			  else{
				  int top = this.pop();
				  while(temp.getSize() > 0 && top > temp.peek()){
					  this.push(temp.pop());
				  }
				  temp.push(top);
			  }
		  }  
	  }
	  catch(Exception e){
		  throw new Exception("Stack is empty!");
	  }
	  
	return temp;
	  
  }
  
}
