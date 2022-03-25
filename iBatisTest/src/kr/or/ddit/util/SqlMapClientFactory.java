package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
		public static SqlMapClient getSqlMapClient() {
				SqlMapClient smc = null;
				 Reader rd =null;
				try {
					
					Charset charset = Charset.forName("utf-8");
			    	
			    	//1-2 환경 설정 파일을 읽어올 스트림객체 생성
			    	  rd = Resources.getResourceAsReader("kr/or/ddit/ibais/config/sqlMapconfig.xml");
			    	 
			    	
			         smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			    	 rd.close();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if(rd != null) try {rd.close();}catch(IOException e) {}
				}
		return smc;
		}
}
