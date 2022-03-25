package kr.or.basic.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.basic.basic.mvc.dao.IMemberDao;
import kr.or.basic.basic.mvc.dao.MemberDaoImpl;
import kr.or.basic.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;

	// 1번
	private static MemberServiceImpl service;

	// 2번 //생성자
	private MemberServiceImpl() {
		// dao = new MemberDaoImpl();
		dao = MemberDaoImpl.getInstance();
	}

	// 3번
	public static MemberServiceImpl getInstance() {
		if (service == null) {
			service = new MemberServiceImpl();
			return service;
		}
		return service;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = dao.insertMember(smc, memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = dao.deleteMember(smc, memId);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = dao.updateMember(smc, memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlMapClient smc = null;
		List<MemberVO> list = null;
		try {
		smc = SqlMapClientFactory.getSqlMapClient();
		list = dao.getAllMember(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list ;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlMapClient smc = null;
		int count = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			count = dao.getMemberCount(smc, memId);
		} catch (SQLException e) {
			
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

}
