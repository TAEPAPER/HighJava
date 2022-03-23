package kr.or.basic.basic.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.basic.basic.mvc.service.IMemberService;
import kr.or.basic.basic.mvc.service.MemberServiceImpl;
import kr.or.basic.basic.mvc.vo.MemberVO;

public class MemberController {
	private Scanner scan = new Scanner(System.in);
	private IMemberService service;

	public MemberController() {
		service = MemberServiceImpl.getInstance();
	}

	public void startMember() {
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				insertMember(); // 추가
				break;
			case 2:
				updateMember(); // 수정
				break;
			case 3:
				deleteMember(); // 삭제
				break;
			case 4:
				displayMember(); // 전체자료 출력
				break;
			case 5:
				updateMember2(); // 원하는 항목만!
				break;
			case 0:
				System.out.println("작업을 마칩니다");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요");
				break;
			}
		}
	}
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요");
		System.out.println("회원ID >>");
		String memId = scan.next();
		int count = service.getMemberCount(memId);
		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID입니다");
			System.out.println("수정작업을 마칩니다");
			return;
		}
		
		int num;
		String updateField = null; // 컬럼명
		String updateTitle = null; // 타이틀
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println(" 1.비밀번호 2.회원이름 3.전화번호 4.회원주소");
			System.out.println("---------------------------------------------");
			System.out.print("수정항목 선택>>");
			num = scan.nextInt();

			switch (num) {
			case 1:
				updateField = "mem_pass";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "mem_name";
				updateTitle = "회원이름";
				break;
			case 3:
				updateField = "mem_tel";
				updateTitle = "전화번호";
				break;
			case 4:
				updateField = "mem_addr";
				updateTitle = "주소";
				break;
			default:
				System.out.println("수정항목을 잘못 선택했습니다");
				System.out.println("다시 선택하세요");
			}
		} while (num < 1 || num > 4);

		System.out.println();
		System.out.print("새로운 " + updateTitle + " >> ");
		scan.nextLine(); // 버퍼 비우기
		
		//수정작업에 필요한 정보를 Map객체에 셋팅한다.
		String updateData = scan.nextLine();
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("memid", memId); //회원ID
		paramMap.put("field",updateField); //수정할 컬럼명
		paramMap.put("data", updateData);  //수정할 데이터
		int cnt = service.updateMember2(paramMap);
		
		if (cnt > 0) {
			System.out.println(updateTitle+"회원정보 수정 성공!!");
		} else {
			System.out.println(updateTitle+"회원정보 수정 실패!~~");
		}
	}
	private int displayMenu() {
		System.out.println();
		System.out.println("= = 작업선택 = =");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 전체자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝...");
		System.out.println("----------------------");
		System.out.print("원하는 작업번호 >>");
		return scan.nextInt();
	}

	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요");
		// 자료 추가에서 회원 id는 중복되지 않는다- 중복되면 다시 입력받는다

		int count = 0; // 입력한 회원 id의 개수가 저장될 변수
		String memId; // 회원id가 저장될 변수
		do {
			System.out.println("회원 id>>");
			memId = scan.next();
			count = service.getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "는 이미 등록된 아이디 입니다");
				System.out.println("다른 회원 id를 입력하세요");
			}
		} while (count > 0);
		System.out.println("비밀번호>>");
		String memPass = scan.next();
		System.out.println("회원이름 >>");
		String memName = scan.next();
		System.out.println("전화번호>>");
		String memTel = scan.next();
		System.out.println("주소>>");
		scan.nextLine(); // 입력버퍼 지워주기
		String memAddr = scan.nextLine();

		// 입력한 데이터를 VO객체에 저장한다
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		int cnt = service.insertMember(memVo);
		if (cnt > 0) {
			System.out.println("회원정보 추가 성공!!");
		} else {
			System.out.println("회원정보 추가 실패!~~");
		}
	}

	private void updateMember() { // ==>전체항목 수정
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요");
		System.out.println("회원ID >>");
		String memId = scan.next();
		int count = service.getMemberCount(memId);
		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID입니다");
			System.out.println("수정작업을 마칩니다");
			return;
		}

		System.out.println();
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("새로운 비밀번호 >>");
		String newMemPass = scan.next();
		System.out.println("새로운 회원이름 >>");
		String newMemName = scan.next();
		System.out.println("새로운 전화번호>>");
		String newMemTel = scan.next();
		System.out.println("새로운 회원주소>>");
		scan.nextLine();
		String newMemAddr = scan.nextLine();

		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newMemPass);
		memVo.setMem_name(newMemName);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);

		int cnt = service.updateMember(memVo);

		if (cnt > 0) {
			System.out.println("회원정보 수정 성공!!");
		} else {
			System.out.println("회원정보 수정 실패!~~");
		}
	}

	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원정보를 입력하세요");
		System.out.print("삭제할 회원 ID>>");
		String memId = scan.next();
		int cnt = service.deleteMember(memId);
		if (cnt > 0) {
			System.out.println("회원정보 삭제 성공!!");
		} else {
			System.out.println("회원정보 삭제 실패!~~");
		}

	}

	private void displayMember() {
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("ID    비밀번호    이름    전화번호    주소");
		System.out.println("----------------------------------------");
		List<MemberVO> list = service.getAllMember();
		if (list == null || list.size() == 0) {
			System.out.println("출력할 자료가 없습니다");

		} else {
			for (MemberVO mem : list) {
				System.out.print(mem.getMem_id() + "\t");
				System.out.print(mem.getMem_pass() + "\t");
				System.out.print(mem.getMem_name()+"\t");
				System.out.print(mem.getMem_tel() + "\t");
				System.out.println(mem.getMem_addr() + "\t");
				System.out.println("----------------------------------------");
			}
		}
	}

	public static void main(String[] args) {
		new MemberController().startMember();
	}
}
