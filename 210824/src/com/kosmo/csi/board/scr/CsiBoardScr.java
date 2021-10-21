package com.kosmo.csi.board.scr;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosmo.common.CsiBoardChabun;
import com.kosmo.csi.board.service.CsiBoardService;
import com.kosmo.csi.board.service.CsiBoardServiceImpl;
import com.kosmo.csi.board.vo.CsiBoardVO;


public class CsiBoardScr {
	

	public static final String[] insert_label = {"������", "�ۼ���", "�۳���", "��й�ȣ"};
	public static final String[] update_label = {"�۹�ȣ", "������", "�۳���"};	

	public static void cboardSelectAll(){
		
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	

			ArrayList<CsiBoardVO> aList = ss.cboardSelectAll();

			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {				
					CsiBoardVO cvo = aList.get(i);	
					CsiBoardVO.printCsiBoardVO(cvo);
				}		
			}else {
				System.out.println("aList �� �����Ͱ� ���׿� >>> : " + aList);
			}
		}catch(Exception e) {
			System.out.println("��� �� ������ >>> : " + e.getMessage());
		}
	}
	
	public static void cboardSelect(String sVal[]){
		System.out.println("CsiBoardScr.cboardSelect() �Լ� ���� >>> : ");
		System.out.println("ȸ������ ��ȸ >>> : " + sVal[0]);
				
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			cvo.setBnum(sVal[0]);

			ArrayList<CsiBoardVO> aList = ss.cboardSelect(cvo);

			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {				
					CsiBoardVO _cvo = aList.get(i);	
					CsiBoardVO.printCsiBoardVO(_cvo);
				}		
			}else {
				System.out.println("aList �� �����Ͱ� ���׿� >>> : " + aList);
			}
		}catch(Exception e) {
			System.out.println("��� �� ������ >>> : " + e.getMessage());
		}
		
	}
	
	public static void cboardInsert(String sVal[]){
		System.out.println("CsiBoardScr.cboardInsert() �Լ� ���� >>> : ");
		System.out.println("ȸ������ �Է� >>> : " + sVal.length);
		
		for (int i=0; i < sVal.length; i++){
			System.out.println(insert_label[i] + " >>> : " + sVal[i]);
		}
		
		String bnum = CsiBoardChabun.gubunNum();
		String bsubject = sVal[0];
		String bwriter = sVal[1];
		String bpw = sVal[2];
		String bcontents = sVal[3];
		
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			
			cvo.setBnum(bnum);
			cvo.setBsubject(bsubject);
			cvo.setBwriter(bwriter);			
			cvo.setBcontents(bcontents);
			cvo.setBpw(bpw);
			
			int nCnt = ss.cboardInsert(cvo);					
			
			if (nCnt > 0) {				
				System.out.println("�Խñ� " + nCnt + " �� ��� �Ǿ����ϴ�.");				
			}else {
				System.out.println("�Խñ� ��� ����.");
			}			
		}catch(Exception e) {
			System.out.println("��� �� ������ >>> : " + e.getMessage());
		}
	}
	
	public static void cboardUpdate(String sVal[]){
		System.out.println("CsiBoardScr.cboardUpdate() �Լ� ���� >>> : ");
		System.out.println("ȸ������ ���� >>> : " + sVal.length);
		
		for (int i=0; i < sVal.length; i++){
			System.out.println(update_label[i] + " >>> : " + sVal[i]);
		}
		
		String bnum = sVal[0];		
		String bsubject = sVal[1];
		String bcontents = sVal[2];
		
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			
			cvo.setBnum(bnum);
			cvo.setBsubject(bsubject);
			cvo.setBcontents(bcontents);
						
			int nCnt = ss.cboardUpdate(cvo);	
			
			if (nCnt > 0) {				
				System.out.println("�Խñ� " + nCnt + " �� ���� �Ǿ����ϴ�.");				
			}else {
				System.out.println("�Խñ� ���� ����.");
			}			
		}catch(Exception e) {
			System.out.println("���� �� ������ >>> : " + e.getMessage());
		}				 
	}
	
	public static void cboardDelete(String sVal[]){
		System.out.println("CsiBoardScr.cboardDelete() �Լ� ���� >>> : ");
		System.out.println("ȸ������ ���� >>> : " + sVal[0]);

		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			
			cvo.setBnum(sVal[0]);
						
			int nCnt = ss.cboardDelete(cvo);	
			
			if (nCnt > 0) {				
				System.out.println("�Խñ� " + nCnt + " �� ���� �Ǿ����ϴ�.");				
			}else {
				System.out.println("�Խñ� ���� ����.");
			}			
		}catch(Exception e) {
			System.out.println("���� �� ������ >>> : " + e.getMessage());
		}				 
	}
	
	public static String[] getParameter(int iVal) {
	
		String sVal[] = null;
		
		if (2 == iVal || 5 == iVal) {
			sVal = new String[1];
			
			System.out.println("��ȸ �Ǵ� ������ �Խ��� �۹�ȣ �Է��Ͻÿ� >>> : ");
			
			Scanner sc25 = new Scanner(System.in);
			
			sVal[0] = sc25.next();
			
			System.out.println("��ȸ �Ǵ� ������ �Խ��� ������ >>> : " + sVal[0]);
		}
		
		if (3 == iVal) { 			
			
			sVal = new String[insert_label.length];	
			
			Scanner sc3 = new Scanner(System.in);
			
			System.out.println("����� �Խ��������� �Է��Ͻÿ� >>> : " + insert_label.length);
			System.out.println("����� �Խ��� �迭�� ���� >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				System.out.println(insert_label[i] + "��(��) �Է��Ͻÿ� :: " );
				sVal[i] = sc3.next();
				System.out.println(insert_label[i] + " ������ >>> : " + sVal[i]);
			}
		}			
		
		if (4 == iVal) { 
		
			sVal = new String[update_label.length];				
			
			Scanner sc4 = new Scanner(System.in);
			
			System.out.println("������ �Խ��������� �Է��Ͻÿ� >>> : " + update_label.length);
			System.out.println("������ �Խ������� �迭�� ���� >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				
				System.out.println(update_label[i] + "��(��) �Է��Ͻÿ� :: " );
				
				sVal[i] = sc4.next();
				
				System.out.println(update_label[i] + " ������ >>> : " + sVal[i]);
			}
		}
		
		return sVal;
	}	
	
	public static void main(String[] args) {

		System.out.println("�Խ��� CRUD::ISUD �׽�Ʈ >>> : ");		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\n�Խ������� ��ü��ȸ:1, ������ȸ:2, ���:3, ����:4, ����:5, ����:0");
			
			int isud = sc.nextInt();	
			if (0 == isud) {
				System.out.println("���α׷� ���� !!"); 
				break;	
			}
			 
			
			switch(isud) {
				case 1:		
					try {
						CsiBoardScr.cboardSelectAll();
					}catch(Exception e) {						
					}
					break;
					
				case 2:				
					try {
						String sVal2[] = CsiBoardScr.getParameter(2);
						CsiBoardScr.cboardSelect(sVal2);
					}catch(Exception e) {						
					}								
					break;
					
				case 3:
					try {
						String sVal3[] = CsiBoardScr.getParameter(3);
						CsiBoardScr.cboardInsert(sVal3);
					}catch(Exception e) {						
					}
					break;
					
				case 4:
					try {
						String sVal4[] = CsiBoardScr.getParameter(4);
						CsiBoardScr.cboardUpdate(sVal4);
					}catch(Exception e) {						
					}				
					break;
					
				case 5:				
					try {
						String sVal5[] = CsiBoardScr.getParameter(5);
						CsiBoardScr.cboardDelete(sVal5);							
					}catch(Exception e) {						
					}								
					break;					
			}
		}
	}
}
