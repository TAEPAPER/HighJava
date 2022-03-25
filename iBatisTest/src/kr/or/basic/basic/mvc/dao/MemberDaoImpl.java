package kr.or.basic.basic.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.basic.basic.mvc.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	//1번
	private static MemberDaoImpl dao;
	//2번
	private MemberDaoImpl() {}
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao ==null) {
			dao = new MemberDaoImpl();
			return dao;
		}
		return dao;
	}
	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
			Object obj = smc.insert("member.insert",memVo);
			int cnt =0;
			if(obj == null) {
				cnt =1;
			}else {
				cnt =0;
			}
		return cnt;
	}
	@Override //반환값은 성공한 레코드수!
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		int cnt =smc.delete("member.delete",memId);
		return cnt;
	}
	@Override  //반환값은 성공한 레코드수!
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		int cnt = smc.update("member.update",memVo);
		return cnt;
	}
	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		List<MemberVO> list = null;
		list = smc.queryForList("member.displayAll");		
		return list;
	}
	@Override
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException {
			int cnt= (int) smc.queryForObject(memId);
		return cnt;
	}
	@Override
	public int updateMember2(Connection conn, Map<String, String> paramMap) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

    
}
