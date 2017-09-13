import java.util.Arrays;

public class ReverseWordsInAString {
	
	 public static String reverseWords(String s) {
         char[] carr = reverse(s);
         int l = carr.length;
         if(l==0){return "";}
         int i = l -1;
         int end = i;
         while(i>=0 ){
             if(carr[i] != ' '){
                 i--;
             }
             else{
                 reverseInPlace(carr, i+1, end);
                 i--;
                 end = i;
             }
         }
         reverseInPlace(carr, i+1, end);
         return new String(carr);
	  }
	  
	  public static  void reverseInPlace(char[] carr, int str, int end){
	      while(str < end){
	          char c = carr[str];
	          carr[str] = carr[end];
	          carr[end] = c;
	          str++;
	          end--;
	      }
	  }
	  public static char[] reverse(String str){
	      int l = str.length();
	      if(l==0){return new char[0];}
	      int j = l-1;
	      while(str.charAt(j) == ' '){j--; if(j<=0){return new char[0];}}
	      char[] ret = new char[l];
	      int i = 0;
	      int c = 0;
	      while(j>=0){
	          char cj = str.charAt(j);
	          if(cj == ' ' && c>=0){j--;}
	          else {
	              if(c>0){
	                  ret[i]= ' '; i++;
	              }
	              c=0;
	              ret[i] = cj; 
	              i++; j--;}
	      }
	     return Arrays.copyOf(ret, i);
	  }

//	    public static String reverseWords(String s) {
//	    	char[] carr = (s+" ").toCharArray();
//	    	fix(carr, 0, s.length());
//	        return new String(carr, 0, s.length());
//	    }
//	    
//	    public static void fix(char[] carr, int str, int end){
//	        int k = end-1;
//	        if(k<=str){return;}
//	        while(carr[k]!=' '){k--;}
//	        fix(carr, str, k);
//	        rotate(carr,str, end, k);
//	    }
//	    
//	    public static void rotate(char[] carr,int str, int end,  int k) {
//	        char[] temp = new char[end-k];
//	        int i = end;
//	        int j = end-k-1;
//	        while(j>=str){
//	            temp[j] = carr[i];
//	            i--; j--;
//	        }
//	        i=end; j =k;
//	        while(j>=str){
//	        	carr[i] = carr[j];
//	            i--;j--;
//	        }
//	        i=str;
//	        while(i<end-k){
//	        	carr[i] = temp[i];
//	            i++;
//	        }
//	    }
//	    
	public static void main(String[] args) {
		System.out.println(reverseWords("1 "));

	}

}
