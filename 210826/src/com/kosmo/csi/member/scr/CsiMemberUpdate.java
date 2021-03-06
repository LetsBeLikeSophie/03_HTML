package com.kosmo.csi.member.scr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.kosmo.common.CodeUtil;
import com.kosmo.csi.member.service.CsiMemberService;
import com.kosmo.csi.member.service.CsiMemberServiceImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;


public class CsiMemberUpdate extends JFrame implements ActionListener {

	private static final long serialVersionUID = 9072198881429763467L;

	private JLabel      jl[];
	private JTextField  jt[];
	private JTextField  jtFiled[];
	private JButton     jb[];
	private JPanel      jp[];
	private JComboBox<String> jc[];
	private JComboBox<String> jcBirth[];
	private JRadioButton        jr[];

	@SuppressWarnings("unchecked")
	public CsiMemberUpdate() {

		this.setTitle(":::????/????:::");

		this.getContentPane().setLayout(null);				
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
							
			if (8 == i || 10 == i || 13 == i) {
				System.out.println(">>>>>>>> " + i);				

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

				if (10 == i) {
					jc[3] = new JComboBox<String>(CodeUtil.hobby_lavel);
					jp[0].add(jc[3]);
					jc[3].setBackground(Color.white);
					jc[3].setSelectedIndex(0);
					jc[3].setBounds(130,480,80,30);
				}
				// ????
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
				

		jl = new JLabel[17];		
		int ly = 80;		
		for (int i=0; i < jl.length; i++) {
			jl[i] = new JLabel();
			jl[i].setOpaque(true);
			jl[i].setText(CodeUtil.member_value[i]);
			jl[i].setHorizontalAlignment(SwingConstants.CENTER);
			jl[i].setFont(new Font("????????", Font.BOLD, 15));			
			jl[i].setBounds(20, ly, 100, 30);
			ly += 40;
			jp[0].add(jl[i]);
		}


		JLabel jlM = new JLabel(); 
		jlM.setText("????/????");		
		jlM.setHorizontalAlignment(SwingConstants.CENTER);
		jlM.setFont(new Font("????????", Font.BOLD, 20));
		jlM.setBounds(20,20,362,40);
		jp[0].add(jlM);
			

		jb = new JButton[3];
		for (int i=0; i < jb.length ; i++ ){
			jb[i] = new JButton();
			jb[i].addActionListener(this);
			jp[0].add(jb[i]);
		}
		
		jb[0].setText("????");
		jb[0].setBounds(100, 780, 100, 30);		
		jb[0].setFont(new Font("????????", Font.BOLD, 15));
		
		jb[1].setText("????");
		jb[1].setBounds(220, 780, 100, 30);		
		jb[1].setFont(new Font("????????", Font.BOLD, 15));
		
		

		jt[0].setEditable(false);
		jt[1].setEditable(false);
		jt[2].setEditable(false);
		jt[3].setEditable(false);
		jt[4].setEditable(false);
		jt[5].setEditable(false);
		jt[6].setEditable(false);
		jt[7].setEditable(false);		
		jt[11].setEditable(false);
		jt[12].setEditable(false);		
		jt[14].setEditable(false);
		jt[15].setEditable(false);
		jt[16].setEditable(false);		
		

		this.getContentPane().add(jp[0]);
		
		this.setSize(420, 880);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.setVisible(true);


		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				e.getWindow().setVisible(false);
				e.getWindow().dispose();						
			}
		});
	}

	
	public void cmemSelect(String cnum) {
		System.out.println("CsiMemberUpdate cmemSelect() ?Լ? ???? >>> : " + cnum);
		
		CsiMemberService hs = new CsiMemberServiceImpl();
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		cvo.setCnum(cnum);
		
		ArrayList<CsiMemberVO> aList = hs.cmemSelect(cvo);
		System.out.println("" + aList);
		if (aList !=null && aList.size() > 0) {			
	
			CsiMemberVO _cvo = aList.get(0);			
			
			
			jt[0].setText(_cvo.getCnum());	
			jt[1].setText(_cvo.getCname());		
			jt[2].setText(_cvo.getCid());	
			jt[3].setText(_cvo.getCpw());		
			jt[4].setText(_cvo.getCbirth());	
			String cgender = _cvo.getCgender();
			if ("01".equals(cgender)) {
				cgender = "????";
			}else {
				cgender = "????";
			}
			
			jt[5].setText(cgender);	
			jt[6].setText(_cvo.getCtel());
			jt[7].setText(_cvo.getChp());
	
			String cemail = _cvo.getCemail();
			String email[] = cemail.split("@");			
			jtFiled[4].setText(email[0]);	
			jtFiled[5].setText(email[1]);			
		
			jt[9].setText(_cvo.getCaddr());			
			jc[3].setSelectedIndex(CodeUtil.getComboIndex(_cvo.getChobby()));							
			jt[11].setText(_cvo.getCphoto());			
			jt[12].setText(_cvo.getCskill());			
			jc[4].setSelectedIndex(CodeUtil.getComboIndex(_cvo.getCjob()));
			jt[14].setText(_cvo.getDeleteyn());
			jt[15].setText(_cvo.getInsertdate());
			jt[16].setText(_cvo.getUpdatedate());		
		}
	}
	
	
	public void cmemUpdate(String cnum, String cemail, String caddr, String chobby, String cjob) {
		System.out.println("CsiMemberUpdate cmemUpdate() ?Լ? ???? >>> : " + cnum);
		
		CsiMemberService ss = new CsiMemberServiceImpl();
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		cvo.setCnum(cnum);
		cvo.setCemail(cemail);
		cvo.setCaddr(caddr);
		cvo.setChobby(chobby);
		cvo.setCjob(cjob);			
		
		boolean bool = ss.cmemUpdate(cvo);
		
		if (bool) {
			System.out.println("ȸ?????? ???? ????  >>> : " + bool);
			JOptionPane.showMessageDialog(this, "ȸ?????? ???? ???? >>> :  ");
			this.setVisible(false);
			this.dispose();
		}else {
			System.out.println("ȸ??????  ???? ????  >>> : " + bool);
		}
	}

	public void cmemDelete(String cnum) {
		System.out.println("CsiMemberUpdate cmemDelete() ?Լ? ???? >>> : " + cnum);
		
		CsiMemberService ss = new CsiMemberServiceImpl();
		CsiMemberVO cvo = null;
		cvo = new CsiMemberVO();
		cvo.setCnum(cnum);	
		
		boolean bool = ss.cmemDelete(cvo);
		
		if (bool) {
			System.out.println("ȸ?????? ???? ????  >>> : " + bool);
			JOptionPane.showMessageDialog(this, "ȸ?????? ???? ???? >>> :  ");	
			this.setVisible(false);
			this.dispose();
		}else {
			System.out.println("ȸ?????? ???? ????  >>> : " + bool);
		}
	}
	
	public void valueClear() {
		System.out.println("CsiMember.valueClear() ?Լ? ????  >>> : ");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("CsiMemberUpdate.actionPerformed() ?Լ? ????  >>> : ");
		String jbCaption = e.getActionCommand();
		
		if (jb[0] == e.getSource()) {
			System.out.println("???? ??ư Ŭ?? >>> : " + jbCaption);

			String cnum = jt[0].getText();			
	
			String cemail = "";
			cemail = jtFiled[4].getText();
			cemail = cemail.concat("@");
			cemail = cemail.concat(jtFiled[5].getText());

			String caddr = jt[9].getText();

			String chobby = "";
			chobby = CodeUtil.setHobby(String.valueOf(jc[3].getSelectedItem()));

			String cjob = "";			
			cjob = CodeUtil.setJob(String.valueOf(jc[4].getSelectedItem()));
			
			System.out.println("cnum >>> : " + cnum);		
			System.out.println("hemail >>> : " + cemail);
			System.out.println("haddr >>> : " + caddr);			
			System.out.println("hhobby >>> : " + chobby);
			System.out.println("hjob >>> : " + cjob);
			
			this.cmemUpdate(cnum, cemail, caddr, chobby, cjob);
		}
		if (jb[1] == e.getSource()) {	
			System.out.println("???? ??ư Ŭ?? >>> : " + jbCaption);	
			
			String cnum = jt[0].getText();				
			System.out.println("cnum >>> : " + cnum);		
			
			this.cmemDelete(cnum);
		}
	}

	public static void main(String[] args) {

		System.out.println("CsiMemberUpdate.main() ?Լ? ????  >>> : ");
		new CsiMemberUpdate();
	}
}
