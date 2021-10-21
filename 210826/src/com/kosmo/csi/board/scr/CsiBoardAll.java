package com.kosmo.csi.board.scr;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.kosmo.common.CodeUtil;
import com.kosmo.csi.board.service.CsiBoardService;
import com.kosmo.csi.board.service.CsiBoardServiceImpl;
import com.kosmo.csi.board.vo.CsiBoardVO;


public class CsiBoardAll extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -7773980409866362226L;
	
	DefaultTableModel dtm;
	JTable             jt;
	Object[][] fieldValue;
	String[]   columnName;
	
	JPanel[]    jpR;
	JLabel      jlR;
	JComboBox<String>  jcR;
	JTextField  jtR;
	JButton     jbR;
	JScrollPane jsPain;
	JButton     jtBtn[];
	JCheckBox   jcb[];
	
	String comboStr;
	String searchStr;
	
	
	@SuppressWarnings("unchecked")
	public CsiBoardAll() {
		this.setTitle("�Խñ� �˻��ϱ�");
		this.getContentPane().setLayout(new BorderLayout(10, 10));

		jpR = new JPanel[3];
		jlR = new JLabel("��ȸ����");
		jlR.setHorizontalAlignment(SwingConstants.CENTER);

		jcR = new JComboBox<String>(CodeUtil.board_combo_cpation);
		jcR.setSelectedIndex(0);
		jcR.addActionListener(this);

		jtR = new JTextField();
		jtR.setVisible(false);
		jbR = new JButton("��ȸ");
		jbR.addActionListener(this);

		for (int i=0; i < jpR.length; i++ ){
			jpR[i] = new JPanel();
			jpR[i].setLayout(new BorderLayout());
		}
		

		
		columnName = CodeUtil.board_selectall_label;			
		
		dtm = new DefaultTableModel(fieldValue, columnName);
		jt = new JTable(dtm);
		jt.setEnabled(true);
		jsPain = new JScrollPane(jt);		
		
		this.hboardSelectAll();		

		
		
		jpR[0].add(jlR);
		jpR[0].add(jcR);		
		jpR[0].add(jtR);
		jpR[0].add(jbR);
		jpR[0].setLayout(new GridLayout(1, 4, 5, 5));
		jpR[1].add(jsPain);
		
		jpR[2] = new JPanel();
		jpR[2].setLayout(new FlowLayout(FlowLayout.CENTER));
		
		jtBtn = new JButton[2];		
		for (int i=0; i < jtBtn.length; i++) {
			jtBtn[i] = new JButton(CodeUtil.board_jbtn_cpation[i]);
			jtBtn[i].addActionListener(this);
			jpR[2].add(jtBtn[i]);
		}

		this.getContentPane().add(jpR[0], BorderLayout.NORTH);
		this.getContentPane().add(jpR[1], BorderLayout.CENTER);
		this.getContentPane().add(jpR[2], BorderLayout.SOUTH);

		this.setLocation(100, 100);
		this.setSize(800,400);
		this.setResizable(false);
		this.setVisible(true);
		
		
		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
		});
	}
	
	public void jtableRender() {

		
		
		
		
		jt.getColumn("�۳���").setPreferredWidth(100);
		jt.getColumn("Y/N").setPreferredWidth(10);
		
		
		
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = jt.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}				
		
		jsPain.setPreferredSize(new Dimension(760, 350));

		
		
		jt.getColumnModel().getColumn(8).setCellRenderer(new TableCell());
		jt.getColumnModel().getColumn(8).setCellEditor(new TableCell());
	}

	

	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer,  ActionListener{		
		private static final long serialVersionUID = 1L;
		
		JButton jb;
		
		
		public TableCell(){			
			jb = new JButton("����/����");			
	
	
	
			jb.addActionListener(this);			
		}
		
		@Override
		public Object getCellEditorValue() {
			
			return null;
		}
	
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, 
				                                       boolean isSelected, boolean hasFocus,
				                                       int row, int column) {
			
			return jb;
		}
	
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, 
				                                     boolean isSelected, int row, int column) {
			
			return jb;
		}	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("TableCell actionPerformed() �Լ� ���� >>> : ");
			
			if (jb == e.getSource()) {
				String bnum = String.valueOf(jt.getValueAt(jt.getSelectedRow(), 0));
				System.out.println("bnum >>> : " + bnum);
				CsiBoardUpdate hbu = new CsiBoardUpdate();
				hbu.hboardSelect(bnum);
			}
		}
	} 

	
	public void hboardSelectAll() {
		System.out.println("CsiBoardrAll hboardSelectAll() �Լ� ���� >>> : ");
		
		CsiBoardService ss = new CsiBoardServiceImpl();	
		ArrayList<CsiBoardVO> aList = ss.cboardSelectAll();	
		int columnCnt = columnName.length;
		int rowCnt = aList.size();	
		System.out.println("�Խ��� ��ü ��ȸ :: rowCnt >>> : " + rowCnt);		

		this.jtablePrint(aList,rowCnt, columnCnt);				
		dtm = new DefaultTableModel(fieldValue, columnName);
		jt.setModel(dtm);		
		this.jtableRender();
		
		return;
	}
	
	
	public void hboardSelectSubject(String searchStr) {
		System.out.println("CsiBoardrAll hboardSelectSubject() �Լ� ���� >>> : ");
		
		CsiBoardService ss = new CsiBoardServiceImpl();	
		CsiBoardVO cvo = null;
		cvo = new CsiBoardVO();
		cvo.setBsubject(searchStr);
		ArrayList<CsiBoardVO> aList =  ss.cboardSelectSubject(cvo);
	
		int columnCnt = columnName.length;
		int rowCnt = aList.size();
		System.out.println("�Խ��� ������ �˻� :: rowCnt >>> : " + rowCnt);		
		
		this.jtablePrint(aList, rowCnt, columnCnt);
		dtm = new DefaultTableModel(fieldValue, columnName);
		jt.setModel(dtm);		
		this.jtableRender();
		
		return;
	}
	
	
	public void hboardSelectWriter(String searchStr) {
		System.out.println("CsiBoardrAll hboardSelectWriter() �Լ� ���� >>> : ");
		
		CsiBoardService ss = new CsiBoardServiceImpl();	
		CsiBoardVO cvo = null;
		cvo = new CsiBoardVO();
		cvo.setBwriter(searchStr);
		ArrayList<CsiBoardVO> aList =  ss.hboardSelectWriter(cvo);
	
		int columnCnt = columnName.length;
		int rowCnt = aList.size();
		System.out.println("�Խ��� �ۼ��� �˻� :: rowCnt >>> : " + rowCnt);
		
		this.jtablePrint(aList, rowCnt, columnCnt);
		dtm = new DefaultTableModel(fieldValue, columnName);
		jt.setModel(dtm);		
		this.jtableRender();
		
		return;
	}
	
	
	public void jtablePrint(ArrayList<CsiBoardVO> aList, int rowCnt, int columnCnt) {
		System.out.println("CsiBoardrAll jtablePrint() �Լ� ���� >>> : ");
		
		fieldValue = new Object[rowCnt][columnCnt];

		for (int i=0; i < rowCnt; i++ ){
			
			CsiBoardVO _cvo = aList.get(i);
			fieldValue[i][0] = _cvo.getBnum();
			fieldValue[i][1] = _cvo.getBsubject();
			fieldValue[i][2] = _cvo.getBwriter();
			fieldValue[i][3] = _cvo.getBpw();
			fieldValue[i][4] = _cvo.getBcontents();
			fieldValue[i][5] = _cvo.getDeleteyn();
			fieldValue[i][6] = _cvo.getInsertdate();
			fieldValue[i][7] = _cvo.getUpdatedate();	
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (jcR == e.getSource()) {
			comboStr = (String)jcR.getSelectedItem();
			if ("��ü".equals(comboStr)){
				jtR.setVisible(false);				
			}
			if ("������".equals(comboStr)){
				jtR.setVisible(true);
				jtR.setText("");
			}
			if ("�ۼ���".equals(comboStr)){
				jtR.setVisible(true);
				jtR.setText("");
			}
		}
		
		
		if (jbR == e.getSource()) {
			String searchStr = jtR.getText();

			if ("��ü".equals(comboStr)){
				System.out.println("searchStr >>> : " + searchStr);
				
				this.hboardSelectAll();	
			}
			if ("������".equals(comboStr)){				
				
				if (searchStr !=null && searchStr.length() > 0) {				
					System.out.println("������ :: searchStr >>> : " + searchStr);
					
					this.hboardSelectSubject(searchStr);	
				}else {
					JOptionPane.showMessageDialog(this, "�˻� ���� �������� �Է��ϼ��� >>> :  ");
				}
			}
			if ("�ۼ���".equals(comboStr)){
				
				if (searchStr !=null && searchStr.length() > 0) {				
					System.out.println("�ۼ��� :: searchStr >>> : " + searchStr);
					
					this.hboardSelectWriter(searchStr);	
				}else {
					JOptionPane.showMessageDialog(this, "�˻� ���� �ۼ��ڸ� �Է��ϼ��� >>> :  ");
				}
			}
		}
		
		
		if (jtBtn[0] == e.getSource()) {
			System.out.println("�� �ۼ��ϱ�  >>> : ");
			new CsiBoard();
		}	
		if (jtBtn[1] == e.getSource()) {
			System.out.println("�� ��Ϻ��� >>> : ");
			
			jcR.setSelectedIndex(0);
			this.hboardSelectAll();
		}
	}
	

	public static void main(String[] args) {
		
		new CsiBoardAll();
	}
}