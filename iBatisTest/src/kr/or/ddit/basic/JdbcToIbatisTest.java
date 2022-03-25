package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.LprodVO;

/*
 *  Lprod테이블에 새로운 데이터를 추가하기
 *  
 *  lprod_gu와 lprod_nm은 직접 입력받아서 처리하고 
 *  lprod_id는 현재의 lprod_id 중에서 큰 값보다 1크게 한다.
 *  	==> max라는 함수 이용해서 하기
 *  그리고 lprod_gu(프라이머리키)가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 *  	==> count(*) from ~ 'p101' ==> 있으면 1 없으면 0 나온다
 *  (sql문이 저장되는 xml 문서의 파일 명 : jdbc.xml)
 *  
 *  
 *  //내가한것!!!
 */


public class JdbcToIbatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = null;
		
		try {
			/*
			 * //1-1 문자 인코딩 캐릭터셋 설정 Charset charset = Charset.forName("utf-8");
			 * 
			 * //1-2 환경 설정 파일을 읽어올 스트림객체 생성 Reader rd =
			 * Resources.getResourceAsReader("kr/or/ddit/ibais/config/sqlMapconfig.xml");
			 * 
			 * 
			 * smc = SqlMapClientBuilder.buildSqlMapClient(rd); rd.close();
			 */
	    	 //-------------------------------------------------
			smc = SqlMapClientFactory.getSqlMapClient();
			
			
	    	 //max 값 구하기
	    	 
	    	 int maxNum = (int) smc.queryForObject("Jlprod.getMaxId");
	    	 maxNum++;
	    	 
	    	 //입력한 gu가 존재하는가?
	    	 String gu;
	    	 int count =0;
	    	 do {
	    		 System.out.print("Lprod_gu 입력 : ");
	    		 gu = scan.next();
	    		 count = (int) smc.queryForObject("Jlprod.getcount", gu );
	    		 if(count>0) {
	    			 System.out.println("이미 존재하는 Lprod_gu 입니다");
	    			 System.out.println("다시 입력해주세요");
	    		 }
	    		 
	    	 }while(count >0);
	    	 
	    	
	    	 System.out.println("Lprod_nm 입력 : ");
	    	 String nm = scan.next();
	    	
	    	 LprodVO memVo = new LprodVO();
	    	 memVo.setLprod_gu(gu);
	    	 memVo.setLprod_nm(nm);
	    	 memVo.setLprod_id(maxNum);
	    	 Object obj = smc.insert("Jlprod.insert",memVo);
	    	 
	    	 if(obj == null) {
	    		 System.out.println("insert에 성공~!");
	    	 }else {
	    		 System.out.println("insert에 실패~!");
	    	 }

		} catch (SQLException e) {
			// TODO: handle exception
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		
		
		
		
	}

}
