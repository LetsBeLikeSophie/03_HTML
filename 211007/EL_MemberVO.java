package a.b.c.com.common;

public class EL_MemberVO {

	private String irum;
	private String id;
	private String pw;
	private int age;
	private String addr;
	private String tel;
	
	public EL_MemberVO(){
		
	}
	
	public EL_MemberVO(String irum, String id, String pw, int age, String addr, String tel) {
		
		this.irum = irum;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}
	public String getIrum() {
		return irum;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
	public String getTel() {
		return tel;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
