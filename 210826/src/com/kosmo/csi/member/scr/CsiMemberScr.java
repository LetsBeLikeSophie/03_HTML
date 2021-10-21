package com.kosmo.csi.member.scr;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosmo.common.CsiMemberChabun;
import com.kosmo.csi.member.service.CsiMemberService;
import com.kosmo.csi.member.service.CsiMemberServiceImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;


public class CsiMemberScr {
	
	public static final String[] insert_label = { "회원이름", "아이디", "패스워드", "생년월일", "성별",    
				            					  "전화번호", "휴대폰번호", "이메일", "주소", "취미",     
				            					  "사진", "특기", "직업"};
	public static final String[] update_label = {"회원번호", "이메일", "주소", "취미", "직업"};	

	public static void cmemSelectAll() {
		System.out.println("회원정보 전체조회 >>> : ");
		
		CsiMemberService ss = new CsiMemberServiceImpl();		
		ArrayList<CsiMemberVO> aList = ss.cmemSelectAll();

		if (aList !=null && aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				
				CsiMemberVO cvo = aList.get(i);
				CsiMemberVO.printCsiMemberVO(cvo);
			}		
		}else {
			System.out.println("aList 에 데이터가 없네요 >>> : " + aList);
		}
		
	}

	public static void cmemSelect(String cnum) {
		System.out.println("회원정보 조건조회 >>> : ");
		
		boolean boolS = false;
		CsiMemberService ss = new CsiMemberServiceImpl();
		
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		
		if (cnum !=null && cnum.length() > 0) {
			
			cvo.setCnum(cnum);				
			boolS = ss.cmemDelete(cvo);
			
			if (boolS) {
				
				ArrayList<CsiMemberVO> aList = ss.cmemSelect(cvo);

				if (aList !=null && aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						
						CsiMemberVO _cvo = aList.get(i);
						CsiMemberVO.printCsiMemberVO(_cvo);
					}		
				}else {
					System.out.println("aList 에 데이터가 없네요 >>> : " + aList);
				}	
			}else {
				System.out.println("조회 실패 >>> : " + boolS);
			}
		}else {
			System.out.println("회원번호가 없습니다. >>> : ");
		}
	}
	
	public static void cmemInsert(String sVal[]) {		
		System.out.println("회원정보 등록 >>> : ");	
		
		boolean boolI = false;
		
		String cnum = "";
		String cname = sVal[0];
		String cid = sVal[1];
		String cpw = sVal[2];
		String cbirth = sVal[3];
		String cgender = sVal[4];
		String ctel = sVal[5];
		String chp = sVal[6]; 
		String cemail = sVal[7];
		String caddr = sVal[8];
		String chobby = sVal[9];
		String cphoto = sVal[10];
		String cskill = sVal[11];
		String cjob = sVal[12];
			
		CsiMemberService ss = new CsiMemberServiceImpl();
		
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		cnum = CsiMemberChabun.ymdNum();
		System.out.println("CsiMemberScr.cmemInsert :: CsiMemberChabun.ymdNum() >>> : " + cnum);
		cvo.setCnum(cnum);
		cvo.setCname(cname);
		cvo.setCid(cid);
		cvo.setCpw(cpw);
		cvo.setCbirth(cbirth);
		cvo.setCgender(cgender);
		cvo.setCtel(ctel);
		cvo.setChp(chp);
		cvo.setCemail(cemail);
		cvo.setCaddr(caddr);
		cvo.setChobby(chobby);				
		cvo.setCphoto(cphoto);
		cvo.setCskill(cskill);
		cvo.setCjob(cjob);
		
		boolI = ss.cmemInsert(cvo);

		if (boolI) {
			System.out.println("회원 정보 입력 성공 >>> : " + boolI);	
					
		}else {
			System.out.println("회원 정보 입력 실패 >>> : " + boolI);
		}			
	}
	

	public static void cmemUpdate(String sVal[]) {		
		System.out.println("회원정보 수정 >>> : ");
		
		String cnum = sVal[0];				
		String cemail = sVal[1];	
		String caddr = sVal[2];	 
		String chobby = sVal[3];					
		String cjob = sVal[4];
			
		CsiMemberService ss = new CsiMemberServiceImpl();
		
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		cvo.setCnum(cnum);			
		cvo.setCemail(cemail);
		cvo.setCaddr(caddr);
		cvo.setChobby(chobby);								
		cvo.setCjob(cjob);
		
		boolean boolU = ss.cmemUpdate(cvo);
		if (boolU) {
			System.out.println("회원 정보 수정 성공 >>> : " + boolU);	
						
		}else {
			System.out.println("회원 정보 수정 실패 >>> : " + boolU);
		}				
	}
	

	public static void cmemDelete(String cnum) {
		System.out.println("회원정보 삭제 >>> : ");
	
		boolean boolD = false;
		CsiMemberService ss = new CsiMemberServiceImpl();
		
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		
		if (cnum !=null && cnum.length() > 0) {
			cvo.setCnum(cnum);				
			boolD = ss.cmemDelete(cvo);
			
			if (boolD) {
				System.out.println("회원 정보 삭제 성공 >>> : " + boolD);				
			}else {
				System.out.println("회원 정보 삭제 실패 >>> : " + boolD);
			}		
		}else {
			System.out.println("회원번호가 없습니다. >>> : ");
		}
	}	
	
	public static String[] getParameter(int iVal) {
	
		String sVal[] = null;
		
		if (3 == iVal) { 			
			
			sVal = new String[insert_label.length];				
			Scanner sc2 = new Scanner(System.in);
			System.out.println("등록할 회원정보를 입력하시오 >>> : " + insert_label.length);
			System.out.println("등록할 회원정보 배열의 길이 >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				System.out.println(insert_label[i] + "을(를) 입력하시오 :: " );
				sVal[i] = sc2.next();
				System.out.println(insert_label[i] + " 정보는 >>> : " + sVal[i]);
			}
		}			
		
	
		if (4 == iVal) { 
		
			sVal = new String[update_label.length];				
			Scanner sc3 = new Scanner(System.in);
			System.out.println("수정할 회원정보를 입력하시오 >>> : " + update_label.length);
			System.out.println("수정할 회원정보 배열의 길이 >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				System.out.println(update_label[i] + "을(를) 입력하시오 :: " );
				sVal[i] = sc3.next();
				System.out.println(update_label[i] + " 정보는 >>> : " + sVal[i]);
			}
		}
		
		return sVal;
	}
	
	public static void main(String[] args) {
	
		System.out.println("회원정보 CRUD::ISUD 테스트 >>> : ");		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\n회원정보 전체조회:1, 조건조회:2, 등록:3, 수정:4, 삭제:5, 종료:0");
			
			int isud = sc.nextInt();	
			if (0 == isud) break;
			
			switch(isud) {
				case 1:		
					try {
						CsiMemberScr.cmemSelectAll();	
					}catch(Exception e) {						
					}				
					break;
					
				case 2:
					System.out.println("조회조건 회원번호를 입력하시오 >>> : ");
					Scanner sc1 = new Scanner(System.in);
					try {
						String cnum = sc1.next();
						CsiMemberScr.cmemSelect(cnum);	
					}catch(Exception e) {						
					}								
					break;
					
				case 3:
					try {	
						String sVal3[] = CsiMemberScr.getParameter(3);
						CsiMemberScr.cmemInsert(sVal3);	
					}catch(Exception e) {						
					}	
					break;
					
				case 4:
					try {
						String sVal4[] = CsiMemberScr.getParameter(4);
						CsiMemberScr.cmemUpdate(sVal4);	
					}catch(Exception e) {						
					}						
					break;
					
				case 5:
					System.out.println("삭제할 회원번호를 입력하시오 >>> : ");
					Scanner sc2 = new Scanner(System.in);
					try {
						String cnum = sc2.next();
						CsiMemberScr.cmemDelete(cnum);	
					}catch(Exception e) {						
					}							
					break;					
			}
		}
	}
}
