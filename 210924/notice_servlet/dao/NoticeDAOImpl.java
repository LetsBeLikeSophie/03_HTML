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
		System.out.println("NoticeDAOImpl.noticeSelectAll() 함수 진입 ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<NoticeVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectAllQuery());
			
			System.out.println("전체조회 \n" + NoticeSqlMap.getNoticeSelectAllQuery());			
			
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
			System.out.println("noticeSelectAll() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl.noticeSelect() 함수 진입 ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<NoticeVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectQuery());			
			System.out.println("조건조회 \n" + NoticeSqlMap.getNoticeSelectQuery());			
			
			pstmt.clearParameters();
			// 플레이스홀더에 바인딩한 변수를 세팅한다. 
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
			System.out.println("noticeSelect() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	

	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeInsert() 함수 진입 >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeInsertQuery());
			System.out.println("입력하기 >>> : \n"+ NoticeSqlMap.getNoticeInsertQuery());
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();			
			pstmt.setString(1, nvo.getNnum()); 
			pstmt.setString(2, nvo.getNsubject()); 
			pstmt.setString(3, nvo.getNmemo());   
			pstmt.setString(4, nvo.getNphoto());

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
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
		System.out.println("NoticeDAOImpl noticeUpdate() 함수 진입 >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeUpdateQuery());
			System.out.println("수정하기 >>> : \n"+ NoticeSqlMap.getNoticeUpdateQuery());
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();						
			pstmt.setString(1, nvo.getNsubject()); 
			pstmt.setString(2, nvo.getNmemo());   		
			pstmt.setString(3, nvo.getNnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("수정 디비연동에 문제가 생겼습니다. >>> : " + e);
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
		System.out.println("NoticeDAOImpl noticeDelete() 함수 진입 >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(NoticeSqlMap.detNoticeDeleteQuery());
			System.out.println("삭제하기 >>> : \n"+ NoticeSqlMap.detNoticeDeleteQuery());
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();									
			pstmt.setString(1, nvo.getNnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("삭제 디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

}
