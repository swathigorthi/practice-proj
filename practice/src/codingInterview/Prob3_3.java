package codingInterview;

public class Prob3_3 {

	public static void main(String[] args) throws Exception {
		StackofStacks stacks = new StackofStacks(2);
		stacks.push(3);
		stacks.push(5);
		stacks.push(4);;
		System.out.println(stacks.getSize());
		System.out.println(stacks.pop());
		System.out.println(stacks.getSize());
		stacks.push(6);
		System.out.println(stacks.getSize());

	}

}
