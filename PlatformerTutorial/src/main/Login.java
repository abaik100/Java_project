package main;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener {
	


	JPanel p, idCkP; // idCkP 패널
	JTextField tfName, tfId, tfSnid, tfNum;
	JPasswordField pfPwd; // 비밀번호
	JPasswordField pfSnid; // 주민번호
	JButton btnInsert, btnCancel, btnUpdate, btnDelete, idCkBtn, idCkBtn2, btnMember, btnLogin, btnRank,btnRanking; // 가입, 취소, 수정 , 탈퇴 , id체크 버튼

	GridBagLayout gb;
	GridBagConstraints gbc;
	Member_List mList;
	MemberDAO dao = new MemberDAO();
//	private Game game;
	
	public Login() { // 가입용 생성자

		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);

	}// 생성자

	public Login(Member_List mList) { // 가입용 생성자

		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;

	}// 생성자

	public Login(int num, Member_List mList) { // 수정/삭제용 생성자
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
		this.setTitle("로그인");
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
//		JLabel bName = new JLabel("이름 :");
//		tfName = new JTextField(20);
//		gbAdd(bName, 0, 1, 1, 1);
//		gbAdd(tfName, 1, 1, 3, 1);

		// 아이디
		JLabel bId = new JLabel("아이디 : ");
		tfId = new JTextField(20);
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1, 0, 1, 1);

		// 비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		pfPwd = new JPasswordField(20);
		pfPwd.setEchoChar('*');
		// 비밀번호 표시 부분
		gbAdd(bPwd, 0, 1, 1, 1);
		gbAdd(pfPwd, 1, 1, 3, 1);

		// 주민번호
//		JLabel bSnid = new JLabel("주민번호 : ");
//		JPanel pSnid = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JPanel pSnid = new JPanel(new FlowLayout());
//		tfSnid = new JTextField(6); 
//		pfSnid = new JPasswordField(7);
//		pfSnid.setEchoChar('*');
//		pSnid.add(tfSnid);
//		pSnid.add(new JLabel(" - "));
//		pSnid.add(pfSnid);
//		tfSnid.setPreferredSize(new Dimension(200,30));
//		pfSnid.setPreferredSize(new Dimension(200,30));
		// 비밀번호 표시 부분
//		gbAdd(bSnid, 0, 4, 1, 1);
//	    gbAdd(pSnid, 1, 4, 3, 1);
//		gbAdd(tfSnid, 1, 4, 3, 1);
//		gbAdd(pfSnid, 2, 4, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
		JPanel pButton2 = new JPanel();
		JPanel pButton3 = new JPanel();
//		pButton2.setPreferredSize(new Dimension(150, 30)); // 패널 사이즈 조절
		btnInsert = new JButton("로그인");
		btnLogin = new JButton("로그인");
		btnUpdate = new JButton("회원");
		btnDelete = new JButton("탈퇴");
		btnMember = new JButton("회원가입");
		idCkBtn = new JButton("IDCheck");
		btnRank = new JButton("걸린시간");
		btnRanking = new JButton("Ranking");

//		idCkBtn.setPreferredSize(new Dimension(140, 30));//번튼 크기 조절

//		pButton.add(btnInsert);
		pButton.add(btnLogin);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnMember);
		pButton.add(btnRank);
		pButton.add(btnRanking);

		pButton2.add(idCkBtn);
		gbAdd(pButton, 0, 3, 4, 1);
//		gbAdd(pButton2, 2, 0, 1, 1);
//		gbAdd(idCkBtn, 2, 0, 1, 1);

		// 버튼에 감지기를 붙이자
//		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnMember.addActionListener(this);
		btnLogin.addActionListener(this);
		btnDelete.addActionListener(this);
		idCkBtn.addActionListener(this);
		btnRank.addActionListener(this);
		btnRanking.addActionListener(this);
		
		setSize(380, 150);
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
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String btnLabel = ae.getActionCommand();// 이벤트주체 대한 Label 가져오기
		if (ae.getSource() == btnMember) {
			new MemberProc();

		}
		if (ae.getSource() == btnLogin) {
			if (dao.loginMemberCheck(tfId.getText(),pfPwd.getText())) {
				new Game();
//				System.out.println(tfId.getText());
				

			}
			else {
				JOptionPane.showMessageDialog(this, "아이디 비밀번호를 확인해 주세요");
			}
			}
		
		
		if(ae.getSource() == btnRank) {
			System.out.println(Game.time());
			dao.insertMember2(getViewData2());
			

//			boolean ok = false;
//			Connection con = null; // 연결
//			PreparedStatement ps = null; // 명령
//			System.out.println(tfId.getText());
//			System.out.println(Game.time());
		}
		if(ae.getSource() == btnRanking) {
			CRUDGUI gui = new CRUDGUI();
		}
	}


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

	public MemberDTO getViewData() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		MemberDTO dto = new MemberDTO();

//		String num = tfNum.getText();
		String name = tfName.getText();
		String id = tfId.getText();
		String pwd = pfPwd.getText();
		String snid1 = tfSnid.getText();
		String snid2 = pfSnid.getText();
		String snid = snid1 + "-" + snid2;
		int time = (int)Game.time();

		// dto에 담는다.
//		dto.setNum(num);
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setSnid(snid);

		return dto;
	}
	public DTO getViewData2() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		DTO dto = new DTO();

//		String num = tfNum.getText();

		String id = tfId.getText();

		int time = (int)Game.time();

		// dto에 담는다.
//		dto.setNum(num);

		dto.setid(id);
		dto.settime(time);


		return dto;
	}

	/**
	 * 메시지박스 띄워주는 메소드 작성
	 */
	public static void messageBox(Object obj, String message) {
		JOptionPane.showMessageDialog((Component) obj, message);
	}

}// end