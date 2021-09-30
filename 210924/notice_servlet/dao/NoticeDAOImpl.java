package a.b.c.com.kosmo.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.kosmo.notice.sql.NoticeSqlMap;
import a.b.c.com.kosmo.notice.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public ArrayList<NoticeVO> noticeSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl.noticeSelectAll() �Լ� ���� ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<NoticeVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectAllQuery());
			
			System.out.println("��ü��ȸ \n" + NoticeSqlMap.getNoticeSelectAllQuery());			
			
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<NoticeVO>();
				
				while (rsRs.next()) {
					
					NoticeVO _nvo = new NoticeVO();
					
					_nvo.setNnum(rsRs.getString(1)); 
					_nvo.setNsubject(rsRs.getString(2)); 
					_nvo.setNmemo(rsRs.getString(3));				
					_nvo.setNphoto(rsRs.getString(4));									
					_nvo.setDeleteyn(rsRs.getString(5));
					_nvo.setInsertdate(rsRs.getString(6));
					_nvo.setUpdatedate(rsRs.getString(7));
					
					aList.add(_nvo);
					NoticeVO.printNoticeVO(_nvo);
				}				
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("noticeSelectAll() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl.noticeSelect() �Լ� ���� ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<NoticeVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectQuery());			
			System.out.println("������ȸ \n" + NoticeSqlMap.getNoticeSelectQuery());			
			
			pstmt.clearParameters();
			// �÷��̽�Ȧ���� ���ε��� ������ �����Ѵ�. 
			pstmt.setString(1, nvo.getNnum());
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<NoticeVO>();
				
				while (rsRs.next()) {
					
					NoticeVO _nvo = new NoticeVO();
					
					_nvo.setNnum(rsRs.getString(1)); 
					_nvo.setNsubject(rsRs.getString(2)); 
					_nvo.setNmemo(rsRs.getString(3));				
					_nvo.setNphoto(rsRs.getString(4));									
					_nvo.setDeleteyn(rsRs.getString(5));
					_nvo.setInsertdate(rsRs.getString(6));
					_nvo.setUpdatedate(rsRs.getString(7));
					
					aList.add(_nvo);
					NoticeVO.printNoticeVO(_nvo);
				}				
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("noticeSelect() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	

	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeInsert() �Լ� ���� >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeInsertQuery());
			System.out.println("�Է��ϱ� >>> : \n"+ NoticeSqlMap.getNoticeInsertQuery());
  			
			// �Ķ���� Ŭ���� �� �ϱ� 
			pstmt.clearParameters();			
			pstmt.setString(1, nvo.getNnum()); 
			pstmt.setString(2, nvo.getNsubject()); 
			pstmt.setString(3, nvo.getNmemo());   
			pstmt.setString(4, nvo.getNphoto());

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ��� ");
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeUpdate() �Լ� ���� >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeUpdateQuery());
			System.out.println("�����ϱ� >>> : \n"+ NoticeSqlMap.getNoticeUpdateQuery());
  			
			// �Ķ���� Ŭ���� �� �ϱ� 
			pstmt.clearParameters();						
			pstmt.setString(1, nvo.getNsubject()); 
			pstmt.setString(2, nvo.getNmemo());   		
			pstmt.setString(3, nvo.getNnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("���� ��񿬵��� ������ ������ϴ�. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeDelete() �Լ� ���� >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(NoticeSqlMap.detNoticeDeleteQuery());
			System.out.println("�����ϱ� >>> : \n"+ NoticeSqlMap.detNoticeDeleteQuery());
  			
			// �Ķ���� Ŭ���� �� �ϱ� 
			pstmt.clearParameters();									
			pstmt.setString(1, nvo.getNnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("���� ��񿬵��� ������ ������ϴ�. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

}
