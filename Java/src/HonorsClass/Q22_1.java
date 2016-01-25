package HonorsClass;

public class Q22_1 {
	
	// Program to calculate the GCD of two numbers
	
	// Method 1 with subtraction
	// For an input of x = 2^(n) and y = 2 it makes 2(n-1) recursive calls
	public static int gcd(int x, int y) {
		if (x == y) return x;
		if (x >= y) return gcd(x-y, y); 
		else return gcd(x, y-x);
	}
	
	// Method 2 using modulus
	public static int gcd2(int x, int y) {
		if (x == 0 || y == 0) return (x + y);
		return gcd2(y, x%y);
	}
	
	// Method 3 using Iteration
	public static int gcd3(int x, int y) {
		while (x != 0 && y != 0) {
			int c = y;
			y = x%y;
			x = c;
		}
		return (x + y);
	}
	
	// Method 3 efficient
	// Analysis - In every 2 calls we are reducing the combined bit length of the numbers at least by one than the previous 
	// There fore this gives logarithmic time complexity where total number of bits = no of bits in x and bo of bits in y
	public static long gcd(long x, long y) {
		if (x == 0) {
			return y;
		}
		else if (y == 0) {
			return x;
		}
		
		else if ( ((x & 1) == 0) && ((y & 0) == 0) ) { // both are even
			return gcd(x >> 1, y >> 1) << 1;  
		}
		else if ( ((x & 1) == 1) && ((y & 1) == 0) ) { // x is odd y is even
			return gcd(x , y >> 1);
		}
		else if ( ((x & 1) == 0) && ((y & 1) == 1) ) { // y is odd x is even
			return gcd(x >> 1, y);
		}
		else if (y > x) {
			return gcd(x, y-x);
		}
		return gcd(x-y, x);
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(gcd(24,  300));
		
		System.out.println(gcd2(24,  300));
		
		System.out.println(gcd3(24, 300));
		
		System.out.println(gcd(24, 300));
	}

}
