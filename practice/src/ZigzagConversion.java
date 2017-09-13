
public class ZigzagConversion {
	
	private static String zigzagConvert(String str, int n){
		int l = str.length();
		if(l<=n) return str;
		char [] arr = str.toCharArray();
		int k = 0;
		String output = "";
		boolean evenRow = true;
		while(k<n){
			int i = k;
			while(i<l){
				output+=String.valueOf(arr[i]);
				if(evenRow){
					int temp = n/2;
					i = i+n+temp;
				}
				else{
					int temp = n-(k+1)/2;
					System.out.println(temp);
					i = i+temp;
				}
				
			}
			evenRow = !evenRow;
			k++;
		}
		return output;
	}

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		String str1 = "pa";
		int n = 3;
		System.out.println(zigzagConvert(str, n));

	}

}
