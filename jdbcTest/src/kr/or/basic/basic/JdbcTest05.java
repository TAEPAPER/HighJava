package kr.or.basic.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 *  Lprod테이블에 새로운 데이터를 추가하기
 *  
 *  lprod_gu와 lprod_nm은 직접 입력받아서 처리하고 
 *  lprod_id는 현재의 lprod_id 중에서 큰 값보다 1크게 한다.
 *  	==> max라는 함수 이용해서 하기
 *  그리고 lprod_gu(프라이머리키)가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 *  	==> count(*) from ~ 'p101' ==> 있으면 1 없으면 0 나온다
 *  
 *  
 *  
 *  //내가한것!!!
 */

public class JdbcTest05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt  =  null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PTJ94","java");
			String lprodGu;
			String lprodNm;
			boolean flag = true;
			do { 
				System.out.println("lprod_gu입력>>");
				 lprodGu = scan.nextLine();
				 System.out.println("lprod_nm입력>>");
				 lprodNm = scan.nextLine();
				String sql0 = "select count(*) count from lprod where lprod_gu = ?";
				pstmt = conn.prepareStatement(sql0);
				pstmt.setString(1, lprodGu);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int count = rs.getInt("count");
					if (count ==0) {
						flag = false;
					}
				}
			}while(flag);
			 
			 int max=0;
			 String sql = "select max(lprod_id) maxId from lprod ";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery(sql);
			 while(rs.next()) {
				// System.out.println(rs.getInt("maxId"));
				 max = rs.getInt("maxId");
			  }
			 String sql2 = "insert into lprod (lprod_id,lprod_gu,lprod_nm) values (?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, max +1);
			pstmt.setString(2,lprodGu);
			pstmt.setString(3, lprodNm);
			int cnt = pstmt.executeUpdate();
			System.out.println("성공!!");
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	 
		
		
		
		
	}
}
