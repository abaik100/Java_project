package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class InsertTest {
	

	public static void main(String[] args) throws InterruptedException {
		Login tfId2 = new Login();
//		insertForPrepared();
//		Scanner sc = new Scanner(System.in);	
		System.out.println("아이디 입력 : ");
		TimeUnit.SECONDS.sleep(10);
		String id = tfId2.tfId.getText();
		System.out.println("시간 입력 : ");
		int time = (int) Game.time();
//		int time = (int) Login.time2;
		System.out.println(time);
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		//2.
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "system";
//		String password = "k404";
//		Connection con = null;
//		
//		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		//3.
//		String sql = " INSERT INTO TIME(ID,TIME) "
//				   + " VALUES (?, ?) ";
//		
//		PreparedStatement pstm = null;
//		
//		try {
//			//3. Query준비
//			pstm = con.prepareStatement(sql);
//
//			pstm.setString(1,  id);
//			pstm.setInt(2,  time);
//			//4. Query 실행 및 리턴
//			int res = pstm.executeUpdate();
//			if(res > 0) {
//				System.out.println("입력 성공");
//			} else {
//				System.out.println("입력 실패");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			//5. DB종료
//			try {
//				pstm.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
}	
	
	
//	public static void insertForPrepared() {
		
		
//		Scanner sc = new Scanner(System.in);	
//		System.out.println("아이디 입력 : ");
//		String id = tfId2.tfId.getText();
//		System.out.println("시간 입력 : ");
//		int time = (int) Game.time();
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		//2.
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "system";
//		String password = "k404";
//		Connection con = null;
//		
//		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		//3.
//		String sql = " INSERT INTO TIME(ID,TIME) "
//				   + " VALUES (?, ?) ";
//		
//		PreparedStatement pstm = null;
//		
//		try {
//			//3. Query준비
//			pstm = con.prepareStatement(sql);
//
//			pstm.setString(1,  id);
//			pstm.setInt(2,  time);
//			//4. Query 실행 및 리턴
//			int res = pstm.executeUpdate();
//			if(res > 0) {
//				System.out.println("입력 성공");
//			} else {
//				System.out.println("입력 실패");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			//5. DB종료
//			try {
//				pstm.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
//	public boolean insertMember(DTO dto) {
//
//		boolean ok = false;
//
//		Connection con = null; // 연결
//		PreparedStatement ps = null; // 명령
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		//2.
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "system";
//		String password = "k404";
//		
//		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try {
//
//		//String sql = "insert into TB_MEMBER2(" + "num,name,id,pwd,snid) " + "values(?,?,?,?,?)";
//	String sql = "insert into TIME(" + "id,time) " + "values(?,?)";
////		String sql = "insert into TB_MEMBER2(" + "name,id,pwd,snid) " + "values(?,?,?,?)";
//
//			ps = con.prepareStatement(sql);
//		//ps.setString(1, dto.getNum());
//			ps.setString(2, dto.getId());
//			ps.setInt(4, dto.getTime());
//			int r = ps.executeUpdate(); // 실행 -> 저장
//
//			if (r > 0) {
//				System.out.println("가입 성공");
//				ok = true;
//			} else {
//				System.out.println("가입 실패");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return ok;
//	}// insertMmeber
//}