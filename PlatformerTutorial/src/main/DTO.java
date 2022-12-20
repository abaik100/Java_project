package main;

public class DTO {
	    private String id;
	    private int time;

		public String getid() {
			return id;
		}
		public void setid(String id) {
			this.id = id;
		}
		public int gettime() {
			return time;
		}
		public void settime(int time) {
			this.time = time;
		}
		
		@Override
		public String toString() {
			return "DTO [id=" + id + ", time=" + time + ", getid()=" + getid() + " gettime()=" + gettime() + "]";
		}
}
