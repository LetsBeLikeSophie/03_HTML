package com.kosmo.csi.board.scr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.kosmo.common.CodeUtil;
import com.kosmo.common.CsiBoardChabun;
import com.kosmo.csi.board.service.CsiBoardService;
import com.kosmo.csi.board.service.CsiBoardServiceImpl;
import com.kosmo.csi.board.vo.CsiBoardVO;



public class CsiBoard  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	
	private JLabel      	jl[];
	private JTextField  	jt[];
	private JTextArea   	jta;
	private JPasswordField 	jpf;
	private JButton     	jb[];	
	private JPanel      	jp[];
	
	public CsiBoard() {
		
		this.setTitle(":::게시판:::");
		
		
		this.getContentPane().setLayout(null);				
		jp = new JPanel[2];		
		jp[0] = new JPanel();
		jp[0].setBorder(new EtchedBorder());
		jp[0].setBounds(0, 0, 465, 480);
		jp[0].setBackground(Color.cyan);
		jp[0].setLayout(null);
		
		
		JLabel jlM = new JLabel(); 
		jlM.setText("게시판");		
		jlM.setHorizontalAlignment(SwingConstants.CENTER);
		jlM.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jlM.setBounds(20,20,362,40);
		jp[0].add(jlM);		
		
		
		jl = new JLabel[5];		
		int ly = 80;		
		for (int i=0; i < jl.length; i++) {
			jl[i] = new JLabel();
			jl[i].setOpaque(true);
			jl[i].setText(CodeUtil.board_label[i]);
			jl[i].setHorizontalAlignment(SwingConstants.CENTER);
			jl[i].setFont(new Font("맑은고딕", Font.BOLD, 15));			
			jl[i].setBounds(20, ly, 100, 30);
			ly += 40;
			jp[0].add(jl[i]);
		}
			
		
		jt = new JTextField[3];		
		int ty = 80;
		for (int i=0; i < jt.length; i++) {
			jt[i] = new JTextField(200);	
			jt[i].setBounds(130, ty, 300, 30);
			jp[0].add(jt[i]);
			ty += 40;
		}
		
		
		jpf = new JPasswordField();
		jpf.setBounds(130, 200, 100, 30);
		jpf.setEchoChar('*');
		jp[0].add(jpf);
		
		
		jp[1] = new JPanel();
		jp[1].setLayout(new BorderLayout(5, 5));
		jp[1].setBounds(130, 240, 300, 140);
		jp[1].setBackground(Color.red);
		jp[0].add(jp[1]);
		
		
		jta = new JTextArea(10, 10);
		jp[1].add(new JScrollPane(jta));
	
		
		jb = new JButton[2];
		for (int i=0; i < jb.length ; i++ ){
			jb[i] = new JButton();
			jb[i].addActionListener(this);
			jp[0].add(jb[i]);
		}
		
		jb[0].setText("작성하기");
		jb[0].setBounds(20, 420, 250, 30);		
		jb[0].setFont(new Font("맑은고딕", Font.BOLD, 15));
		
		jb[1].setText("다시");
		jb[1].setBounds(280, 420, 150, 30);		
		jb[1].setFont(new Font("맑은고딕", Font.BOLD, 15));
		
		
		jt[0].setEditable(false);
				
		
		this.getContentPane().add(jp[0]);		
		
		this.setSize(465, 520);
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

	
	public void hboardInsert(String bsubject, String bwriter, String bpw, String bcontents) {
		System.out.println("CsiBoard.hboardInsert() 함수 시작  >>> : ");
		
		CsiBoardService hs = new CsiBoardServiceImpl();
		CsiBoardVO cvo = null;
		cvo = new CsiBoardVO();
		cvo.setBnum(CsiBoardChabun.gubunNum());
		cvo.setBsubject(bsubject);
		cvo.setBwriter(bwriter);
		cvo.setBpw(bpw);
		cvo.setBcontents(bcontents);
		
		int nCnt = hs.cboardInsert(cvo);
		
		if (nCnt == 1) {
			System.out.println("게시글 등록 성공 >>> : " + nCnt);
			JOptionPane.showMessageDialog(this, "게시글 등록 성공 >>> :  ");
			new CsiBoardrAll();
			this.setVisible(false);
			this.dispose();
		}else {
			System.out.println("글 등록 실패 >>> : " + nCnt);
		}
	}
	
	
	public void valueClear() {
		System.out.println("CsiBoard.valueClear() 함수 시작  >>> : ");
		for (int i=0; i < jt.length; i++) {			
			jt[i].setText("");
		}
		jpf.setText("");
		jta.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("CsiBoard.actionPerformed() 함수 시작  >>> : ");
		
		Object obj = e.getSource();
		Object jbCaption = e.getActionCommand();
		
		if (jb[0] == obj) {
			System.out.println("작성하기 버튼 클릭 >>> : " + jbCaption);
			
			String bsubject = "";
			String bwriter = "";			
			String bpw = "";
			String bcontents = "";
		
			bsubject = jt[1].getText();
			bwriter = jt[2].getText();			

			char bpwChar[] = jpf.getPassword();
			bpw = new String(bpwChar);
			bcontents = jta.getText();
		
			System.out.println("bsubject >>> : " + bsubject);
			System.out.println("bwriter >>> : " + bwriter);
			System.out.println("bpw >>> : " + bpw);
			System.out.println("bcontents >>> : " + bcontents);
						
			this.hboardInsert(bsubject, bwriter, bpw, bcontents);
		}
		
		if (jb[1] == obj) {	
			System.out.println("다시버튼 버튼 클릭 >>> : ");	
			this.valueClear();
		}				
	}
	
	public static void main(String[] args) {
		
		new CsiBoard();
	}
}
