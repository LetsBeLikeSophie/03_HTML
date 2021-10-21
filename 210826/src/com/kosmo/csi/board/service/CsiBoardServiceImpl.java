package com.kosmo.csi.board.service;

import java.util.ArrayList;

import com.kosmo.csi.board.dao.CsiBoardDAO;
import com.kosmo.csi.board.dao.CsiBoardDAOImpl;
import com.kosmo.csi.board.vo.CsiBoardVO;


public class CsiBoardServiceImpl implements CsiBoardService {

	@Override
	public ArrayList<CsiBoardVO> cboardSelectAll() {
		
		System.out.println("CsiBoardServiceImpl cboardSelectAll() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardSelectAll();
	}

	@Override
	public ArrayList<CsiBoardVO> cboardSelect(CsiBoardVO hvo) {
		
		System.out.println("CsiBoardServiceImpl cboardSelect() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardSelect(hvo);
	}

	@Override
	public int cboardInsert(CsiBoardVO hvo) {
		
		System.out.println("CsiBoardServiceImpl cboardInsert() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardInsert(hvo);
	}

	@Override
	public int cboardUpdate(CsiBoardVO hvo) {
		
		System.out.println("CsiBoardServiceImpl cboardUpdate() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardUpdate(hvo);
	}

	@Override
	public int cboardDelete(CsiBoardVO hvo) {
		
		System.out.println("CsiBoardServiceImpl cboardDelete() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardDelete(hvo);
	}

	@Override
	public ArrayList<CsiBoardVO> cboardSelectSubject(CsiBoardVO hvo) {
		
		System.out.println("CsiBoardServiceImpl cboardSelectSubject() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardSelectSubject(hvo);
	}

	@Override
	public ArrayList<CsiBoardVO> cboardSelectWriter(CsiBoardVO hvo) {
		
		System.out.println("CsiBoardServiceImpl cboardSelectWriter() 함수 진입 >>> : ");
		
		CsiBoardDAO cdao = new CsiBoardDAOImpl();		
		return cdao.cboardSelectWriter(hvo);
	}
}
