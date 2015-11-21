package Library;

public class HighwaySection {
	
	public int x;
	public int y;
	public double distance;
	
	public HighwaySection() {}
	
	public HighwaySection(int x, int y, double distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}
}
