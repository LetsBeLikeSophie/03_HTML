package a.b.c.com.kosmo.notice.service;

import java.util.ArrayList;

import a.b.c.com.kosmo.mem.dao.MemberDAO;
import a.b.c.com.kosmo.mem.dao.MemberDAOImpl;
import a.b.c.com.kosmo.notice.dao.NoticeDAO;
import a.b.c.com.kosmo.notice.dao.NoticeDAOImpl;
import a.b.c.com.kosmo.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public ArrayList<NoticeVO> noticeSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeSelectAll() 함수 진입 >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeSelectAll();
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeSelect() 함수 진입 >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeSelect(nvo);
	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeInsert() 함수 진입 >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeInsert(nvo);
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeUpdate() 함수 진입 >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeUpdate(nvo);
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeDelete() 함수 진입 >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeDelete(nvo);
	}
}
