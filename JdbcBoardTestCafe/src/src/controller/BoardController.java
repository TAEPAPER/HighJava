package controller;

import java.util.List;
import java.util.Scanner;

import src.service.BoardMemService;
import src.service.BoardMemServiceImpl;
import src.vo.BoardMemVO;

public class BoardController {
	private Scanner scan = new Scanner(System.in);
	private BoardMemService service;

	public BoardMemController() {
		service = BoardMemServiceImpl.getInstance();
	}

	private void start() {
		while (true) {
			int num = displayMenu();
			switch(num) {
			case 1: newBoard();break;
			case 2:break;
			case 3:break;
			case 0: break;
			
			}
			

		}

	}

	private void newBoard() {
		System.out.println("새글 작성하기");
		System.out.println("---------//-----------");
		System.out.print("제 목 : ");
		scan.nextLine(); //버퍼 비워주기
		String title = scan.nextLine();
		String writer = scan.nextLine();
		String content = scan.nextLine();
		
		BoardMemVO memVo = new BoardMemVO();
		memVo.setBoard_title(title);
		memVo.setBoard_writer(writer);
		memVo.setBoard_content(content);
		int cnt = service.insertBoard(memVo);
		if(cnt>0)System.out.println("새글이 추가되었습니다");
		
		
	}

	private int displayMenu() {
		System.out.println("------------------------------------------");
		System.out.println("No\tt제 목\t\t작 성 자\t\t조회");
		System.out.println("------------------------------------------");
		List<BoardMemVO> list = service.displayAll();
		if(list == null || list.size()==0){
		     "출력할 게시글이 하나도 없습니다"
		}else{
		for(BoardMemVO mem : list) {
		 System.out.print(mem.getBoard_no()+"\t");
		 System.out.print(mem.getBoard_title()+"\t");
		 System.out.print(mem.getBoard_writer()+"\t");
		 System.out.println(mem.getBoard_cnt()+"\t");
			}
		}
		System.out.println("------------------------------------------");
		System.out.println("1.새글작성  2.게시글 보기  3.검색  4. 작업끝  ");
		int input = scan.nextInt();
		return input;
	}

	public static void main(String[] args) {
		new BoardController().start();
	}

}
