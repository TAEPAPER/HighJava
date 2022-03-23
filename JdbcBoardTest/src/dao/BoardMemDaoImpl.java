package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil3;
import vo.BoardMemVO;

public class BoardMemDaoImpl implements BoardMemDao {
	// 1번
	private static BoardMemDaoImpl dao;

	// 2번
	private BoardMemDaoImpl() {

	}

	// 3번
	public static BoardMemDaoImpl getInstance() {
		if (dao == null) {
			dao = new BoardMemDaoImpl();
			return dao;
		}
		return dao;
	}

	@Override
	public List<BoardMemVO> displayAll(Connection conn) throws SQLException {
		String sql = "select * from jdbc_board ";
		conn = DBUtil3.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<BoardMemVO> list = new ArrayList<BoardMemVO>();
		while(rs.next()) {
			BoardMemVO memVo = new BoardMemVO();      
				memVo.setBoard_no(rs.getInt("board_no"));
				memVo.setBoard_title(rs.getString("board_title"));
				memVo.setBoard_writer(rs.getString("board_writer"));
				memVo.setBoard_date(rs.getString("board_date"));
				memVo.setBoard_cnt(rs.getInt("board_cnt"));
			    memVo.setBoard_content(rs.getString("board_content"));
			    list.add(memVo);
		}
		if(conn!=null)conn.close();
		
		return list;
	}

	@Override
	public int insertBoard(Connection conn, BoardMemVO boardMemVo) throws SQLException  {
		String sql = "insert into jdbc_board values(board_seq.nextVal,?,?,"
				+ " sysdate,NVL(max(board_cnt)+1,0),?)  ";
		conn = DBUtil3.getConnection();	
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1,boardMemVo.getBoard_title());
		pstmt.setString(2,boardMemVo.getBoard_writer());
		pstmt.setString(3,boardMemVo.getBoard_content());
		int cnt = pstmt.executeUpdate();
		
		return cnt;
	}

	@Override   //해당 게시글 보기
	public List<BoardMemVO> choiceBoard(Connection conn,int boardNo ,BoardMemVO boardMemVo ) throws SQLException {
		 String sql = "select * from jdbc_board where board_no = ?";
		 conn = DBUtil3.getConnection();
		   PreparedStatement  pstmt= conn.prepareStatement(sql);
		   pstmt.setInt(1,boardNo);
		   	 ResultSet rs = pstmt.executeQuery();
		   	 List<BoardMemVO> list = new ArrayList<BoardMemVO>();
		   	  if(rs.next()) {
		   		    BoardMemVO memVo = new BoardMemVO();
		   		    memVo.setBoard_no(rs.getInt("board_title"));
		   		    memVo.setBoard_writer(rs.getString("board_writer"));
		   		    memVo.setBoard_content(rs.getString("board_content"));
		   		    memVo.setBoard_date("board_date");
		   		    memVo.setBoard_cnt("board_");
		   		    
		   	  }
		
		   		  
		return null;
	}

	@Override
	public int updateBoard(Connection conn, BoardMemVO boardMemVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Connection conn, BoardMemVO boardMemVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardMemVO> titleSearch(Connection conn, String searching) {
		// TODO Auto-generated method stub
		return null;
	}

}
