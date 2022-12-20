package main;

public class Data {
	String id;
	int time;


	public Data() {
	}
    
	public Data(String id, int time) {
		this.id = id;
		this.time = time;
	}

	public int gettime() {
		return time;
	}

	public void settime(int time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}