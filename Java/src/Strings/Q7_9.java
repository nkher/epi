package Strings;

public class Q7_9 {

	public static char[][] snakeString(String s) {
		
		int n = s.length();
		char[][] result = new char[3][n];
		init(result); // initialize the array
		
		// fill the first row
		for (int i=1;i<n;i=i+4) {
			result[0][i] = s.charAt(i);
		}
		
		// fill the middle row
		for (int i=0;i<n;i=i+2) {
			result[1][i] = s.charAt(i);
		}
		
		
		// fill the last row
		for (int i=3;i<n;i=i+4) {
			result[2][i] = s.charAt(i);
		}
		
		return result;
	}
	
	public static void init(char[][] res) {
		for (int i=0;i<res.length;i++) {
			for (int j=0;j<res[i].length;j++) {
				res[i][j] = ' ';
			}
		}
	}
	
	public static void print(char[][] res) {
		for (int i=0;i<res.length;i++) {
			for (int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		
		String s = "Hello-World!";
		print(snakeString(s));
	}
}
