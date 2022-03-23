package service;

import java.util.List;

import dao.BoardMemDaoImpl;
import vo.BoardMemVO;

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
	public List<BoardMemVO> displayAll(List<BoardMemVO> boardMemVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(BoardMemVO boardMemVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardMemVO choiceBoard(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(BoardMemVO boardMemVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(BoardMemVO boardMemVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardMemVO> titleSearch(String searching) {
		// TODO Auto-generated method stub
		return null;
	}

}
