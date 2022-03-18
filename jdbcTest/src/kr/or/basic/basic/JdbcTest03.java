package kr.or.basic.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 문제) lprod_id값을 2개를 입력 받아서 두값들 중 작은값부터 큰값사이의 자료들을 출력하시오
 * 
 */
public class JdbcTest03 {
public static void main(String[] args) {
 	//DB작업에 필요한 객체 변수 선언
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs = null;
	  Scanner sc = new Scanner(System.in);
	  int a;
	  int b;
	//  do {
		  System.out.println(" 값 1입력");
		  a = sc.nextInt();
		  System.out.println(" 값 2입력");
		  b =sc.nextInt();
	//  }while(a>b);
	  
	  int min = Math.min(a, b);
	  int max = Math.max(a, b);
	  
	  
	  try {
          //1.드라이버 로딩
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		    //2.DB연결 ==> Connection객체 생성
		  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" //url
				  , "PTJ94" //user
				  , "java");//password
		   //3.SQL문 작성하기
		  
		  String sql = "select * from lprod where lprod_id between "+min+" and "+max ;
		  
		   //4.Statement객체 생성 ==>질의를 처리하는 객체 생성
		  stmt = conn.createStatement();
		   //5.SQL문을 DB서버로 보내서 결과를 얻어온다.(실행할 SQL문이 select문이기 때문에 결과가 resultset에 저장되어 변환된다.)
		  rs = stmt.executeQuery(sql);
		  
		  //6.결과 처리하기 ==> 한레코드씩 읽어오기
		  // ResultSet의 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.
		  System.out.println("== 쿼리문 처리 결과 == ");
		  //rs.next() ==> ResultSet객체의 데이터를 가리키는 포인터를 다음번째 위치로 이동시키고 
		  //그 곳에 데이터가 있으면 , true,없으면 false를 반환
		  
		  while(rs.next()) {
			  //포인터가 가리키는 곳의 자료를 가져오는 방법
			  //형식1)rs.get자료형이름("컬럼명")
			  //형식2)rs.get자료형이름(컬럼번호) ==> 컬럼번호는 1번부터 시작
			  //형식3)rs.get자료형이름("컬럼의 alias명")
			  System.out.println("Lprod_ID : "+rs.getInt("lprod_id"));
			  System.out.println("Lprod_GU : "+rs.getString("lprod_gu"));
			  System.out.println("Lprod_NM : "+rs.getString("lprod_nm"));
			  System.out.println("-----------------------------------");
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
