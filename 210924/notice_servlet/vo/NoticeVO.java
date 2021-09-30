package a.b.c.com.kosmo.notice.vo;

import a.b.c.com.kosmo.mem.vo.MemberVO;

public class NoticeVO {

	private String nnum;
	private String nsubject;
	private String nmemo;
	private String nphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public NoticeVO() {
		
	}
	
	public NoticeVO(String nnum, String nsubject, String nmemo,
					String nphoto, String deleteyn, String insertdate,
					String updatedate) {		
		this.nnum = nnum;
		this.nsubject = nsubject;
		this.nmemo = nmemo;
		this.nphoto = nphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	
	public String getNnum() {
		return nnum;
	}
	public String getNsubject() {
		return nsubject;
	}
	public String getNmemo() {
		return nmemo;
	}
	public String getNphoto() {
		return nphoto;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setNnum(String nnum) {
		this.nnum = nnum;
	}
	public void setNsubject(String nsubject) {
		this.nsubject = nsubject;
	}
	public void setNmemo(String nmemo) {
		this.nmemo = nmemo;
	}
	public void setNphoto(String nphoto) {
		this.nphoto = nphoto;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	// NoticeVO 프린트 함수 
	public static void printNoticeVO(NoticeVO nvo) {
		
		System.out.print(nvo.getNnum() 			+ ", ");
		System.out.print(nvo.getNsubject() 		+ ", ");
		System.out.print(nvo.getNmemo()			+ ", ");
		System.out.print(nvo.getNphoto() 		+ ", ");					
		System.out.print(nvo.getDeleteyn() 		+ ", ");
		System.out.print(nvo.getInsertdate() 	+ ", ");
		System.out.println(nvo.getUpdatedate());
	}
	
	public static void printlnNoticeVO(NoticeVO nvo) {
		
		System.out.println("nvo.getNnum() 				>>> : " + nvo.getNnum());
		System.out.println("nvo.getNsubject() 			>>> : " + nvo.getNsubject());
		System.out.println("nvo.getNmemo() 				>>> : " + nvo.getNmemo());		
		System.out.println("nvo.getNphoto() 			>>> : " + nvo.getNphoto());					
		System.out.println("nvo.getDeleteyn() 			>>> : " + nvo.getDeleteyn());
		System.out.println("nvo.getInsertdate() 		>>> : " + nvo.getInsertdate());
		System.out.println("nvo.getUpdatedate() 		>>> : " + nvo.getUpdatedate());
	}		
}
