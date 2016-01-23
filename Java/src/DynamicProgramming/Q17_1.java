package DynamicProgramming;

public class Q17_1 {
	
	
	// Method from book
	public static int countCombinations(int score, int scoreWays[]) {
		
		int combinations[] = new int[score + 1];
		combinations[0] = 1;
		
		for (int i=0;i<scoreWays.length;i++) {
			
			int currScore = scoreWays[i];
			for (int j=currScore; j<=score; j++) {
				combinations[j] += combinations[j - currScore];
			}
		}
		return combinations[score];
	}
	
	public static void main(String[] args) {
		
		int scoreWays[] = {2, 3, 7};
		int score = 12;
		
		System.out.println(countCombinations(score, scoreWays));
	}

}
