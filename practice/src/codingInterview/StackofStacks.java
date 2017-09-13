package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class StackofStacks {
  int threshold;
  List<Stack> stackList = new ArrayList<>();
  int size;
  Stack topStack;

public StackofStacks(int threshold) {
	this.threshold = threshold;
}
  
  public void push(int value){
	  if(topStack!=null && topStack.getSize() <threshold){
		  topStack.push(value);
	  }
	  else {
		  Stack stack = new Stack();
		  stack.push(value);
		  stackList.add(stack);
		  size++;
		  topStack = stack;
	  }
  }
  
  public int pop() throws Exception{
	  try{
		  int value = topStack.pop();
		  if(topStack.getSize() == 0){
			  stackList.remove(size-1);
			  size--;
			  topStack = size >= 1 ? stackList.get(size-1) : null;
		  }
		  return value;
	  }
	  catch(Exception e){
		  throw new Exception("Stack of stacks is empty!");
	  }
  }
  
  public int getSize(){
	  return size;
  }
}
