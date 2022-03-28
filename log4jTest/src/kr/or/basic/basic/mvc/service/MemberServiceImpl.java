package kr.or.basic.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.basic.basic.mvc.dao.IMemberDao;
import kr.or.basic.basic.mvc.dao.MemberDaoImpl;
import kr.or.basic.basic.mvc.vo.MemberVO;

import kr.or.basic.util.DBUtil3;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	private static final Logger logger = 
			Logger.getLogger(MemberServiceImpl.class);
	//1번
	private static MemberServiceImpl service;
	//2번 //생성자
	private MemberServiceImpl() {
	//dao = new MemberDaoImpl();
	dao = MemberDaoImpl.getInstance();
}
	//3번
public static MemberServiceImpl getInstance() {
	if(service == null) {
		service = new MemberServiceImpl();
		return service;
	}
	return service;
}


	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		int cnt =0; //반환값 변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			cnt = dao.insertMember(conn, memVo);
			logger.info("insert작업 성공!!");
		} catch (SQLException e) {
			logger.error("insert작업 오류 : "+ e);
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();
			logger.info("Connection 객체 반납...");
			}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
			Connection conn = null;
			int cnt = 0;
			try {
				conn = DBUtil3.getConnection();
				cnt = dao.deleteMember(conn, memId);
				
			} catch (SQLException e) {
				cnt =0;
				e.printStackTrace();
			}finally {
				if(conn!=null)try{conn.close();}catch(SQLException e) {}
			}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateMember(conn, memVo);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		List<MemberVO> list = null;
		try {
			 conn = DBUtil3.getConnection();
			 list  =  dao.getAllMember(conn);
		} catch (SQLException e) {
			list = null;
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		int count = 0;
		try {
			conn = DBUtil3.getConnection();
			count = dao.getMemberCount(conn, memId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return count;
	}

	@Override
	public int updateMember2( Map<String,String> paramMap) {
		Connection conn = null;
		 int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateMember2(conn, paramMap);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn != null)try{conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}
  
}
