package main;

public class MemberDTO {
	 private String num;
	    private String name;
	    private String id;
	    private String pwd;
	    private String snid;
	    private int time;
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getSnid() {
			return snid;
		}
		public void setSnid(String snid) {
			this.snid = snid;
		}
		public void setTime(int time) {
			this.time = time;
			// TODO Auto-generated method stub
			
		}
		@Override
		public String toString() {
			return "MemberDTO [num=" + num + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", snid=" + snid
					+ ", getNum()=" + getNum() + ", getName()=" + getName() + ", getId()=" + getId() + ", getPwd()="
					+ getPwd() + ", getSnid()=" + getSnid() + "]";
		}

}
