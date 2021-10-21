package com.kosmo.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.csi.member.sql.CsiMemberSqlMap;

public class CsiMemberChabun {
	
	public static final String BIZ_GUBUN_M = "M"; 

	public static String ymdNum() {
		
// 		�������� ���� �ϰ� �ʱ�ȭ �ϱ� 		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNO = "";

// 		try/catch ����		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberChabunQuery());
			System.out.println("ȸ��ä�� ���� >>> \n" + CsiMemberSqlMap.getCsiMemberChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
//					�������� �̸��� COMMNO���� ���� ������ ���� 4�� �� �ƽ����� +1 �� ä��
//				 	�� �򰥸��� ���󰡼� ������ ��. CsiBoardSqlMap ���� getCboardChabunQueryMap							
					commNO = rsRs.getString("COMMNO");									
				}
			}else {
				System.out.println("ä������ ���� >>> : ");
			}
			
//			�α׽���

			System.out.println("commNO >>> : " + commNO);		// 1	

			//			�ڸ�����ŭ 0�� ä���ִ� �Լ�			
			commNO = CodeUtil.numPad(commNO);					
			System.out.println("commNO >>> : " + commNO);		// 0001

//			���� ���� ������ DateUtil���� ��¥���� �����ͼ� commNO (���� 0001) ����			
			commNO = DateUtil.yyyymmdd().concat(commNO);
			System.out.println("commNO >>> : " + commNO);		// 202108240001

// 			�������� �ڵ� ���̱� BIZ_GUBUN_M(=M��) �� 202108240001 ���� 
			commNO = CsiMemberChabun.BIZ_GUBUN_M.concat(commNO);
			System.out.println("commNO >>> : " + commNO);		// M202108240001
			
			CsiConnProperty.conClose(conn, pstmt, rsRs);			
			
		}catch(Exception e) {
			System.out.println("CsiMemberChabun ymdNum ��� ���� >>> : " + e.getMessage());
			
		}finally {
			CsiConnProperty.conClose(conn, pstmt, rsRs);
			
		}
//		commNO == M202108240001 returned		
		return commNO;
	}

	public static void main(String[] args) {
		String commNO = CsiMemberChabun.ymdNum();
		System.out.println("main :: commNO >>> : " + commNO);
	}
}
