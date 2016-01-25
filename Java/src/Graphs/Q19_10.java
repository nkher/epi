package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q19_10 {

	
	// Modification of Dijkstra with time complexity - O(|E| + |V|log|V|)
	public void shortestPath(GV src, GV trgt) {
		
		Set<GV> nodeSet = new HashSet<GV>(); // To store the visited nodes
		Queue<GV> queue = new LinkedList<GV>(); // To help perform BFS
		
		src.pair.set(0, 0); // setting the distance and edges to reach this node as 0
		queue.add(src); // Add the source to the queue
		nodeSet.add(src); // Add it to the visited set
		
		GV u = null;
		
		while (!queue.isEmpty()) {
			u = queue.poll(); // remove the first node from the queue
			
			// Visit the neighbors and relax their edges and distances
			for (Edge e : u.getEdges()) {
				
				System.out.println("comes here");
				GV v = e.v;
				int vDist = e.dist + v.pair.dist;
				int vEdges = u.pair.noEdges + 1;
				
				// set the parameters for v
				System.out.println(v.vid + " " + vDist + " " +  v.pair.dist + " " + vEdges + " " + v.pair.noEdges);
				if (vDist <= v.pair.dist && vEdges < v.pair.noEdges) {
					System.out.println("Comes in for " + v.vid);
					v.pair.set(vDist, vEdges);
					v.predecessor = u;
				}
				
				// Add it to the visited set and the queue
				if (!nodeSet.contains(v)) { // confirm that it is not visited
					queue.add(v);
					nodeSet.add(v);
				}
				
			}
		}
		System.out.println(trgt.predecessor);
		// logic for printing the path
		// traverseBackward(trgt);
	}
	
	public void traverseBackward(GV v) {
		while (v.predecessor != null) {
			System.out.println(v.vid + " -> ");
			traverseBackward(v.predecessor);
		}
		return;
	}
	
	public static void main(String[] args) {
		
		Q19_10 spfe = new Q19_10();
		
		// Creating the graph
		GV gv1 = new GV(1);
		GV gv2 = new GV(2);
		GV gv3 = new GV(3);
		GV gv4 = new GV(4);
		GV gv5 = new GV(5);
		GV gv6 = new GV(6);
		GV gv7 = new GV(7);
		
		// Adding the edges
		gv1.addEdge(new Edge(gv2, 8));
		gv1.addEdge(new Edge(gv3, 7));	
		gv2.addEdge(new Edge(gv4, 10));
		gv4.addEdge(new Edge(gv2, 7));
		gv3.addEdge(new Edge(gv5, 6));
		gv5.addEdge(new Edge(gv7, 6));
		gv7.addEdge(new Edge(gv6, 6));
		
		// Run the algorithm
		spfe.shortestPath(gv1, gv6);
	}

}

class GV {
	int vid;
	Pair pair;
	ArrayList<Edge> edges;
	GV predecessor;
	
	public GV(int vid) {
		this.vid = vid;
		edges = new ArrayList<Edge>();
		pair = new Pair();
		predecessor = null;
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
}

class Pair {
	int dist, noEdges;
	
	public Pair() {
		init();
	};
	
	public Pair(int d, int e) {
		dist = d;
		noEdges = e;
	}
	
	public void set(int d, int e) {
		dist = d;
		noEdges = e;
	}
	
	public void init() {
		this.dist = Integer.MAX_VALUE;
		this.noEdges = 0;
	}
}

class Edge {
	GV v;
	int dist;
	
	public Edge(GV v, int dist) {
		this.v = v;
		this.dist = dist;
	}
}