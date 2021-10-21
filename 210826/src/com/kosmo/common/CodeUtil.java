package com.kosmo.common;

public abstract class CodeUtil {
	
	
	// ȸ������ ------------------------------------------------------------------------
	// ȸ������ ��
	public static final String[] member_value = { "ȸ����ȣ", "ȸ���̸�", "���̵�", "�н�����", "�������", 
			                                      "����", "��ȭ��ȣ", "�޴�����ȣ", "�̸���", "�ּ�", 
			                                      "���",  "����", "Ư��", "����", "��������", 
			                                      "�����", "������"};	
	public static final String[] member_selectall_value = { "ȸ����ȣ", "ȸ���̸�", "���̵�", "�н�����", "�������", 
												            "����", "��ȭ��ȣ", "�޴�����ȣ", "�̸���", "�ּ�", 
												            "���",  "����", "Ư��", "����", "Y/N", 
												            "�����", "������", "����/����"};		
	// ���� ��
	public static final String[] gender_value = {"����","����"};
	
	// ��ȭ��ȣ ��
	public static final String[] tel_value = {"02","031","032"};
	
	// �ڵ��� ��
	public static final String[] hp_value = {"010","011","017"};
	
	// ��� ��
	public static final String[] hobby_lavel = {"����", "���ǰ���", "�", "����", "��ȭ", "����"};
	public static final String[] hobby_value = {"01", "02", "03", "04", "05", "06"};
	
	// ���� ��
	public static final String[] job_lavel = {"ȸ���", "�ڿ���", "�л�", "�ֺ�", "����", "����"};
	public static final String[] job_value = {"01", "02", "03", "04", "05", "06"};
	
	// ȸ����ü ��ȸ ------------------------------------------------------------------------
	// ȸ����ȸ �� 
	public static final String[] combo_cpation = {"��ü", "�̸�", "���̵�"};
	public static final String[] jbtn_cpation = {"ȸ�����", "ȸ�����"};
	
	// �Խ���  ------------------------------------------------------------------------
	// �Խ������� ��
	public static final String[] board_label = {"�۹�ȣ", "������", "�ۼ���", "��й�ȣ", "�۳���"};
	public static final String[] board_selectall_label = {"�۹�ȣ", "������", "�ۼ���", "��й�ȣ", "�۳���", 
														  "Y/N", "�����", "������", "����/����"};
	
	public static final String[] board_combo_cpation = {"��ü", "������", "�ۼ���"};
	public static final String[] board_jbtn_cpation = {"�ۼ��ϱ�", "�۸��"};	
	
	
//  1. Birth : ���� ä�� >> ��/��/�Ϸ� �и�
	public static String birth(String dateOfBirth) {

		String year = "";
		String month = "";
		String date = "";
		String dob = "";
		
		if (dateOfBirth !=null && dateOfBirth.length() > 0){			
			int lengthOfString = dateOfBirth.length();		
			
			if (8 == lengthOfString) {
				year = dateOfBirth.substring(0, 4);
				month = dateOfBirth.substring(4, 6);
				date = dateOfBirth.substring(6);				
				dob = year + "-" + month + "-" + date;
			}
		}		
		return dob;
	}

//  2. Gender : ��ȣ�� ���� �з� >> 01 ����, 02 ����	
	public static String gender(String genderType) {
		
		String genderReturn = "";	
		
		if (genderType !=null && genderType.length() > 0){
			
			if ("01".equals(genderType)) {
				genderReturn = "����";
				
			}else if ("02".equals(genderType)){
				genderReturn = "����";
			}			
		}			
		return genderReturn;
	}
	
//  3. Tel : �Ϲ� ��ȭ��ȣ >> 10�ڸ��� ���, 11�ڸ��� ��� 
	public static String tel(String telNum) {

		String tel1 = "";
		String tel2 = "";
		String tel3 = "";
		String telReturn = "";
		
		if (telNum !=null && telNum.length() > 0){			
			int lengthOfTelNum = telNum.length();	
			
			if (10 == lengthOfTelNum) {
				tel1 = telNum.substring(0, 2);
				tel2 = telNum.substring(2, 6);
				tel3 = telNum.substring(6);
				telReturn = tel1 + "-" + tel2 + "-" + tel3;
			}		
			
			if (11 == lengthOfTelNum) {
				tel1 = telNum.substring(0, 3);
				tel2 = telNum.substring(3, 7);
				tel3 = telNum.substring(7);
				telReturn = tel1 + "-" + tel2 + "-" + tel3;
			}
		}
		return telReturn;
	}
	
//  4. Hp : �ڵ��� ��ȣ >> 10�ڸ��� ���, 11�ڸ��� ���
	public static String hp(String phoneNum) {

		String phoneNum1 = "";
		String phoneNum2 = "";
		String phoneNum3 = "";
		String phoneNumReturn = "";
		
		if (phoneNum !=null && phoneNum.length() > 0){		
			
			int lengthOfPhoneNum = phoneNum.length();	
			
// (�߰�)		���� �Ϲ���ȭ��ȣ ó�� �߰��� Ȥ�� 10�ڸ��� ���			
			if (10 == lengthOfPhoneNum) {
				phoneNum1 = phoneNum.substring(0, 2);
				phoneNum2 = phoneNum.substring(2, 6);
				phoneNum3 = phoneNum.substring(6);
				phoneNumReturn = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
			}
			
			if (11 == lengthOfPhoneNum) {
				phoneNum1 = phoneNum.substring(0, 3);
				phoneNum2 = phoneNum.substring(3, 7);
				phoneNum3 = phoneNum.substring(7);
				phoneNumReturn = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
			}
		}		
		return phoneNumReturn;
	}

//  5-1. ��̹�ȣ (01,02,..) �޾Ƽ� ��̸� (����,���ǰ���,..) �� ������ 	
	public static String hobby(String hobbyNum) {
		
		String selectedHobby = "";				
		if (hobbyNum !=null && hobbyNum.length() > 0){		
			
//			hobby ������ ����ִ� �迭 hobby_lavel ��ŭ for ����
			for (int i=1; i < hobby_lavel.length; i++) {	

//				�ƴ� �̰� ��.."0" + i => String+int=>String���� �� ����
				if (("0" + i).equals(hobbyNum)) {
					selectedHobby = CodeUtil.hobby_lavel[i-1];
				}
			}			
		}		
		return selectedHobby;
	}
	
//  5-2. ��̸� (����,���ǰ���,..) �� ��̹�ȣ (01,02,..) �� ��ȯ�ϱ�
	public static String setHobby(String selectedhobby) {
		
		String hobbyNum = "";		
		
		for (int i=0; i < CodeUtil.hobby_lavel.length; i++) {	
			
			if (CodeUtil.hobby_lavel[i].equals(selectedhobby)) {
				hobbyNum = CodeUtil.hobby_value[i];
			}			
		}		
		return hobbyNum;
	}
	
//  6-1. ������ (ȸ���,�ڿ���,..) �� ������ȣ (01,02,..) �� ��ȯ�ϱ�
	public static String job(String selectedJob) {
		
		String jobNum = "";	
		
		if (selectedJob !=null && selectedJob.length() > 0){	
			
			for (int i=1; i < job_lavel.length; i++) {	
				
				if (("0" + i).equals(selectedJob)) {
					jobNum = CodeUtil.job_lavel[i-1];
				}
			}		
		}		
		return jobNum;
	}
	
//  6-2. ������ȣ (01,02,..) �� �޾Ƽ� ������ (ȸ���,�ڿ���,..) ���� ������
	public static String setJob(String jobNum) {
		
		String selectedJob = "";
		
		for (int i=0; i < CodeUtil.job_lavel.length; i++) {			
			
			if (CodeUtil.job_lavel[i].equals(jobNum)) {
				selectedJob = CodeUtil.job_value[i];
			}			
		}	
		return selectedJob;
	}
	
// 	�߰��� 0001 �ڸ��� ä��� �Լ�,  ȸ����ȣ (cnum)�� ä���� �� ���� 0 �ٿ��� ä��� 
//	�ٵ� ���� ������� �ʾ��� (0824 ����)
//  ���� ä��� ���� �Լ��� ���� : ��) String addZero = String.format("%02d", numbers[n]);
//  % ���ɱ�ȣ, 0 ä�� ����, 2 �ڸ���, d 10���� 	
	public static String numPad(String cnum) {
		
		int lengthOfCnum = cnum.length();		
		
		for (int i=lengthOfCnum; i < 4; i++) {
			cnum = "0" + cnum;
		}		
		return cnum;
	}

	
// 	���߿� �߰��Ͻźκ�
	public static int getComboIndex(String s) {		
		int c = 0;			
		if ("01".equals(s)) { c = 0; }		
		if ("02".equals(s)) { c = 1; }		
		if ("03".equals(s)) { c = 2; }
		if ("04".equals(s)) { c = 3; }		
		if ("05".equals(s)) { c = 4; }		
		if ("06".equals(s)) { c = 5; }
		return c;
	}	
	
	
	
//  Ȯ��!	
	public static void main(String args[]) {
		
		// �������
		String birth = CodeUtil.birth("20210801");		
		System.out.println("birth >>> : " + birth);
		
		// ��ȭ��ȣ
		String tel = CodeUtil.tel("03212341234");		
		System.out.println("tel >>> : " + tel);
		
		// �ڵ���
		String hp = CodeUtil.tel("01012341234");		
		System.out.println("hp >>> : " + hp);		
		
		// ����
		String gender = CodeUtil.gender("02");
		System.out.println("gender >>> : " + gender);
		// ���
		String hobby = CodeUtil.hobby("02");
		System.out.println("hobby >>> : " + hobby);
		// ����
		String job = CodeUtil.job("02");
		System.out.println("job >>> : " + job);
	}
	
	

}