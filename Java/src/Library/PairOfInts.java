package Library;

public class PairOfInts {

	public int first, second;
	
	public PairOfInts() {}
	
	public PairOfInts(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public String toString() {
		return "[" + this.first + ", " + this.second + "]";
	}
	
	public void setPair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
