import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
	public static String getHint(String secret, String guess) {
        int bulls = 0; 
        int cows = 0;
        
        Map<Character, Integer> gmap = new HashMap<>();
        
        for(int i = 0; i < guess.length(); i++){
            char si = secret.charAt(i);
            char gi = guess.charAt(i);
            if(si == gi){
                bulls++;
            }
            else{
                Integer gcount = gmap.get(gi);
                if(gcount == null){
                    gcount = 0;
                }
                gmap.put(gi, ++gcount);
            }
        }
        
       for(char c : secret.toCharArray()){
           Integer gcount = gmap.get(c);
           if(gcount!=null && gcount > 0){
               cows++;
               gmap.put(c, gcount-1);
           }
       }
        
        return bulls+"A"+cows+"B";
    }

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));

	}

}
