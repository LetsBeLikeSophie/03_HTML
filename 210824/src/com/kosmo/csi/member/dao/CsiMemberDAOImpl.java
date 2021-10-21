package com.kosmo.csi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kosmo.common.CsiConnProperty;
import com.kosmo.csi.member.sql.CsiMemberSqlMap;
import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberDAO]
//	 [CsiMemberDAOImpl] 				 : 	Interface + Implement 
//										 : 	Interface �� Implement �� ������ �׷���, Interface �� �� ��� ����Ұ����� ����
//										 : 	Implement �� ���� �������ָ� ��.
//										 :	DAO ��Ʈ�� Service ��Ʈ �� �и� �Ǿ� ����������, Service ���� �״�� �Ѱܿ� �Ա� ������ ������ ���� ����� ��.

// 1. CsiMemberDAO �� Implement 
// 2. CsiMemberDAO(�������̽�)�� ����		 : 	[4���� ArrayList Ÿ���� Methods] : (1���� with no argument : selectAll �� �Է°� ����)
//							  			 :	[3���� boolean Ÿ���� Methods]   

// 3. Implement�� �Լ�(���)�� ���Ͽ�			 : 	@Override ���ϸ� ��¥�� Override �϶�� ��� ���
//										 : 	interface �Լ� ���� ���� �Ǿ� �ִ� methods �� �ϳ��� ������ ��� �����⵵ ��
// 4. (�߿�) ǥ�ô� �� ���� �� ��������

public class CsiMemberDAOImpl implements CsiMemberDAO {

//	��ü ���� : SelectAll
	@Override
	public ArrayList<CsiMemberVO> cmemSelectAll() {

// 		�Լ����� �α�
		System.out.println("CsiMemberDAOImpl.cmemSelectAll() �Լ� ���� ");

// 		����� ���� �ʱ�ȭ (��� ���� �� 3�� ��Ʈ + ArrayList (���尪) 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;		
		ArrayList<CsiMemberVO> aList = null;

// 		try/catch ���� (��¥�� �Ⱦ��� �� ��� ���� => Exception ������)
		try {

//   	 	��� ����κ� 
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectAllQuery());
			System.out.println("��ü��ȸ \n" + CsiMemberSqlMap.getCsiMemberSelectAllQuery());			
			rsRs = pstmt.executeQuery();			

// 			if ResultSet �� ���� ������ => ������ ���� ��� ����Ŭ���� ��ȯ�Ǵ� ���� ����. ������ �������� ���ƶ�!
			if (rsRs !=null) {
				
//				ArryList �� �������� 				
				aList = new ArrayList<CsiMemberVO>();

// 				while ResultSet �� ���� ������ ��� ���ƶ�!				
				while (rsRs.next()) {
					
					CsiMemberVO cvo = new CsiMemberVO();
					
//					ResultSet�� �ִ� 1�� �ε��� ���� String���� �����ͼ� cvo �� setter�� ���� ����������(Global variable��)��ȯ					
					cvo.setCnum(rsRs.getString(1)); 
					cvo.setCname(rsRs.getString(2)); 
					cvo.setCid(rsRs.getString(3));
					cvo.setCpw(rsRs.getString(4));
					cvo.setCbirth(rsRs.getString(5));
					cvo.setCgender(rsRs.getString(6));
					cvo.setCtel(rsRs.getString(7));
					cvo.setChp(rsRs.getString(8));
					cvo.setCemail(rsRs.getString(9));
					cvo.setCaddr(rsRs.getString(10));
					cvo.setChobby(rsRs.getString(11));
					cvo.setCphoto(rsRs.getString(12));
					cvo.setCskill(rsRs.getString(13));
					cvo.setCjob(rsRs.getString(14));
					cvo.setDeleteyn(rsRs.getString(15));
					cvo.setInsertdate(rsRs.getString(16));
					cvo.setUpdatedate(rsRs.getString(17));
					
//					���ϰ� ArrayList�� ���ڰ� ���� (ArrayList�� �����迭, ���ϸ� ���ϴµ��� �������� ����) 					
					aList.add(cvo);
				}				
			}
			
// 		����-����-�� ������ �� ��𿡼� ���� ���� ���������� �޽����� ǥ��			
		}catch(Exception e) {
			System.out.println("cmemSelectAll() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}
		return aList;
	}

	
//---------------------------------�Ʒ����� ���� �ߺ��Ǵ� �ּ��� ���� �Ǵ� ������ ����---------------------------------
	
// 	�κ� ���� : Select 
	@Override
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo) {

		System.out.println("CsiMemberDAOImpl.cmemSelect() �Լ� ���� ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

// 		���� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<CsiMemberVO> aList = null;

//		try/catch ����		
		try {
			
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectQuery());
			System.out.println("������ȸ \n" + CsiMemberSqlMap.getCsiMemberSelectQuery());

// (�߿�)		statement �� clear  			
			pstmt.clearParameters();
// 			parameter �������� 
// (�߿�)		parameter �� �Լ��� �ٿ��� ������ ��. ��� argument �� ���ٰ� �����ϴµ�, �� ã�ƺ��� �������� ����.
//			�Ѵ� ������ ���µ� �Լ� �̸�(���) parameter �� ������ �̹� ������ �ִ� �ֵ�, argument �� ���� ������ �� �ִ°Ŷ� ������� (���ĸ� ������)  
//			statement �� setString �̶�� �Լ� ��ü�� Ư�� ���� ������ �ϴµ�.
			pstmt.setString(1, cvo.getCnum());
//			������ 1�� number�� statement �� ���̰� �� ���� ResultSet�� �Ѱ���
			rsRs = pstmt.executeQuery();			
						
			if (rsRs !=null) {
				
				aList = new ArrayList<CsiMemberVO>();

//				ResultSet �� ���� ���� ��� �κ�
				while (rsRs.next()) {
					
					CsiMemberVO _cvo = new CsiMemberVO();
					
					_cvo.setCnum(rsRs.getString(1)); 
					_cvo.setCname(rsRs.getString(2)); 
					_cvo.setCid(rsRs.getString(3));
					_cvo.setCpw(rsRs.getString(4));
					_cvo.setCbirth(rsRs.getString(5));
					_cvo.setCgender(rsRs.getString(6));
					_cvo.setCtel(rsRs.getString(7));
					_cvo.setChp(rsRs.getString(8));
					_cvo.setCemail(rsRs.getString(9));
					_cvo.setCaddr(rsRs.getString(10));
					_cvo.setChobby(rsRs.getString(11));
					_cvo.setCphoto(rsRs.getString(12));
					_cvo.setCskill(rsRs.getString(13));
					_cvo.setCjob(rsRs.getString(14));
					_cvo.setDeleteyn(rsRs.getString(15));
					_cvo.setInsertdate(rsRs.getString(16));
					_cvo.setUpdatedate(rsRs.getString(17));
										
					aList.add(_cvo);
				}				
			}
		}catch(Exception e) {
			System.out.println("cmemSelect() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}
		
		return aList;
	}

//  ���� �˻�, �̸����� 	
	@Override
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo) {

//		�α�
		System.out.println("CsiMemberDAOImpl.cmemSelectName() �Լ� ���� ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		��񿬰� ��Ʈ + ����� ���� ArryaList ���� �� ����ȭ		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<CsiMemberVO> aList = null;
		
//		try/catch ����		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			System.out.println("������ȸ :: ȸ���̸� :: \n" + CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			
// 			parameter = cname			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCname());
			rsRs = pstmt.executeQuery();			
						
			if (rsRs !=null) {
				
				aList = new ArrayList<CsiMemberVO>();

//				ResultSet ��� �κ�				
				while (rsRs.next()) {
					
					CsiMemberVO _cvo = new CsiMemberVO();
					_cvo.setCnum(rsRs.getString(1)); 
					_cvo.setCname(rsRs.getString(2)); 
					_cvo.setCid(rsRs.getString(3));
					_cvo.setCpw(rsRs.getString(4));
					_cvo.setCbirth(rsRs.getString(5));
					_cvo.setCgender(rsRs.getString(6));
					_cvo.setCtel(rsRs.getString(7));
					_cvo.setChp(rsRs.getString(8));
					_cvo.setCemail(rsRs.getString(9));
					_cvo.setCaddr(rsRs.getString(10));
					_cvo.setChobby(rsRs.getString(11));
					_cvo.setCphoto(rsRs.getString(12));
					_cvo.setCskill(rsRs.getString(13));
					_cvo.setCjob(rsRs.getString(14));
					_cvo.setDeleteyn(rsRs.getString(15));
					_cvo.setInsertdate(rsRs.getString(16));
					_cvo.setUpdatedate(rsRs.getString(17));
										
					aList.add(_cvo);
										
				}				
			}
		}catch(Exception e) {
			System.out.println("cmemSelectName() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}
		
		return aList;
	}

//  ���� �˻�, ���̵��	
	@Override
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo) {

//		�α�		
		System.out.println("CsiMemberDAOImpl.cmemSelectId() �Լ� ���� ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		��񿬰� ��Ʈ + ����� ���� ArryaList ���� �� ����ȭ		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<CsiMemberVO> aList = null;
		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			System.out.println("������ȸ :: ȸ���̸� :: \n" + CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			
//			parameter = cid			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCid());
			rsRs = pstmt.executeQuery();			
						
			if (rsRs !=null) {
				
				aList = new ArrayList<CsiMemberVO>();
				
//				ResultSet ��� �κ�						
				while (rsRs.next()) {
					
					CsiMemberVO _cvo = new CsiMemberVO();
					_cvo.setCnum(rsRs.getString(1)); 
					_cvo.setCname(rsRs.getString(2)); 
					_cvo.setCid(rsRs.getString(3));
					_cvo.setCpw(rsRs.getString(4));
					_cvo.setCbirth(rsRs.getString(5));
					_cvo.setCgender(rsRs.getString(6));
					_cvo.setCtel(rsRs.getString(7));
					_cvo.setChp(rsRs.getString(8));
					_cvo.setCemail(rsRs.getString(9));
					_cvo.setCaddr(rsRs.getString(10));
					_cvo.setChobby(rsRs.getString(11));
					_cvo.setCphoto(rsRs.getString(12));
					_cvo.setCskill(rsRs.getString(13));
					_cvo.setCjob(rsRs.getString(14));
					_cvo.setDeleteyn(rsRs.getString(15));
					_cvo.setInsertdate(rsRs.getString(16));
					_cvo.setUpdatedate(rsRs.getString(17));
										
					aList.add(_cvo);
				}				
			}
		}catch(Exception e) {
			System.out.println("cmemSelectId() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}
		
		return aList;
	}	
	
// ���� : Insert	
	@Override
	public boolean cmemInsert(CsiMemberVO cvo) {
		
		System.out.println("CsiMemberDAOImpl cmemInsert() �Լ� ���� >>> : ");
		CsiMemberVO.printlnCsiMemberVO(cvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = CsiConnProperty.getConnection();
			
// (�߿�)		conn.getAutoCommit() => AutoCommit ���� ��������
//			�Ƹ��� Ŀ�����ֱ� ���� �����۾� ���� �����͸� �־���ϱ� ����
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberInsertQuery());
			System.out.println("�Է��ϱ� >>> : \n"+ CsiMemberSqlMap.getCsiMemberInsertQuery());
  			
			pstmt.clearParameters();
			
			pstmt.setString(1, cvo.getCnum()); 
			pstmt.setString(2, cvo.getCname()); 
			pstmt.setString(3, cvo.getCid());   
			pstmt.setString(4, cvo.getCpw());
			pstmt.setString(5, cvo.getCbirth());
			pstmt.setString(6, cvo.getCgender());
			pstmt.setString(7, cvo.getCtel());
			pstmt.setString(8, cvo.getChp());			
			pstmt.setString(9, cvo.getCemail());
			pstmt.setString(10, cvo.getCaddr());
			pstmt.setString(11, cvo.getChobby());
			pstmt.setString(12, cvo.getCphoto());
			pstmt.setString(13, cvo.getCskill());
			pstmt.setString(14, cvo.getCjob());

// (�߿�)		statement �� 	: 1. execute 		>> ��� �� boolean execute ���θ� �˷���
//							  2. executeQuery  	>> ��� �� ResultSet �� ���� ���� 			
//												   SELECT �������� ���!!!!!
// 							  3. executeUpdate 	>> ��� �� int							
//												   INSERT / DELETE / UPDATE ���� ���������� �ݿ��� ���ڵ��� �Ǽ��� ��ȯ!!
//												   CREATE / DROP ���� ���������� -1 �� ��ȯ!!
//												   SELECT ���� ������ �������� ���!!!!!
			nCnt = pstmt.executeUpdate();		
			
			if (!conn.getAutoCommit()) { conn.commit(); }			
			
			System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ��� ");
			
//			���� �ּ� ������ ���ڸ� count �ϰ� ������Ʈ �Ǹ� bool �� true �� �ٲپ ǥ������
			if (nCnt > 0) { bool = true; }
			
			CsiConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
		}finally {
			try {
				CsiConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

//  ���� : Update
	@Override
	public boolean cmemUpdate(CsiMemberVO cvo) {

//		�α�		
		System.out.println("CsiMemberDAOImpl cmemUpdate() �Լ� ���� >>> : ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		��񿬰� ��Ʈ + ����� ���� ArryaList ���� �� ����ȭ				
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = CsiConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberUpdateQuery());
			System.out.println("�����ϱ� >>> : \n"+ CsiMemberSqlMap.getCsiMemberUpdateQuery());

			pstmt.clearParameters();
//			after parameter cleared, cvo�� ������ statement�� ���� 			
			pstmt.setString(1, cvo.getCemail());
			pstmt.setString(2, cvo.getCaddr());
			pstmt.setString(3, cvo.getChobby());			
			pstmt.setString(4, cvo.getCjob());
			pstmt.setString(5, cvo.getCnum()); 

//			commit�� �Ǿ����� (!conn.getAutoCommit()), commit �� Ȯ�� ((nCnt > 0)�϶� bool=true) �Ͽ� ���
			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) { conn.commit(); }			
			
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
			
			if (nCnt > 0) { bool = true; }

			CsiConnProperty.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
			
		}finally {
			try {
				CsiConnProperty.conClose(conn, pstmt);
				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

//  ���� : Delete
	@Override
	public boolean cmemDelete(CsiMemberVO cvo) {

//		�α�
		System.out.println("CsiMemberDAOImpl cmemDelete() �Լ� ���� >>> : ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		��񿬰� ��Ʈ + ����� ���� ArryaList ���� �� ����ȭ				
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;

//		try/catch ����		
		try {
			conn = CsiConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberDeleteQuery());
			System.out.println("�����ϱ� >>> : \n"+ CsiMemberSqlMap.getCsiMemberDeleteQuery());
  			

			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) { conn.commit();	}		
			
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
			
			if (nCnt > 0) { bool = true; }
			
			CsiConnProperty.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
			
		}finally {
			try {
				CsiConnProperty.conClose(conn, pstmt);
				
			}catch(Exception e2) {}
		}
				
		return bool;	
	}
	
}
