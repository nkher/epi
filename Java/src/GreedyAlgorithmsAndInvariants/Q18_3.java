package GreedyAlgorithmsAndInvariants;

import java.util.Arrays;

public class Q18_3 {
	
	/* Schedule to minimize the wait time. 
	 * If we have the ith job say j(i) then to compute waiting time T(i) for ith client is 
	 * ∑ from i to n-1 of T(i) = ∑ ( t(i) * (n - c(i) ) where 
	 * t(i) = service time for that job 
	 * n = total jobs
	 * c(i) = index at which the job occurs (in short i + 1)
	 * TC = O(nLogn)
	 * */
	
	public static int minimumWaitingTime(int serviceTime[]) {
		Arrays.sort(serviceTime);
		
		int n = serviceTime.length;
		int waitingTime = 0;
		for (int i=0; i<n; i++) {
			waitingTime += serviceTime[i] * (n - (i+1));
		}
		return waitingTime;
	}
	
	public static void main(String[] args) {
		
		int serviceTime[] = {1, 3, 5, 8}; // answer is 14
		System.out.println("Minimal waiting time is : " + minimumWaitingTime(serviceTime));
	}

}
