package com.kosmo.csi.member.scr;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosmo.common.CsiMemberChabun;
import com.kosmo.csi.member.service.CsiMemberService;
import com.kosmo.csi.member.service.CsiMemberServiceImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;


public class CsiMemberScr {
	
	public static final String[] insert_label = { "ȸ���̸�", "���̵�", "�н�����", "�������", "����",    
				            					  "��ȭ��ȣ", "�޴�����ȣ", "�̸���", "�ּ�", "���",     
				            					  "����", "Ư��", "����"};
	public static final String[] update_label = {"ȸ����ȣ", "�̸���", "�ּ�", "���", "����"};	

	public static void cmemSelectAll() {
		System.out.println("ȸ������ ��ü��ȸ >>> : ");
		
		CsiMemberService ss = new CsiMemberServiceImpl();		
		ArrayList<CsiMemberVO> aList = ss.cmemSelectAll();

		if (aList !=null && aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				
				CsiMemberVO cvo = aList.get(i);
				CsiMemberVO.printCsiMemberVO(cvo);
			}		
		}else {
			System.out.println("aList �� �����Ͱ� ���׿� >>> : " + aList);
		}
		
	}

	public static void cmemSelect(String cnum) {
		System.out.println("ȸ������ ������ȸ >>> : ");
		
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
					System.out.println("aList �� �����Ͱ� ���׿� >>> : " + aList);
				}	
			}else {
				System.out.println("��ȸ ���� >>> : " + boolS);
			}
		}else {
			System.out.println("ȸ����ȣ�� �����ϴ�. >>> : ");
		}
	}
	
	public static void cmemInsert(String sVal[]) {		
		System.out.println("ȸ������ ��� >>> : ");	
		
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
			System.out.println("ȸ�� ���� �Է� ���� >>> : " + boolI);	
					
		}else {
			System.out.println("ȸ�� ���� �Է� ���� >>> : " + boolI);
		}			
	}
	

	public static void cmemUpdate(String sVal[]) {		
		System.out.println("ȸ������ ���� >>> : ");
		
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
			System.out.println("ȸ�� ���� ���� ���� >>> : " + boolU);	
						
		}else {
			System.out.println("ȸ�� ���� ���� ���� >>> : " + boolU);
		}				
	}
	

	public static void cmemDelete(String cnum) {
		System.out.println("ȸ������ ���� >>> : ");
	
		boolean boolD = false;
		CsiMemberService ss = new CsiMemberServiceImpl();
		
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		
		if (cnum !=null && cnum.length() > 0) {
			cvo.setCnum(cnum);				
			boolD = ss.cmemDelete(cvo);
			
			if (boolD) {
				System.out.println("ȸ�� ���� ���� ���� >>> : " + boolD);				
			}else {
				System.out.println("ȸ�� ���� ���� ���� >>> : " + boolD);
			}		
		}else {
			System.out.println("ȸ����ȣ�� �����ϴ�. >>> : ");
		}
	}	
	
	public static String[] getParameter(int iVal) {
	
		String sVal[] = null;
		
		if (3 == iVal) { 			
			
			sVal = new String[insert_label.length];				
			Scanner sc2 = new Scanner(System.in);
			System.out.println("����� ȸ�������� �Է��Ͻÿ� >>> : " + insert_label.length);
			System.out.println("����� ȸ������ �迭�� ���� >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				System.out.println(insert_label[i] + "��(��) �Է��Ͻÿ� :: " );
				sVal[i] = sc2.next();
				System.out.println(insert_label[i] + " ������ >>> : " + sVal[i]);
			}
		}			
		
	
		if (4 == iVal) { 
		
			sVal = new String[update_label.length];				
			Scanner sc3 = new Scanner(System.in);
			System.out.println("������ ȸ�������� �Է��Ͻÿ� >>> : " + update_label.length);
			System.out.println("������ ȸ������ �迭�� ���� >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				System.out.println(update_label[i] + "��(��) �Է��Ͻÿ� :: " );
				sVal[i] = sc3.next();
				System.out.println(update_label[i] + " ������ >>> : " + sVal[i]);
			}
		}
		
		return sVal;
	}
	
	public static void main(String[] args) {
	
		System.out.println("ȸ������ CRUD::ISUD �׽�Ʈ >>> : ");		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\nȸ������ ��ü��ȸ:1, ������ȸ:2, ���:3, ����:4, ����:5, ����:0");
			
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
					System.out.println("��ȸ���� ȸ����ȣ�� �Է��Ͻÿ� >>> : ");
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
					System.out.println("������ ȸ����ȣ�� �Է��Ͻÿ� >>> : ");
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
