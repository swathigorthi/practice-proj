package codingInterview;

public class Prob3_2 {

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		try {
			System.out.println(stack.getMinimum());
			System.out.println(stack.pop());
			System.out.println(stack.getMinimum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
