package com.kosmo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

// 	��¥ ���� ����� ����	
	public static String yyyymmdd() {		
		return new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
	}
		
	public static String yyyymm() {		
		return new SimpleDateFormat("yyyyMM").format(new Date()).toString();
	}
	
	public static String yyyy() {		
		return new SimpleDateFormat("yyyy").format(new Date()).toString();
	}

//  ���� �𸣰�����	
	public static String cTime(){
		
		long time = System.currentTimeMillis();	
		
//		����� �ּ� �ű�		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
//		String cTime = sdf.format(new java.util.Date(time));
//		return cTime;
		
		return new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date(time)).toString();
	}

//  ���⼭ ���� combo ��, ��, �� �Լ�
//	�� Ŭ������ �� �Ʒ��� �������鼭 �����ϳ� �ϰԲ� ����°� ����.
//	�迭�� �� ���ڵ��� �Է�����
	
	public static String[] comboYear(){
		
		int currentYear = Integer.parseInt(DateUtil.yyyy());
		int firstYear = 1900;
		
//		2021 - 1900 => 121 + 2 => 123 
//		???????? �� 123�⵵ ��ŭ ������ �Ͻô����� �� ���ذ� �Ȱ�. ���� �׳� 2ĭ �����ְ�? ��� ����
//		��·�� �迭�� ũ��� 123		
		String[] years = new String[currentYear - firstYear + 2];
//		ù��°���� "�⵵"�� ��  >> �� �޿� ������ ������ ���� ������ �� �����ϸ� ��
//		�ι�°���� �� �⵵ ���, currentYear-- �������� (�Ʒ��� �� ���� ������ �⵵ /���� ����)		
		years[0] = "�⵵";
		
		for (int i=1; i < years.length; i++ ){
			years[i] = String.valueOf(currentYear--);
		}
		return years;
	}
	
	public static String[] comboMonth(){
		
// 		���� ���� ��� �� ǥ���ϱ�		
		String[] months = new String[13];
		months[0] = "��";
		
		for (int i=1; i < months.length; i++ ){		
			months[i] = String.valueOf(i);

//			���� �ڸ����� 1�ڸ��� 0�ٿ��� (�� �� ����� �ֳ�!)			
			if (1 == months[i].length()) {
				months[i] = "0" + i;
			}
		}
		return months;
	}

	public static String[] comboDay(){
		
		String[] days = new String[32];
		days[0] = "��";
		
		for (int i=1; i <days.length; i++ ){
			days[i] = String.valueOf(i);
			
			if (1 == days[i].length()) {
				days[i] = "0" + i;
			}
		}
		return days;
	}		
	
	public static void main(String args[]) {
		String d = DateUtil.yyyymmdd();
		System.out.println("d >>> : " + d); 					// 20210824
		System.out.println("dt >>> : " + DateUtil.cTime());		// 20210824 18:14:20 
//		Month �迭 ��� 
		String m[] = DateUtil.comboMonth();						
		for (int i=0; i < m.length; i++) {
			System.out.println("m["+i+"] >>> : " + m[i]);
		}
	}
}
