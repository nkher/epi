package Graphs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class Q19_4 {
	
	public static final Point[] points = {new Point(0, 1), new Point(0, -1), new Point(1, 0), new Point(-1, 0)};
	
	// TC = BFS -> O(m * n)
	public static void fillSurroundedRegions(int board[][]) {
		
		if (board == null || board.length == 0) return;
		HashSet<Point> visited = new HashSet<Point>();
		
		for (int i=1; i<board.length-1; i++) {	
			for (int j=1; j<board[i].length-1; j++) {
				if (board[i][j] == 0 && !visited.contains(new Point(i, j))) {
					markRegionIfSurrounded(i, j, board, visited);
				}
			}
		}
	}
	
	public static void markRegionIfSurrounded(int i, int j, int board[][], HashSet<Point> visited) {
		
		ArrayList<Point> queue = new ArrayList<Point>(); // use this as a queue
		Point p = new Point(i, j);
		queue.add(p);
		visited.add(p);
		
		boolean isSurrounded = true;
		int idx = 0;
		
		// Traverse using BFS
		while (idx < queue.size()) {
			
			Point curr = queue.get(idx++);
			// A 0 on the border means the region is not surrounded
			if (curr.x == 0 || curr.y == 0 || curr.x == board.length-1 || curr.y == board.length-1) { // first checking the border conditions
				isSurrounded = false;
			}
			else {
				for (Point pt : points) {
					Point next = new Point(curr.x + pt.x, curr.y + pt.y);
					if (board[next.x][next.y] == 0 && !visited.contains(next)) {
						visited.add(next); // mark visited
						queue.add(next); // add to the queue
					}
				}
			}
		}
		
		if (isSurrounded) {
			for (Point point : queue) {
				board[point.x][point.y] = 1;
			}
		}
	}
	
	public static void print(int board[][]) {
		for (int i=0; i<board.length; i++) {	
			for (int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int board[][] = { {1,1,1,1},
						  {0,1,0,1},
						  {1,0,0,1},
						  {1,1,1,1} };
		
		print(board);
		fillSurroundedRegions(board);
		System.out.println("\n\n");
		print(board);
		
		System.out.println("\n\n");
		
		int b2[][] = { {1,1,1,1,1},
					   {0,1,0,1,1},
					   {1,0,0,1,1},
					   {1,1,1,0,1} };
		
		print(b2);
		fillSurroundedRegions(b2);
		System.out.println("\n\n");
		print(b2);
	}

}
