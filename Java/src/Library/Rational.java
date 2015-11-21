package Library;

public class Rational {

	public int numerator;
	public int denominator;
	
	public Rational() {}
	
	public Rational(int numer, int denom) {
		this.numerator = numer;
		this.denominator = denom;
	}
	
	public boolean equals(Rational o) {
		return this.numerator == o.numerator && this.denominator == o.denominator;
	}
	
	public String toString() {
		return "[" + numerator + ", " + denominator + " ]";
	}
}
