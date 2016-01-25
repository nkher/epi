package Graphs;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q19_2 {
	
	// TC = DFS O(V + E)
	public final Point array[] = { new Point(0, 1), new Point(0, -1), new Point(1, 0), new Point(-1, 0) };
	
	public Queue<Point> searchMaze(int[][] maze, Point s, Point e) {
		
		for (int i=0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		
		HashSet<Point> visited = new HashSet<Point>(); // contains the visited nodes
		Queue<Point> path = new LinkedList<Point>(); // contains the actual path
		
		visited.add(new Point(s.x, s.y));
		path.add(new Point(s.x, s.y)); // add the start to the maze
		
		if (!searchMazeHelper(s, e, maze, path, visited)) {
			path.remove();
		}
		return path;
	}
	
	public boolean searchMazeHelper(Point current, Point e, int[][] maze, Queue<Point> path, HashSet<Point> visited) {
		
		if (current.equals(e)) {
			return true;
		}
		
		for (Point p : array) {
			Point next = new Point(current.x + p.x, current.y + p.y);
			
				if (isFeasible(next, maze)) { // means it is feasible
					
					maze[next.x][next.y] = 1;
					//visited.add(next); // mark as visited
					path.add(next); // add to path
					if (searchMazeHelper(next, e, maze, path, visited)) {
						return true;
					}
					path.remove();
				}
		}
		return false;
	}
	
	public boolean isFeasible(Point next, int maze[][]) {
		return (next.x >= 0 && next.x < maze.length && next.y >= 0 && next.y < maze.length && maze[next.x][next.y] == 0);
	}
	
	public String printPoint(Point p) {
		return "(" + p.x + "," + p.y + ")";
	}
	
	public static void main(String[] args) {
		
		Q19_2 obj = new Q19_2();
		int[][] maze = { {1, 1, 0, 0, 0},
					     {1, 0, 0, 1, 1},
						 {1, 0, 1, 1, 1},
						 {1, 0, 1, 1, 1},
						 {0, 0, 1, 1, 1}, };
		
		Queue<Point> path = obj.searchMaze(maze, new Point(4, 0), new Point(0, 4));
				
		System.out.println("\nYour path is as follows :\n");
		for (Point p : path) {
			System.out.println(obj.printPoint(p));
		}
	}

}

enum MazeCol {
	// White means there is a path
	WHITE, BLACK;
	boolean visited = false;
}