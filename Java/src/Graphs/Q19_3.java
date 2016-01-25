package Graphs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/* If we use recursion we increase the call stack. On each pixel/cell we call
 * 4 more neighbors hence we are 4^n on our call stack.
 * Imagine for 10 pixels we would be 4^10 = 1000000 already on the call stack
*/

// This is nothing but the paint fill function which can also be done using DFS
public class Q19_3 {
	
	public final Point array[] = { new Point(0, 1), new Point(0, -1), new Point(1, 0), new Point(-1, 0) };
	
	public void flipColorBFS(COLOR a[][], int x, int y) {
		
		COLOR col = a[x][y]; // store the color
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		
		a[x][y] = (a[x][y] == COLOR.YELLOW ? COLOR.RED : COLOR.YELLOW); // flip the first color
		
		while (!queue.isEmpty()) {
			Point current = queue.remove();
			
			for (Point p : array) {				
				Point next = new Point(current.x + p.x, current.y + p.y);
				
				if (next.x >= 0 && next.x < a.length && next.y >= 0 && next.y < a[next.x].length 
						&& a[next.x][next.y] == col ) {			
					a[next.x][next.y] = (a[next.x][next.y] == COLOR.YELLOW ? COLOR.RED : COLOR.YELLOW); // flips the color appropriately
					queue.add(next);
				}
			}
			// queue.remove();
		}
	}
	
	public void printMatrix(COLOR a[][]) {
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
		
	public static void main(String[] args) {
		
		Q19_3 obj = new Q19_3();
		COLOR[][] a = { {COLOR.YELLOW, COLOR.RED, 		COLOR.RED, 		COLOR.RED, 		COLOR.RED, 		COLOR.RED, COLOR.RED},
						{COLOR.RED, COLOR.RED, 			COLOR.YELLOW, 	COLOR.RED, 		COLOR.RED, 		COLOR.RED, COLOR.RED},
						{COLOR.RED, COLOR.YELLOW, 		COLOR.YELLOW,	COLOR.YELLOW, 	COLOR.YELLOW, 	COLOR.RED, COLOR.RED},
						{COLOR.RED, COLOR.RED, 			COLOR.RED, 		COLOR.YELLOW, 	COLOR.RED, 		COLOR.RED, COLOR.RED},
						{COLOR.RED, COLOR.RED, 			COLOR.RED, 		COLOR.RED, 		COLOR.RED, 		COLOR.RED, COLOR.RED},
						{COLOR.RED, COLOR.RED, 			COLOR.RED, 		COLOR.RED, 		COLOR.RED, 		COLOR.RED, COLOR.YELLOW }};
		
		obj.printMatrix(a);
		obj.flipColorBFS(a, 2, 1);
		
		System.out.println();
		obj.printMatrix(a);
		
		System.out.println(Math.pow(4.0, 10.0));
	}
}

enum COLOR {
	RED, YELLOW;
}

