import java.util.Arrays;

public class StringSort {

	
	public static void main(String[] args) {
		String s = "bdc";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String key = String.valueOf(c);
		System.out.println(key);

	}

}
