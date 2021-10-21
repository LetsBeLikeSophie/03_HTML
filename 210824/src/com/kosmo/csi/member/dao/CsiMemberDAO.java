package com.kosmo.csi.member.dao;

import java.util.ArrayList;

import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberDAO]
// 	 [CsiMemberDAOImpl] 				 : 	Interface + Implement 
//										 : 	Interface �� Implement �� ������ �׷���, Interface �� �� ��� ����Ұ����� ����
//										 : 	Implement �� ���� �������ָ� ��.
//										 :	DAO ��Ʈ�� Service ��Ʈ �� �и� �Ǿ� ����������, Service ���� �״�� �Ѱܿ� �Ա� ������ ������ ���� ����� ��.

public interface CsiMemberDAO {
	
	public ArrayList<CsiMemberVO> cmemSelectAll();
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo);	
	
	public boolean cmemInsert(CsiMemberVO cvo);
	public boolean cmemUpdate(CsiMemberVO cvo);
	public boolean cmemDelete(CsiMemberVO cvo);
	
}
