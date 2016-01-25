package HonorsClass;

public class Q22_2 {
	
	public static int firstMissingPositiveEntry(int a[]) {
		
		int i = 0, n = a.length;
		while (i < n) {
			
			if (a[i]-1 == i) {
				i++;
				continue;
			}
			
			// Before swapping check for - 
			// 1.) a[i] must be greater than 0, 2.) a[i] must be less than or equal to n and 
			// 3.) element at that position must not be equal to the element at the position with which you are going to perform the swap 
			if (a[i] > 0 && a[i] <= n && a[a[i] - 1] != a[i])
				swapAt(a, i, a[i]-1);
			
			i++;
		}
		
		for (i=0; i<n; i++) {
			if (i+1 != a[i]) return i+1;
		}
		
		return n + 1;
	}
	
	public static void swapAt(int a[], int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static void main(String[] args) {
		
		int a[] = {3, 4, 0, 2};
		System.out.println("First missing positive entry is : " + firstMissingPositiveEntry(a));
	}

}
