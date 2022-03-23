package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import vo.BoardMemVO;

public interface BoardMemDao {
   /**
    * VO에서 정보를 가져와서 보드에 삽입하는 메서드
    * @param conn 커넥션 객체
    * @param boardMemVO
    * @return 성공 : 1 , 실패 : 0
    */
	/**
	 * 전체 게시글을 보여주는 메서드 | 리스트에 각각의 객체 정보가 담겨있다
	 * @param conn
	 * @param boardMemVo
	 * @return
	 */
	public List<BoardMemVO> displayAll(Connection conn) throws SQLException;
	
	public int insertBoard(Connection conn,  BoardMemVO boardMemVO) throws SQLException;
	
	/**
	 * board_no를 통해서 해당 게시글 정보 (BoardMemVO) 보내주는 메서드
	 * @param conn
	 * @param board_no
	 * @return 리스트에 담아서 보내줌
	 */
	public List<BoardMemVO> choiceBoard(Connection conn,int boardNo ) throws SQLException; 
 /**
  * 게시글 조회에서 제목과 내용을 수정하는 메서드
  * @param conn
  * @param boardMemVO
  * @return 성공 : 1, 실패 : 0
  */
	public int updateBoard(Connection conn, int boardNo,String title, String content)throws SQLException;
	/**
	 * 게시글 조회에서 해당 게시글을 삭제하는 메서드
	 * @param conn
	 * @param boardMemVO
	 * @return 성공 : 1, 실패 :0
	 */
	public int deleteBoard(Connection conn,  int boardNo )throws SQLException;
	/**
	 * 제목을 입력받아서 DB에서 해당 단어를 포함한 게시글을 리턴해주는 메서드
	 * @param conn
	 * @param searching
	 * @return List형태를 반환해준다
	 */
	//검색
	public List<BoardMemVO> titleSearch (Connection conn, String searching)throws SQLException;
}
