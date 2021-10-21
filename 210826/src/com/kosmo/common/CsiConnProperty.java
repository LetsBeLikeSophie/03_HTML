package com.kosmo.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public abstract class CsiConnProperty {

//  ����� �����ϱ� ���߿� �����ϱ� ���� �������� ������!
//  ����̹� ���� ������ �� �� ���� 	>> .jar �ȿ� �����ϰ� �ִ��� ������Ʈ�� �� ���� �Ǿ����� Ȯ��
//	��� ���� ������ �� �� ����		>> ��Ʈ�� sid �ٸ��� ��θ� �� ã�ư� �� ����
	private static final String ORCL_JDBC_DIRVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	private static final String ORCL_USER = "csi00";
	private static final String ORCL_PASS = "csi1234";
	
//  connection �� ������ �Լ� Connection Ÿ�� �����ϱ� 	
	public static Connection getConnection() {

//		���� �� �ʱ�ȭ		
		Connection conn = null;

//		try/catch ���� 		
		try {
			Class.forName(CsiConnProperty.ORCL_JDBC_DIRVER);	
			conn = DriverManager.getConnection( CsiConnProperty.ORCL_URL
					                           ,CsiConnProperty.ORCL_USER
					                           ,CsiConnProperty.ORCL_PASS);
			
		}catch (Exception e) {
			System.out.println(   "ConnProperty :: �����ͺ��̽��� �����ϴµ� \n"
					            + "����̹� �Ǵ� ���� �������� ������ ���� >>> : \n" 
								+ e.getMessage() + "\n");
		}
		return conn;
	}
	
//	connection �� close �ϴ� �Լ� �Է°����� ��� ���� 3�� ��Ʈ ���� => ���ϰ� ���� 		
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		
		try{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
			
		}catch (Exception e2){}			
	}

//  �ϳ� �� ����!!! ������?! ResultSet �Ⱦ��� ��쵵 �ݾƾ� �ϴϱ�!
//  (����) �Ƹ� ����ϴ� �Լ������� ResultSet �� �ʿ��ϴ� �Է��ϴ� �Լ����� ���� �� ���ϵ�	
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		
		try{			
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
			
		}catch (Exception e2){}			
	}	
}	
