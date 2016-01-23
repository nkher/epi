package DynamicProgramming;

import java.awt.Point;
import java.util.HashSet;

public class Q17_3 {
	
	// Without obstacles
	public static int numberOfPaths(int n, int m) {
		
		if (m > n) { // swap
			int temp = m;
			m = n;
			n = temp;
		}
		int a[] = new int[m];
		init(a); // first row can be reached in one way
		
		for (int i=1; i<n; i++) {
			int prev  = 0;
			for (int j=0; j< m; j++) {
				 a[j] = a[j] + prev;
				 prev = a[j];
			}
		}
		return a[m-1];
	}
	
	public static void init(int a[]) {
		
		for (int i=0;i<a.length;i++) {
			a[i] = 1;
		}
	}
	
	// With obstacles
	public static int numberOfPathsWithObtacles(int n, int m, HashSet<Point> points) {
		
		if (points.contains(new Point(0, 0))) {
			return 0;
		}
		
		int T[][] = new int[n][m];
		T[0][0] = 1;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (!points.contains(new Point(i, j))) {
					T[i][j] += (i < 1 ? 0 : T[i-1][j]) + (j < 1 ? 0 : T[i][j-1]);
				}
			}
		}
		return T[n-1][m-1];
	}
	
	public static void main(String args[]) {
		
		System.out.println("Without obstacles total paths are : " + numberOfPaths(5, 5));
		
		HashSet<Point> points = new HashSet<Point>();
		points.add(new Point(1, 1));
		//points.add(new Point(4, 2));
		
		System.out.println("With obstacles total paths are : " + numberOfPathsWithObtacles(5, 5, points));
	}
}
