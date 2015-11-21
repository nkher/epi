package Library;

public class TrafficElement implements Comparable<TrafficElement> {
	
	public int time;
	public double volume;
	
	public TrafficElement() {}
	
	public TrafficElement(int t, double vol) {
		this.time = t;
		this.volume = vol;
	}
	
	public String toString() {
		return "[" + this.time + ", " + this.volume + "]";
	}

	public int compareTo(TrafficElement o) {
		if (this.volume > o.volume) return 1;
		else if (this.volume < o.volume) return -1;
		return 0;
	}
}
