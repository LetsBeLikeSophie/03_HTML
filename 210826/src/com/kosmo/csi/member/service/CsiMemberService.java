package com.kosmo.csi.member.service;

import java.util.ArrayList;

import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberService]
//	 [CsiMemberServiceImpl] 			 : 	Interface + Implement 
//										 : 	Interface �� Implement �� ������ �׷���, Interface �� �� ��� ����Ұ����� ����
//										 : 	Implement �� ���� �������ָ� ��.
//										 :	Service ��Ʈ�� DAO ��Ʈ �� �и� �Ǿ� ����������, DAO�� ����� ��.

public interface CsiMemberService {
	
	public ArrayList<CsiMemberVO> cmemSelectAll();
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo);
	
	public boolean cmemInsert(CsiMemberVO cvo);
	public boolean cmemUpdate(CsiMemberVO cvo);
	public boolean cmemDelete(CsiMemberVO cvo);
	
}
