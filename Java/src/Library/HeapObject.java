package Library;

public class HeapObject implements Comparable<HeapObject> {
	
	public int data, index;
	
	public HeapObject(int index, int data) {
		 this.index = index;
		 this.data = data;
	}
	
	public int compareTo(HeapObject o) {
		
		if (this.data > o.data) return 1;
		else if (this.data < o.data) return -1;
		else return 0;
	}
	
}