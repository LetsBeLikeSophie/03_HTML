package a.b.c.kosmo.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.HbeMemberChabun;
import a.b.c.kosmo.mem.service.HbeMemberService;
import a.b.c.kosmo.mem.service.HbeMemberServiceImpl;
import a.b.c.kosmo.mem.vo.HbeMemberVO;

public class HbeMemberScr {
	
	// 회원정보 라벨
	public static final String[] insert_label = { "회원이름", "아이디", "패스워드", "생년월일", "성별",    
				            					  "전화번호", "휴대폰번호", "이메일", "주소", "취미",     
				            					  "사진", "특기", "직업"};
	public static final String[] update_label = {"회원번호", "이메일", "주소", "취미", "직업"};	

	// 회원정보 전체 조회
	public static void hmemSelectAll() {
		System.out.println("회원정보 전체조회 >>> : ");
		
		HbeMemberService hs = new HbeMemberServiceImpl();		
		ArrayList<HbeMemberVO> aList = hs.hmemSelectAll();

		if (aList !=null && aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				
				HbeMemberVO hvo = aList.get(i);
				HbeMemberVO.printHbeMemberVO(hvo);
			}		
		}else {
			System.out.println("aList 에 데이터가 없네요 >>> : " + aList);
		}
		
	}
	
	// 회원정보 검색 : 조건조회 
	public static void hmemSelect(String hnum) {
		System.out.println("회원정보 조건조회 >>> : ");
		
		boolean boolS = false;
		HbeMemberService hs = new HbeMemberServiceImpl();
		
		HbeMemberVO hvo = null;
		hvo = new HbeMemberVO();
		
		if (hnum !=null && hnum.length() > 0) {
			
			hvo.setHnum(hnum);				
			boolS = hs.hmemDelete(hvo);
			
			if (boolS) {
				
				ArrayList<HbeMemberVO> aList = hs.hmemSelect(hvo);

				if (aList !=null && aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						
						HbeMemberVO _hvo = aList.get(i);
						HbeMemberVO.printHbeMemberVO(_hvo);
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
	
	// 회원정보 등록 : 회원번호는 채번로직 사용 
	public static void hmemInsert(String sVal[]) {		
		System.out.println("회원정보 등록 >>> : ");	
		
		boolean boolI = false;
		
		String hnum = "";
		String hname = sVal[0];
		String hid = sVal[1];
		String hpw = sVal[2];
		String hbirth = sVal[3];
		String hgender = sVal[4];
		String htel = sVal[5];
		String hhp = sVal[6]; 
		String hemail = sVal[7];
		String haddr = sVal[8];
		String hhobby = sVal[9];
		String hphoto = sVal[10];
		String hskill = sVal[11];
		String hjob = sVal[12];
			
		HbeMemberService hs = new HbeMemberServiceImpl();
		
		HbeMemberVO hvo = null;
		hvo = new HbeMemberVO();
		hnum = HbeMemberChabun.ymdNum();
		System.out.println("HbeMemberScr.hmemInsert :: HbeMemberChabun.ymdNum() >>> : " + hnum);
		hvo.setHnum(hnum);
		hvo.setHname(hname);
		hvo.setHid(hid);
		hvo.setHpw(hpw);
		hvo.setHbirth(hbirth);
		hvo.setHgender(hgender);
		hvo.setHtel(htel);
		hvo.setHhp(hhp);
		hvo.setHemail(hemail);
		hvo.setHaddr(haddr);
		hvo.setHhobby(hhobby);				
		hvo.setHphoto(hphoto);
		hvo.setHskill(hskill);
		hvo.setHjob(hjob);
		
		boolI = hs.hmemInsert(hvo);

		if (boolI) {
			System.out.println("회원 정보 입력 성공 >>> : " + boolI);	
					
		}else {
			System.out.println("회원 정보 입력 실패 >>> : " + boolI);
		}			
	}
	
	// 회원정보 수정
	public static void hmemUpdate(String sVal[]) {		
		System.out.println("회원정보 수정 >>> : ");
		
		String hnum = sVal[0];				
		String hemail = sVal[1];	
		String haddr = sVal[2];	 
		String hhobby = sVal[3];					
		String hjob = sVal[4];
			
		HbeMemberService hs = new HbeMemberServiceImpl();
		
		HbeMemberVO hvo = null;
		hvo = new HbeMemberVO();
		hvo.setHnum(hnum);			
		hvo.setHemail(hemail);
		hvo.setHaddr(haddr);
		hvo.setHhobby(hhobby);								
		hvo.setHjob(hjob);
		
		boolean boolU = hs.hmemUpdate(hvo);
		if (boolU) {
			System.out.println("회원 정보 수정 성공 >>> : " + boolU);	
						
		}else {
			System.out.println("회원 정보 수정 실패 >>> : " + boolU);
		}				
	}
	
	// 회원 삭제 : FLAG 삭제 DELETYN : N
	public static void hmemDelete(String hnum) {
		System.out.println("회원정보 삭제 >>> : ");
	
		boolean boolD = false;
		HbeMemberService hs = new HbeMemberServiceImpl();
		
		HbeMemberVO hvo = null;
		hvo = new HbeMemberVO();
		
		if (hnum !=null && hnum.length() > 0) {
			hvo.setHnum(hnum);				
			boolD = hs.hmemDelete(hvo);
			
			if (boolD) {
				System.out.println("회원 정보 삭제 성공 >>> : " + boolD);				
			}else {
				System.out.println("회원 정보 삭제 실패 >>> : " + boolD);
			}		
		}else {
			System.out.println("회원번호가 없습니다. >>> : ");
		}
	}	
	
	// 회원정보 INSERT, UPDATE 정보 입력하기 
	public static String[] getParameter(int iVal) {
	
		String sVal[] = null;
		
		// 회원정보 등록 파라미터 
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
		
		// 회원정보 수정 파라미터 
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
	
	// 메인 함수 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("회원정보 CRUD::ISUD 테스트 >>> : ");		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\n회원정보 전체조회:1, 조건조회:2, 등록:3, 수정:4, 삭제:5, 종료:0");
			
			int isud = sc.nextInt();	
			if (0 == isud) break;
			
			switch(isud) {
				case 1:		
					try {
						HbeMemberScr.hmemSelectAll();	
					}catch(Exception e) {						
					}				
					break;
					
				case 2:
					System.out.println("조회조건 회원번호를 입력하시오 >>> : ");
					Scanner sc1 = new Scanner(System.in);
					try {
						String hnum = sc1.next();
						HbeMemberScr.hmemSelect(hnum);	
					}catch(Exception e) {						
					}								
					break;
					
				case 3:
					try {	
						String sVal3[] = HbeMemberScr.getParameter(3);
						HbeMemberScr.hmemInsert(sVal3);	
					}catch(Exception e) {						
					}	
					break;
					
				case 4:
					try {
						String sVal4[] = HbeMemberScr.getParameter(4);
						HbeMemberScr.hmemUpdate(sVal4);	
					}catch(Exception e) {						
					}						
					break;
					
				case 5:
					System.out.println("삭제할 회원번호를 입력하시오 >>> : ");
					Scanner sc2 = new Scanner(System.in);
					try {
						String hnum = sc2.next();
						HbeMemberScr.hmemDelete(hnum);	
					}catch(Exception e) {						
					}							
					break;					
			}
		}
	}
}
