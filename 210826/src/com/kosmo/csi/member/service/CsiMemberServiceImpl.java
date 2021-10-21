package com.kosmo.csi.member.service;

import java.util.ArrayList;

import com.kosmo.csi.member.dao.CsiMemberDAO;
import com.kosmo.csi.member.dao.CsiMemberDAOImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberService]
//	 [CsiMemberServiceImpl] 			 : 	Interface + Implement 
//										 : 	Interface �� Implement �� ������ �׷���, Interface �� �� ��� ����Ұ����� ����
//										 : 	Implement �� ���� �������ָ� ��.
//										 :	 Service ��Ʈ�� DAO ��Ʈ �� �и� �Ǿ� ����������, DAO�� ����� ��.

//  1. CsiMemberService �� Implement 
//  2. CsiMemberService(�������̽�)�� ����	 : 	[4���� ArrayList Ÿ���� Methods] : (1���� with no argument : selectAll �� �Է°� ����)
// 							  				[3���� boolean Ÿ���� Methods]   

// 	3. Implement�� �Լ�(���)�� ���Ͽ�		 : 	@Override ���ϸ� ��¥�� Override �϶�� ��� ���
// 										 : 	interface �Լ� ���� ���� �Ǿ� �ִ� methods �� �ϳ��� ������ ��� �����⵵ ��

public class CsiMemberServiceImpl implements CsiMemberService {

//	��ü ���� : SelectAll
	@Override
	public ArrayList<CsiMemberVO> cmemSelectAll() {

		System.out.println("CsiMemberServiceImpl.cmemSelectAll() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		ArrayList<CsiMemberVO> aList = cdao.cmemSelectAll();
		return aList;
	}
	
// �κ� ���� : Select
	@Override
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemSelect() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		ArrayList<CsiMemberVO> aList = cdao.cmemSelect(cvo);
		return aList;
	}

// ������ȸ, ȸ�� �̸����� 
	@Override
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemSelectName() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl(); 
		return cdao.cmemSelectName(cvo);
	}

// ������ȸ, ȸ�� ���̵��	
	@Override
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemSelectId() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl(); 
		return cdao.cmemSelectId(cvo);

	}
	
// ���� : Insert
	@Override
	public boolean cmemInsert(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemInsert() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		boolean bool = cdao.cmemInsert(cvo);
		return bool;
	}

// ���� : Update
	@Override
	public boolean cmemUpdate(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemUpdate() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		boolean bool = cdao.cmemUpdate(cvo);
		return bool;
	}
	
// ���� : Delete
	@Override
	public boolean cmemDelete(CsiMemberVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("CsiMemberServiceImpl.cmemDelete() �Լ� ���� ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		boolean bool = cdao.cmemDelete(cvo);
		return bool;
	}


}
