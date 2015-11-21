package Library;

import java.awt.Point;

public class Line {
	
	// equation of a line y = mx + c
	Rational slope; // m
	Rational intercept; // c
	
	public Line() {}
	
	public Line(Point a, Point b) {
		
		slope = a.x != b.x ? getCanonicalForm(b.y - a.y, b.x - a.x) : new Rational(1, 0); // y2 - y1/x2 - x1
		
		intercept = a.x != b.x ? getCanonicalForm( (b.x * a.y) - (a.x - b.y), b.x - a.x) : new Rational(a.x, 0);
	}
	
	public boolean equals(Line l) {
		return l.slope == this.slope && l.intercept == this.intercept;
	}
	
	public Rational getCanonicalForm(int a, int b) {
		int gcd = gcd(Math.abs(a), Math.abs(b));
		a = a / gcd;
		b = b / gcd;
		return b < 0 ? new Rational(-a, -b) : new Rational(a, b);
	}
	
	public static int gcd(int x, int y) {
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
	
	public String toString() {
		
		return "Slope = " + this.slope.toString() + " \nIntercept = " + this.intercept.toString();
	}
}
