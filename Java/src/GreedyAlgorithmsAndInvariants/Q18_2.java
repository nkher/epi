package GreedyAlgorithmsAndInvariants;

import java.util.ArrayList;
import java.util.Arrays;

import Library.PairOfInts;

public class Q18_2 {
	
	// Computing all sets of pairs is too much !! TC = O( n!/2^(n/2) )
	
	// TC = O(n * log n)
	public static ArrayList<PairOfInts> computeOptimumTaskAssignment(int a[]) {
		Arrays.sort(a);
		ArrayList<PairOfInts> taskPairings = new ArrayList<PairOfInts>();
		int i=0, j = a.length-1;
		
		while (i < j) {
			taskPairings.add(new PairOfInts(a[i], a[j]));
			i++;
			j--;
		}
		
		return taskPairings;
	}
	
	public static void main(String[] args) {
		
		int a[] = {5, 2, 1, 6, 4, 4};
		System.out.println("Optimum task pairings are : " + computeOptimumTaskAssignment(a));
		
		int b[] = {10, 8, 9, 1};
		System.out.println("Optimum task pairings are : " + computeOptimumTaskAssignment(b));	
	}

}
