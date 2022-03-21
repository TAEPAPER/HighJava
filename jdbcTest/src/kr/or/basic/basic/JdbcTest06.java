package kr.or.basic.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.basic.util.DBUtil;

/*
 *  회원을 관리하는 프로그램을 작성하시오
 *  (MYMEMBER 테이블 이용)
 *  
 *  아래 메뉴의 기능을 구현하시오(CRUD기능 구현)
 *  
 *  메뉴예시)
 *  --------------------
 *       == 작업 선택 ==
 *     1. 자료 추가 -->insert(C)
 *     2. 자료 수정 -->update(U)
 *     3. 자료 삭제 -->delete(D)
 *     4. 전체자료 출력 -->select(R)
 *     0. 작업 끝  
 * --------------------
 * 조건)
 * 1)자료 추가해서 '회원ID'는 중복되지 않는다.(기본키니까)-중복되면 다시 입력받도록 하기
 * 2)자료 삭제는 '회원ID'를 입력 받아서 처리한다.
 * 3)자료 수정에서 '회원 ID는 변경불가'
 * 
 * 
 */
public class JdbcTest06 {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		new JdbcTest06().start();
	}

	public void start() {
		try {
			conn = DBUtil.getConnection();
			while (true) {
				int num = displayMenu();
				switch (num) {
				case 1:
					insert(); // 추가
					break;
				case 2:
					update(); // 수정
					break;
				case 3:
					delete(); // 삭제
					break;
				case 4:
					printAll(); // 전체출력
					break;
				case 0:
					System.out.println("작업을 종료합니다");
					System.exit(0);
					break;
				}
			}
		} catch (Exception e) {
      e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
			
		}
	}

	private void printAll() throws SQLException { // 전체 출력하기
		System.out.println("======== 전체출력 ========");
		String sql = "select * from mymember";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) { // 자료가 있으면
			System.out.println("아이디 : " + rs.getString("mem_id"));
			System.out.println("이름 : " + rs.getString("mem_name"));
			System.out.println("비밀번호 : " + rs.getString("mem_pass"));
			System.out.println("전화번호 : " + rs.getString("mem_tel"));
			System.out.println("주소 : " + rs.getString("mem_addr"));
		}
	}
	private void delete() throws SQLException { // 삭제하기
		
		System.out.println("삭제할 회원의 ID>>");
		String name = sc.nextLine();
		String sql = "delete from mymember where mem_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);

		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("삭제가 완료되었습니다");
		} else {
			System.out.println("삭제 실패!!");

		}

	}

	private void update() throws SQLException { // 수정하기
		sc.nextLine();
		System.out.print("정보를 수정할 ID>>");
		String memId = sc.nextLine();
		System.out.println("변경할 이름>>");
		String name = sc.nextLine();
		System.out.println("변경할 비밀번호>>");
		String password = sc.nextLine();
		System.out.println("변경할 전화번호>>");
		String tel = sc.nextLine();
		System.out.println("변경할 주소>>");
		String addr = sc.nextLine();
		String sql = "update mymember set mem_name = ? , mem_pass = ? ,mem_tel = ?, mem_addr = ?" + " where mem_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setString(3, tel);
		pstmt.setString(4, addr);
		pstmt.setString(5, memId);

	}

	private void insert() throws SQLException { // 추가하기
		System.out.print("ID입력>>");
		sc.nextLine();
		String memId = sc.nextLine();
		// 중복여부 확인
		String sql = "select count(*) cnt from mymember where mem_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memId);
		rs = pstmt.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt("cnt");
			if (count == 1) {
				System.out.println("이미 등록된 ID입니다");
				System.out.println("다시 입력해주세요");
				insert();
			}
			// 중복되지 않은 경우
			System.out.println("이름 입력>>");
			String name = sc.nextLine();
			System.out.println("비밀번호 입력>>");
			String password = sc.nextLine();
			System.out.println("전화번호 입력>>");
			String tel = sc.nextLine();
			System.out.println("주소 입력>>");
			String addr = sc.nextLine();

			sql = "insert into mymember (mem_id, mem_name,mem_pass,mem_tel,mem_addr)" + " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("등록이 성공적으로 완료되었습니다");
			} else {
				System.out.println("등록 실패하였습니다");
			}
		}
	}
	private int displayMenu() { // 메뉴보기
		System.out.println("--------------------");
		System.out.println("1. 자료 추가 ");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 전체자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("--------------------");
		int input = sc.nextInt();
		return input;
	}
}
