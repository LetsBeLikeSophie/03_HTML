package com.kosmo.csi.member.scr;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.kosmo.common.CodeUtil;
import com.kosmo.common.DateUtil;
import com.kosmo.common.CsiMemberChabun;
import com.kosmo.csi.member.service.CsiMemberService;
import com.kosmo.csi.member.service.CsiMemberServiceImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;


public class CsiMember extends JFrame implements ActionListener {

	private static final long serialVersionUID = 9072198881429763467L;

//  �迭 ����
	private JLabel      jl[];
	private JTextField  jt[];
	private JTextField  jtFiled[];
	private JButton     jb[];
	private JPanel      jp[];
	private JComboBox<String> jc[];
	private JComboBox<String> jcBirth[];
	private JRadioButton        jr[];
	
	@SuppressWarnings("unchecked")
	public CsiMember() {
		
		this.setTitle(":::ȸ������:::");
		
//		�� �̰� �ؿ� panel �� ���̴� �� ���µ�..���߿� ���� ������ ��. �̰� ���� Ʋ�� ����.		
		this.getContentPane().setLayout(null);		
		
//		jp[0]�� �ִ� jPanel 		
		jp = new JPanel[2];		
		jp[0] = new JPanel();
		
		jp[0].setBorder(new EtchedBorder());
		jp[0].setBounds(0, 0, 420, 880);
		jp[0].setBackground(Color.cyan);
		jp[0].setLayout(null);
		
		jc = new JComboBox[5];
		jcBirth = new JComboBox[5];
		jr = new JRadioButton[2];
		jtFiled = new JTextField[6];
		jt = new JTextField[17];
		
		int ty = 80;
		
		for (int i=0; i < jt.length; i++) {
							
			if ( 4 == i || 5 == i || 6 == i || 7 == i || 8 == i || 10 == i || 13 == i) {
				System.out.println(">>>>>>>> " + i);
				
				if (4 == i) {
					String[] years = DateUtil.comboYear();
					jc[0] = new JComboBox<String>(years);
					jp[0].add(jc[0]);
					jc[0].setBackground(Color.white);
					jc[0].setSelectedIndex(0);
					jc[0].setBounds(130, 240, 80, 30);
					
					String[] months = DateUtil.comboMonth();
					jcBirth[0] = new JComboBox<String>(months);
					jp[0].add(jcBirth[0]);
					jcBirth[0].setBackground(Color.white);
					jcBirth[0].setSelectedIndex(0);
					jcBirth[0].setBounds(220, 240, 65, 30);
					
					String[] days = DateUtil.comboDay();
					jcBirth[1] = new JComboBox<String>(days);
					jp[0].add(jcBirth[1]);
					jcBirth[1].setBackground(Color.white);
					jcBirth[1].setSelectedIndex(0);
					jcBirth[1].setBounds(295, 240, 65, 30);
				}
				// ����
				if (5 == i) {	
					ButtonGroup bg = new ButtonGroup();
					
					JPanel jpGender = new JPanel();
					jpGender.setLayout(new FlowLayout(FlowLayout.LEADING));
					jpGender.setBackground(Color.white);
					jpGender.setBounds(130,280,140,31);
					for (int j=0; j < jr.length; j++) {
						jr[j] = new JRadioButton(CodeUtil.gender_value[j]);
						jr[j].addActionListener(this);
						jr[j].setBackground(Color.white);
						bg.add(jr[j]);
						jpGender.add(jr[j]);
						jp[0].add(jpGender);
					}
					jr[0].setSelected(true);
					jr[1].setSelected(false);
				}	
				// ��ȭ��ȣ
				if (6 == i) {					
					jc[1] = new JComboBox<String>(CodeUtil.tel_value);
					jp[0].add(jc[1]);
					jc[1].setBackground(Color.white);
					jc[1].setSelectedIndex(0);
					jc[1].setBounds(130, 320, 60, 30);
					
					jtFiled[0] = new JTextField(6);
					jtFiled[0].setBackground(Color.white);
					jtFiled[0].setBounds(200, 320, 60, 30);
					jtFiled[1] = new JTextField(6);
					jtFiled[1].setBackground(Color.white);
					jtFiled[1].setBounds(270, 320, 60, 30);
					
					jp[0].add(jtFiled[0]);
					jp[0].add(jtFiled[1]);
				}
				// �޴�����ȣ
				if (7 == i) {					
					jc[2] = new JComboBox<String> (CodeUtil.hp_value);
					jp[0].add(jc[2]);
					jc[2].setBackground(Color.white);
					jc[2].setSelectedIndex(0);
					jc[2].setBounds(130, 360, 60,30);
					
					jtFiled[2] = new JTextField(6);
					jtFiled[2].setBackground(Color.white);
					jtFiled[2].setBounds(200, 360, 60, 30);
					jtFiled[3] = new JTextField(6);
					jtFiled[3].setBackground(Color.white);
					jtFiled[3].setBounds(270, 360, 60, 30);
					
					jp[0].add(jtFiled[2]);
					jp[0].add(jtFiled[3]);
				}
				// �̸���
				if (8 == i) {					

					jtFiled[4] = new JTextField(20);
					jtFiled[4].setBackground(Color.white);
					jtFiled[4].setBounds(130, 400, 100, 30);
					
					JLabel jla = new JLabel("@");
					jla.setOpaque(true);
					jla.setBackground(Color.cyan);
					jla.setBounds(235, 400, 20, 30);
					
					jtFiled[5] = new JTextField(6);
					jtFiled[5].setBackground(Color.white);
					jtFiled[5].setBounds(260, 400, 100, 30);
					
					jp[0].add(jtFiled[4]);
					jp[0].add(jla);
					jp[0].add(jtFiled[5]);
				}
				// ���
				if (10 == i) {
					jc[3] = new JComboBox<String>(CodeUtil.hobby_lavel);
					jp[0].add(jc[3]);
					jc[3].setBackground(Color.white);
					jc[3].setSelectedIndex(0);
					jc[3].setBounds(130,480,80,30);
				}
				// ����
				if (13 == i) {
					jc[4] = new JComboBox<String>(CodeUtil.job_lavel);
					jp[0].add(jc[4]);
					jc[4].setBackground(Color.white);
					jc[4].setSelectedIndex(0);
					jc[4].setBounds(130,600,80,30);
				}
			}else {
				jt[i] = new JTextField(20);	
				jt[i].setBounds(130, ty, 140, 30);
				jp[0].add(jt[i]);
			}
			ty += 40;
		}
				
		// ��
		jl = new JLabel[17];		
		int ly = 80;		
		for (int i=0; i < jl.length; i++) {
			jl[i] = new JLabel();
			jl[i].setOpaque(true);
			jl[i].setText(CodeUtil.member_value[i]);
			jl[i].setHorizontalAlignment(SwingConstants.CENTER);
			jl[i].setFont(new Font("�������", Font.BOLD, 15));			
			jl[i].setBounds(20, ly, 100, 30);
			ly += 40;
			jp[0].add(jl[i]);
		}

		// ȸ������ �� 
		JLabel jlM = new JLabel(); 
		jlM.setText("ȸ������");		
		jlM.setHorizontalAlignment(SwingConstants.CENTER);
		jlM.setFont(new Font("�������", Font.BOLD, 20));
		jlM.setBounds(20,20,362,40);
		jp[0].add(jlM);
			
		// ��ư
		jb = new JButton[3];
		for (int i=0; i < jb.length ; i++ ){
			jb[i] = new JButton();
			jb[i].addActionListener(this);
			jp[0].add(jb[i]);
		}
		
		jb[0].setText("�ߺ�Ȯ��");
		jb[0].setBounds(280, 120, 110, 30);		
		jb[0].setFont(new Font("�������", Font.BOLD, 15));
		
		jb[1].setText("�����ϱ�");
		jb[1].setBounds(20, 780, 250, 30);		
		jb[1].setFont(new Font("�������", Font.BOLD, 15));
		
		jb[2].setText("�ٽ�");
		jb[2].setBounds(280, 780, 100, 30);		
		jb[2].setFont(new Font("�������", Font.BOLD, 15));
		
		
		// JTextFiled disable : ��������, �����, ������
		jt[0].setEditable(false);
		jt[14].setEditable(false);
		jt[15].setEditable(false);
		jt[16].setEditable(false);		
		
		// JPanel JFrame ���̱� 
		this.getContentPane().add(jp[0]);
		
		this.setSize(420, 880);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.setVisible(true);

		// JFrame �ݱ� 
		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				e.getWindow().setVisible(false);
				e.getWindow().dispose();						
			}
		});
	}

	
	// ȸ������ ����ϱ� 
	public void cmemInsert(   String cname, String cid, String cpw,
							String cbirth, String cgender, String ctel, 
							String chp, String cemail, String caddr, 
							String chobby, String cphoto, String cskill, 
							String cjob) {
		try {
		
			CsiMemberService cs = new CsiMemberServiceImpl();		
			CsiMemberVO cvo = null;
			cvo = new CsiMemberVO();
			
			String cnum = CsiMemberChabun.ymdNum();
			System.out.println("CsiMember.cmemInsert :: CsiMemberChabun.ymdNum() >>> : " + cnum);
			cvo.setCnum(cnum);
			cvo.setCname(cname);
			cvo.setCid(cid);
			cvo.setCpw(cpw);
			cvo.setCbirth(cbirth);
			cvo.setCgender(cgender);
			cvo.setCtel(ctel);
			cvo.setChp(chp);
			cvo.setCemail(cemail);
			cvo.setCaddr(caddr);
			cvo.setChobby(chobby);				
			cvo.setCphoto(cphoto);
			cvo.setCskill(cskill);
			cvo.setCjob(cjob);
			CsiMemberVO.printlnCsiMemberVO(cvo);
						
			boolean bool = cs.cmemInsert(cvo);
			
			if (bool) {
				System.out.println("ȸ�� ���� �Է� ���� >>> : " + bool);						
			}else {
				System.out.println("ȸ�� ���� �Է� ���� >>> : " + bool);							
			}
		}catch(Exception e) {
				System.out.println("������ >>> : " + e.getMessage());			
		}		
	}
		
	
	public void valueClear() {
		System.out.println("CsiMember.valueClear() �Լ� ����  >>> : ");
		for (int i=0; i < jt.length; i++) {			
			if ( 4 == i || 5 == i || 6 == i || 7 == i || 8 == i || 10 == i || 13 == i) {				
				jc[0].setSelectedIndex(0);
				jcBirth[0].setSelectedIndex(0);
				jcBirth[1].setSelectedIndex(0);
				jr[0].setSelected(true);
				jr[1].setSelected(false);
				jc[1].setSelectedIndex(0);
				jtFiled[0].setText("");
				jtFiled[1].setText("");
				jc[2].setSelectedIndex(0);				
				jtFiled[2].setText("");
				jtFiled[3].setText("");
				jtFiled[4].setText("");
				jtFiled[5].setText("");
				jc[3].setSelectedIndex(0);
				jc[4].setSelectedIndex(0);				
			}else {
				jt[i].setText("");	
			}
		}
	}
	
	// �׼� �̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("CsiMember.actionPerformed() �Լ� ����  >>> : ");
		Object obj = e.getSource();
		
		if (jb[0] == obj) {
			System.out.println("�ߺ�Ȯ�� ��ư Ŭ�� >>> : ");
		}
		if (jb[1] == obj) {	
			System.out.println("�����ϱ� ��ư Ŭ�� >>> : ");	
			
			// ȸ���̸� 
			String cname = jt[1].getText();
			
			// ȸ�� ���̵�
			String cid = jt[2].getText();
			
			// ȸ�� ��й�ȣ
			String cpw = jt[3].getText();
			
			// �������
			String cbirth = "";
			cbirth = String.valueOf(jc[0].getSelectedItem());
			cbirth = cbirth.concat(String.valueOf(jcBirth[0].getSelectedItem()));
			cbirth = cbirth.concat(String.valueOf(jcBirth[1].getSelectedItem()));
			
			// ����
			String cgender = "";
			if (jr[0].isSelected()) {
				System.out.println("hgender >>> : " + jr[0].getText());
				cgender = "01";
			}else {
				System.out.println("hgender >>> : " + jr[1].getText());
				cgender = "02";
			}
					
			// ��ȭ��ȣ
			String ctel = "";
			ctel = String.valueOf(jc[1].getSelectedItem());
			ctel = ctel.concat(jtFiled[0].getText());
			ctel = ctel.concat(jtFiled[1].getText());
			
			// �ڵ��� ��ȣ
			String chp = "";
			chp = String.valueOf(jc[2].getSelectedItem());
			chp = chp.concat(jtFiled[2].getText());
			chp = chp.concat(jtFiled[3].getText());
			
			// �̸��� 
			String cemail = "";
			cemail = jtFiled[4].getText();
			cemail = cemail.concat("@");
			cemail = cemail.concat(jtFiled[5].getText());
			
			// �ּ�
			String caddr = jt[9].getText();
			
			// ��� 
			String chobby = "";
			chobby = CodeUtil.setHobby(String.valueOf(jc[3].getSelectedItem()));
			
			// ����			
			String cphoto = jt[11].getText();
			
			// Ư��
			String cskill = jt[12].getText();
			
			// ����
			String cjob = "";			
			cjob = CodeUtil.setJob(String.valueOf(jc[4].getSelectedItem()));
			
			System.out.println("cname >>> : " + cname);
			System.out.println("cid >>> : " + cid);
			System.out.println("cpw >>> : " + cpw);			
			System.out.println("cbirth >>> : " + cbirth);
			System.out.println("cgender >>> : " + cgender);
			System.out.println("ctel >>> : " + ctel);			
			System.out.println("chp >>> : " + chp);
			System.out.println("cemail >>> : " + cemail);
			System.out.println("caddr >>> : " + caddr);			
			System.out.println("chobby >>> : " + chobby);
			System.out.println("cphoto >>> : " + cphoto);
			System.out.println("cskill >>> : " + cskill);			
			System.out.println("cjob >>> : " + cjob);	
			
			this.cmemInsert(	cname, cid, cpw, 
					  		cbirth, cgender, ctel, 
					  		chp, cemail, caddr, 
					  		chobby, cphoto, cskill, 
					  		cjob);
		}
		
		if (jb[2] == obj) {	
			System.out.println("�ٽù�ư ��ư Ŭ�� >>> : ");	
			this.valueClear();
		}
	}

	public static void main(String[] args) {
		
		System.out.println("CsiMember.main() �Լ� ����  >>> : ");
		new CsiMember();
	}
}
