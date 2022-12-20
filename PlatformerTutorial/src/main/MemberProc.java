package main;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class MemberProc extends JFrame implements ActionListener {

	JPanel p, idCkP; // idCkP 패널
	JTextField tfName, tfId, tfSnid, tfNum;
	JPasswordField pfPwd; // 비밀번호
	JPasswordField pfSnid; // 주민번호
	JButton btnInsert, btnCancel, btnUpdate, btnDelete, idCkBtn , idCkBtn2; // 가입, 취소, 수정 , 탈퇴 , id체크 버튼

	GridBagLayout gb;
	GridBagConstraints gbc;
	Member_List mList;
	MemberDAO dao = new MemberDAO();

	public MemberProc() { // 가입용 생성자

		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);

	}// 생성자

	public MemberProc(Member_List mList) { // 가입용 생성자

		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;

	}// 생성자

	public MemberProc(int num, Member_List mList) { // 수정/삭제용 생성자
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		idCkBtn.setEnabled(false);
		idCkBtn.setVisible(false);

		this.mList = mList;

//       System.out.println("id="+id);

		MemberDAO dao = new MemberDAO();
		MemberDTO vMem = dao.getMemberDTO(num);
		viewData(vMem);

	}// id를 가지고 생성

	// MemberDTO 의 회원 정보를 가지고 화면에 셋팅해주는 메소드
	private void viewData(MemberDTO vMem) {

//		String num = vMem.getNum();
		String name = vMem.getName();
		String id = vMem.getId();
		String pwd = vMem.getPwd();
		String snid = vMem.getSnid();

		// 화면에 세팅
//		tfNum.setText(num);
		tfName.setText(name);
		tfId.setText(id);
		tfId.setEditable(false); // 편집 안되게
		pfPwd.setText(""); // 비밀번호는 안보여준다.
		pfSnid.setText(""); // 주민번호는 안보여준다.

	}// viewData

	private void createUI() {
		this.setTitle("회원정보");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		// 번호
//		JLabel bNum = new JLabel("번호 :");
//		tfNum = new JTextField(20);
//		gbAdd(bNum, 0, 0, 1, 1);
//		gbAdd(tfNum, 1, 0, 1, 1);

		// 이름
		JLabel bName = new JLabel("이름 :");
		tfName = new JTextField(20);
		gbAdd(bName, 0, 1, 1, 1);
		gbAdd(tfName, 1, 1, 3, 1);

		// 아이디
		JLabel bId = new JLabel("아이디 : ");
		tfId = new JTextField(20);
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1,0, 1, 1);

		// 비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		pfPwd = new JPasswordField(20);
		pfPwd.setEchoChar('*');
		// 비밀번호 표시 부분
		gbAdd(bPwd, 0, 3, 1, 1);
		gbAdd(pfPwd, 1, 3, 3, 1);

		// 주민번호
		JLabel bSnid = new JLabel("주민번호 : ");
		JPanel pSnid = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JPanel pSnid = new JPanel(new FlowLayout());
		tfSnid = new JTextField(6); 
		pfSnid = new JPasswordField(7);
		pfSnid.setEchoChar('*');
		pSnid.add(tfSnid);
		pSnid.add(new JLabel(" - "));
		pSnid.add(pfSnid);
		tfSnid.setPreferredSize(new Dimension(200,30));
		pfSnid.setPreferredSize(new Dimension(200,30));
		// 비밀번호 표시 부분
		gbAdd(bSnid, 0, 4, 1, 1);
	    gbAdd(pSnid, 1, 4, 3, 1);
//		gbAdd(tfSnid, 1, 4, 3, 1);
//		gbAdd(pfSnid, 2, 4, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
		JPanel pButton2 = new JPanel();
		JPanel pButton3 = new JPanel();
//		pButton2.setPreferredSize(new Dimension(150, 30)); // 패널 사이즈 조절
		btnInsert = new JButton("가입");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("탈퇴");
		btnCancel = new JButton("취소");
		idCkBtn = new JButton("IDCheck");
		
//		idCkBtn.setPreferredSize(new Dimension(140, 30));//번튼 크기 조절
		
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		pButton2.add(idCkBtn);
		gbAdd(pButton, 0, 10, 4, 1);
//		gbAdd(pButton2, 2, 0, 1, 1);
		gbAdd(idCkBtn, 2, 0, 1, 1);

		// 버튼에 감지기를 붙이자
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);
		idCkBtn.addActionListener(this);

		setSize(400, 250);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // dispose(); //현재창만 닫는다.

	}// createUI

	// 그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(1, 1, 1, 1);
		add(c, gbc);
	}// gbAdd

	public static void main(String[] args) {

		new MemberProc();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String btnLabel = ae.getActionCommand();// 이벤트주체 대한 Label 가져오기
		if (ae.getSource() == btnInsert) {
			insertMember();
			System.out.println("insertMember() 호출 종료");
		} else if (ae.getSource() == btnCancel) {
			this.dispose(); // 창닫기 (현재창만 닫힘)
			// system.exit(0)=> 내가 띄운 모든 창이 다 닫힘
		} else if (ae.getSource() == btnUpdate) {
			UpdateMember();
		} else if (ae.getSource() == btnDelete) {
			// int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
			int x = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION) {
				deleteMember();
			} else {
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
			}
		} else if (ae.getSource() == idCkBtn) {
			if (btnLabel.equals("IDCheck")) {
				if (tfId.getText().trim().equals("")) {
					messageBox(this, "ID를 입력해주세요.");
					tfId.requestFocus();// 포커스이동
				} else {
					if (dao.getIdByCheck(tfId.getText())) { // 중복 아님 (사용 가능)
						messageBox(this, tfId.getText() + "는 사용가능합니다.");
					} else { // 중복이다.
						messageBox(this, tfId.getText() + "는 중복입니다.");

						tfId.setText("");// text박스지우기
						tfId.requestFocus();// 커서놓기

					}
				}
			}

		}
		 

		// jTable내용 갱신 메소드 호출
		//mList.jTableRefresh2();

	}// actionPerformed

	private void deleteMember() {
		String id = tfId.getText();
		String pwd = pfPwd.getText();
		if (pwd.length() == 0) { // 길이가 0이면

			JOptionPane.showMessageDialog(this, "비밀번호를 꼭 입력하세요!");
			return; // 메소드 끝
		}
		// System.out.println(mList);
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.deleteMember(id, pwd);

		if (ok) {
			JOptionPane.showMessageDialog(this, "삭제완료");
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "삭제실패");

		}

	}// deleteMember

	private void UpdateMember() {

		// 1. 화면의 정보를 얻는다.
		MemberDTO dto = getViewData();
		// 2. 그정보로 DB를 수정
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.updateMember(dto);
		System.out.println("ok : " + ok);

		if (ok) {
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");
		}
	}

	private void insertMember() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.insertMember(dto);

		if (ok) {

			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
			dispose();

		} else {

			JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
		}

	}// insertMember

	public MemberDTO getViewData() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		MemberDTO dto = new MemberDTO();

//		String num = tfNum.getText();
		String name = tfName.getText();
		String id = tfId.getText();
		String pwd = pfPwd.getText();
		String snid1 = tfSnid.getText();
		String snid2 = pfSnid.getText();
		String snid = snid1+"-"+snid2;

		// dto에 담는다.
//		dto.setNum(num);
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setSnid(snid);

		return dto;
	}

	/**
	 * 메시지박스 띄워주는 메소드 작성
	 */
	public static void messageBox(Object obj, String message) {
		JOptionPane.showMessageDialog((Component) obj, message);
	}

}// end