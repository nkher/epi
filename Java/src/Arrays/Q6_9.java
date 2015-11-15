package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Q6_9 {
	
	// Find all primes from 1 to n
	// Method 1
	public static ArrayList<Integer> generatePrimes(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[n+1];
		// Initially everything is true
		for (int i=0;i<n+1;i++) {
			isPrime[i] = true;
		}
		
		for (int p=2;p<n;p++) {
			if (isPrime[p]) {
				// add it to the array
				primes.add(p);
				
				// Iterate over its multiples
				for (int j=p;j<=n;j += p) {
					isPrime[j] = false;
				}
			}
		}
		return primes;
	}
	
	// Method 2 - Improving the time complexity to O(nlognlogn)
	// by not considering even elements and starting to examine from p^2
	// rather than p. as when we reach p all numbers until (kp) would 
	// have been marked where k < p
	
	public static ArrayList<Integer> generatePrimes2(int n) {
		int kSize = (int) Math.ceil((0.5 * (n-3)) + 1);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[kSize];
		// Initially everything is true
		for (int i=0;i<kSize;i++) {
			isPrime[i] = true;
		}
		// now here isPrime[i] represents whether 2i + 3 is a prime or not. Means 
		// this is the series of all odd numbers
		// since in the below outer forloop we can never get 2, we add it before hand to the list
		primes.add(2);
		for (int i=0;i<kSize;i++) {
			if (isPrime[i]) {
				int p = (2*i) + 3;
				primes.add(p);
				for (int j= (2*(i*i) + 6*i +3);j<kSize; j += p) {
					isPrime[j] = false;
				}
			}
		}
		return primes;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generatePrimes(20).toArray()));
		System.out.println(Arrays.toString(generatePrimes2(20).toArray()));
	}

}
