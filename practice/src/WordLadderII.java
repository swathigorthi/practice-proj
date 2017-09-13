import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

    static char[] a = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
    static Set<String> words = new HashSet<>();
    public static class Word{
        String s;
        Word par;
        
        public Word(String s, Word par){
            this.s = s;
            this.par = par;
        }
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        words.addAll(wordList);
        List<List<String>> lol = new ArrayList<>();
        if(!words.contains(endWord)) {return lol;}
        Queue<Word> q = new ArrayDeque<>();
        q.add(new Word(beginWord, null));
        String prev = beginWord;
        List<Word> l = new ArrayList<>();
        while(!q.isEmpty()){
            Word w = q.poll();
            if(w.par!=null && !w.par.s.equals(prev)){
                prev = w.par.s; 
            }
            if(getChildren(w, q, endWord)){
                l.add(w);
            }
        }
        for(Word w : l){
            List<String> ls = new ArrayList<>();
            ls.add(endWord);
            while(w !=null){
                ls.add(w.s);
                w = w.par;
            }
            Collections.reverse(ls);
            lol.add(ls);
        }
        return lol;
    }
    
    public static boolean getChildren(Word word, Queue<Word> q, String endWord){
        char[] warr = word.s.toCharArray();
        int l = word.s.length();
        boolean found = false; 
        for(int i=0; i<l;i++){
            char c = warr[i];
            int j =0;
            while(j<26){
                if(c == a[j]){j++; continue;}
                warr[i] = a[j];
                String s = String.valueOf(warr);
                if(words.contains(s)){
                    if(s.equals(endWord)){found = true;}
                    else{
                    	q.add(new Word(s, word));
                        words.remove(s);
                    }
                }
                j++;
            }
            warr[i]= c;
        }
        return found;
    }


	public static void main(String[] args) {
		List<List<String>> lol = findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
		for(List<String> l : lol){
			System.out.println(l.toString());
		}

	}

}
