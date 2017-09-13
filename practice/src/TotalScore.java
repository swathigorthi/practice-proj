
public class TotalScore {
	
	public static class Score{
		int score = 0;
		Score lastScore;
		
//		public Score(Score lastScore, String s){
//			
//		}
	}
	
	public static int findTotalScore(String[] input){
		int totalScore = 0;
		Score lastScore = null;
		for(String s : input){
			System.out.println("LastScore" + (lastScore!=null ? lastScore.score : -1));
			System.out.println(s);
			Score currentScore = new Score();
			currentScore.lastScore = lastScore;
			if(s.equals("X")){
				currentScore.score = lastScore!=null ? lastScore.score * 2 : 0;
				totalScore = totalScore + currentScore.score;
				lastScore = currentScore;
			}else if(s.equals("+")){
				currentScore.score = (lastScore !=null ? lastScore.score + (lastScore.lastScore !=null ? lastScore.lastScore.score : 0) : 0 );
				totalScore = totalScore + currentScore.score;
				lastScore = currentScore; 
			}else if(s.equals("Z")){
				totalScore = totalScore - (lastScore!=null ? lastScore.score : 0);
				lastScore = lastScore.lastScore;
			}else{
				currentScore.score = Integer.parseInt(s);
				totalScore = totalScore + currentScore.score;
				lastScore = currentScore; 
			}
			System.out.println("currentScore" + currentScore.score);
			System.out.println("TOTAL" + totalScore);
			System.out.println("--------------------");
		}
		return totalScore; 
	}

	public static void main(String[] args) {
		String[] input = new String[]{"5", "-2", "4", "Z", "X", "+", "3"};
		System.out.println(findTotalScore(input));

	}

}
