package Arrays;

public class Q6_4 {
	
	// Check if a board game is winnable
	// TC = O(n) and SC = O(1)
	public static boolean checkIfWinnable(int boardGame[]) {
		int furthestReach = 0;
		for (int i=0;i<=furthestReach && furthestReach <= boardGame.length-1; i++) {
			furthestReach = Math.max(furthestReach, boardGame[i] + i);
		}
		return furthestReach >= (boardGame.length-1);
	}
	
	public static void main(String[] args) {

		int bGame[] = {3,3,1,0,2,0,1};
		System.out.println(checkIfWinnable(bGame));
		
		int bGame2[] = {3,3,0,0,2,0,1};
		System.out.println(checkIfWinnable(bGame2));
		
		int bGame3[] = {2,2,1,1,0,2,3};
		System.out.println(checkIfWinnable(bGame3));
	}

}
