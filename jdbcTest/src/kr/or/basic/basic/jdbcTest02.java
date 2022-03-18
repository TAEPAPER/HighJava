package kr.or.basic.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 문제 ) 사용자로부터 LPROD_ID 값을 입력 받아서 입력한 값보다 LPROD_ID가 큰 자료들을 출력하시오
 */
public class jdbcTest02 {
	public static void main(String[] args) {
				Scanner sc =  new Scanner(System.in);
				  Connection conn = null;
				  Statement stmt = null;
				  ResultSet rs = null;
				  try {
			            //1.드라이버 로딩
					  Class.forName("oracle.jdbc.driver.OracleDriver");
					    //2.DB연결 ==> Connection객체 생성
					  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" //url
							  , "PTJ94" //user
							  , "java");//password
					   //3.SQL문 작성하기
					  
					  //String sql = "select lprod_id,lprod_gu,lprod_nm nm from lprod ";
					  System.out.println("LPROD_ID>>");
					  int id = sc.nextInt();
					  String sql = "select * from lprod where lprod_id >"+ id;
					  
					  //4.Statement객체 생성 ==>질의를 처리하는 객체 생성
					  stmt = conn.createStatement();
					
					   //5.SQL문을 DB서버로 보내서 결과를 얻어온다.(실행할 SQL문이 select문이기 때문에 결과가 resultset에 저장되어 변환된다.)
					  rs = stmt.executeQuery(sql);
					  
					  
					  //6.결과 처리하기 ==> 한레코드씩 읽어오기
					  // ResultSet의 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.
					 
					  System.out.println("== 쿼리문 처리 결과 == ");
					  while(rs.next()) {
						  //포인터가 가리키는 곳의 자료를 가져오는 방법
						  //형식1)rs.get자료형이름("컬럼명")
						  //형식2)rs.get자료형이름(컬럼번호) ==> 컬럼번호는 1번부터 시작
						  //형식3)rs.get자료형이름("컬럼의 alias명")
					//	if(rs.getInt("lprod_id")>id) { //반복문도 있지만 쿼리 자체를 수정하는게 더 좋겠죠?
						  System.out.println("Lprod_ID : "+rs.getInt("lprod_id"));
						  System.out.println("Lprod_Gu : "+ rs.getString("lprod_gu"));
						  System.out.println("Lprod_nm : "+rs.getString("lprod_nm"));
						  System.out.println("-----------------------------------");
						//  }
					  }
					  
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//7.자원 반납
					if (rs != null)try {rs.close();} catch (Exception e) {} //닫아서 반납을 해줌
					if (stmt != null)try {stmt.close();} catch (Exception e) {}
					if (conn != null)try {conn.close();} catch (Exception e) {}
				}
	
	}
}
