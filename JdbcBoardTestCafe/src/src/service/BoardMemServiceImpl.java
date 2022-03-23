package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.dao.BoardMemDaoImpl;
import src.util.DBUtil3;
import src.vo.BoardMemVO;

public class BoardMemServiceImpl implements BoardMemService{
     //1번
	private static BoardMemServiceImpl service;
	private BoardMemDaoImpl dao;
	
	//2번
	private BoardMemServiceImpl() {
		dao = BoardMemDaoImpl.getInstance();
	}
	//3번
	public static BoardMemServiceImpl getInstance() {
		if(service == null) {
			service = new BoardMemServiceImpl();
			return service;
		}
	        return service;
	}
	
	@Override
	public List<BoardMemVO> displayAll() {
		Connection conn = null;
		List<BoardMemVO> list = null;
		try {
			 conn = DBUtil3.getConnection();
			 list  =  dao.displayAll(conn);
		} catch (SQLException e) {
			list = null;
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return list;
	}

	@Override
	public int insertBoard(BoardMemVO boardMemVO) {
		Connection conn = null;
		int cnt =0;
		try {
			 conn = DBUtil.getConnection();
			 int cnt =  dao.insertBoard(conn);
		} catch (SQLException e) {
			int cnt =0;
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardMemVO> choiceBoard(int board_no) {
		Connection conn = null;
		List<BoardMemVO> list = null;
		
		try {
			 conn = DBUtil3.getConnection();
			 list  =  dao.choiceBoard(conn, board_no);
		} catch (SQLException e) {
			list = null;
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return null;
	}

	@Override
	public int updateBoard(BoardMemVO boardMemVo , String title, String content) {
		Connection conn = null;
		int cnt =0;
		try {
			 conn = DBUtil.getConnection();
			 int cnt =  dao.updateBoard(conn,title,content);
		} catch (SQLException e) {
			int cnt =0;
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		int cnt =0;
		try {
			 conn = DBUtil.getConnection();
			 int cnt =  dao.deleteBoard(conn, boardNo);
		} catch (SQLException e) {
			int cnt =0;
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardMemVO> titleSearch(String searching) {
		Connection conn = null;
		List<BoardMemVO> list = new ArrayList<BoardMemVO>();
		try {
			 conn = DBUtil.getConnection();
			 int list =  dao.titleSearch(conn, searching);
		} catch (SQLException e) {
			
		}finally {
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
		return list;
	}

}
