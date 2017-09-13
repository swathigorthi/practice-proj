package codingInterview;

public class Prob3_6 {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(3);
		s.push(2);
		s.push(5);
		s.push(1);
		s.push(6);
		s= s.sort();
		while(s.getSize() >0){
			System.out.println(s.pop());
		}

	}

}
