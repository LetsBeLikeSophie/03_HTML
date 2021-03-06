package com.kosmo.csi.src;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CsiScr extends JFrame implements ActionListener{
	private static final long serialVersionUID = 6514790051744812839L;
	
	private CardLayout 	card;
	private JPanel 		contain;
	JPanel              jpM;
	private JPanel    	jp[];
	private JButton   	jb[];
	
	private Color[] jpbk_color = {Color.YELLOW, Color.CYAN, Color.PINK};
	private String[] jp_label = {"메인화면", "회원가입", "게시판"};
	private String[] jb_caption = {"홈", "회원가입", "게시판"};
	

	public CsiScr (){
		this.setTitle("KOSMO MAIN");
		
		contain = new JPanel();
		contain.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contain);
		contain.setLayout(null);
		card = new CardLayout(10, 10);

		jpM = new JPanel();		
		jpM.setLayout(card);

		jp = new JPanel[3];
		for (int i=0; i < jp.length; i++) {
			jp[i] = new JPanel();
			jp[i].setLayout(null);
			jp[i].add(new JLabel(jp_label[i]));
			jp[i].setBackground(jpbk_color[i]);	
			jpM.add(jp[i]);
		}
		
		jpM.add("메인화면", jp[0]);
		jpM.add("회원가입", jp[1]);	
		jpM.add("게시판", jp[2]);
		card.show(jpM, "메인화면");
		
		jpM.setBounds(20, 10, 1190, 920);
		contain.add(jpM);
		
		// 회원가입 
		JPanel jpMember = new JPanel();
		jpMember.setLayout(null);
		jpMember.setBounds(380, 10, 430, 880);
		jpMember.setBackground(Color.YELLOW);
		jp[1].add(jpMember);
		
		// 게시판
		JPanel jpBoard = new JPanel();
		jpBoard.setLayout(null);
		jpBoard.setBounds(360, 10, 465, 520);
		jpBoard.setBackground(Color.YELLOW);
		jp[2].add(jpBoard);
		
		
		// 로그인 판넬		
		JPanel jp00 = new JPanel();
		jp00.setBounds(1220, 20, 320, 290);
		jp00.setBackground(Color.YELLOW);
		contain.add(jp00);	
		
		// 버튼
		jb = new JButton[3];
		for (int i=0; i < jb.length; i++) {
			jb[i] = new JButton(jb_caption[i]);
			jb[i].addActionListener(this);	
			contain.add(jb[i]);
		}
		jb[0].setBounds(1220, 340, 100, 30);
		jb[1].setBounds(1330, 340, 100, 30);
		jb[2].setBounds(1440, 340, 100, 30);	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 10, 1600, 980);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		String jbCaption = e.getActionCommand();
		
		if (jb[0] == obj){
			System.out.println("jbCaption >>> : " + jbCaption);
			card.show(jpM, "메인화면");
		}
		if (jb[1] == obj){
			System.out.println("jbCaption >>> : " + jbCaption);
			card.show(jpM, "회원가입");
		}
		if (jb[2] == obj){
			System.out.println("jbCaption >>> : " + jbCaption);
			card.show(jpM, "게시판");
		}			
	}
	
	public static void main(String[] args) {

		new CsiScr();
	}
}
