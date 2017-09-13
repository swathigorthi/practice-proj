import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	    static char[] a = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
	    
	    public  static int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    	Set<String> words = new HashSet<>();
	    	words.addAll(wordList);
	        Queue<String> q = new ArrayDeque<>();
	        q.add(beginWord);
	        int depth =1;
	        wordList.remove(beginWord);
	        Set<String> temp = new HashSet<>();
	        while(!q.isEmpty()){
	        	String s = q.poll();
	        	if(getChildren(s, endWord, words, temp)){depth++; return depth;};
	        	if(q.isEmpty()){
	        		q.addAll(temp); 
	        		depth++;
	        		temp.clear();
	        	}
	        }
	        return 0;
	    }
	    
	    public  static boolean getChildren(String word, String endWord, Set<String> words, Set<String> children){
	    	char[] sarr = word.toCharArray();
	    	int length = word.length();
	    	for(int i=0;i<length;i++){
	    		int j=0;
	    		char c = sarr[i];
	    		while(j<26){
	    		    if(a[j] == c){j++; continue;}
	    			sarr[i] = a[j];
	    			String s = String.valueOf(sarr);
	    			if(s.equals(endWord)){return true;}
	    			if(words.contains(s)){
	    				children.add(s);
	    				words.remove(s);
	    			}
	    			j++;
	    		}
	    		sarr[i] = c;
	    	}
	    	return false;
	    }
	    
		public static void main(String[] args) {
            System.out.println(ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
	   }
}
