package kr.or.basic.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.basic.basic.mvc.dao.IMemberDao;
import kr.or.basic.basic.mvc.dao.MemberDaoImpl;
import kr.or.basic.basic.mvc.vo.MemberVO;
import kr.or.basic.util.DBUtil;
import kr.or.basic.util.DBUtil3;

public class MemberServiceImpl implements IMemberService {
private IMemberDao dao;
//생성자
public MemberServiceImpl() {
	dao = new MemberDaoImpl();
	// TODO Auto-generated constructor stub
}

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		int cnt =0; //반환값 변수
		try {
			conn = DBUtil.getConnection();
			cnt = dao.insertMember(conn, memVo);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
			Connection conn = null;
			int cnt = 0;
			try {
				conn = DBUtil.getConnection();
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
			conn = DBUtil.getConnection();
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
			 conn = DBUtil.getConnection();
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
	public int updateMember2(String updateField,String memId,String updateData) {
		Connection conn = null;
		 int cnt =0;
		try {
			conn = DBUtil.getConnection();
			cnt = dao.updateMember2(conn, updateField,memId,updateData);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}
  
}
