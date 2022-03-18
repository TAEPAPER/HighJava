package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTestHw {

	Scanner sc = new Scanner(System.in);
	HashMap<String, Phone  > map = new HashMap<String, Phone>();
	
	public static void main(String[] args) {
		new PhoneBookTestHw().start();
	}
	private void start() {
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1 : insert();  break;
			case 2:  update(); break;
			case 3:  remove();break;
			case 4: search();break;
			case 5: printAll();break;
			case 0 : System.out.println("프로그램을 종료합니다");       
			}
		}	
	}
private void printAll() { //전체출력
		System.out.println("--------------------------------------------------");
		System.out.println("번호\t이 름\t 전 화 번 호\t주 소");
		System.out.println("--------------------------------------------------");
			int num=1;
		Set<String> keySet =map.keySet();
		for(String key : keySet) {
				Phone value	= map.get(key);
			System.out.println(num +"\t"+value.name+"\t"+value.tel+"\t"+value.addr);
			num++;
		}
		System.out.println("--------------------------------------------------");
	}
private void search() {  //검색
		sc.nextLine();
		System.out.println("이름>>");
		String name = sc.nextLine();
		System.out.println("--------------------------------------------------");
		System.out.println("번호\t이 름\t 전 화 번 호\t주 소");
		System.out.println("--------------------------------------------------");
		System.out.println(map.get(name).name+"\t"+map.get(name).tel+map.get(name).addr);
		System.out.println("--------------------------------------------------");
	}

private void remove() { //삭제
	System.out.println("삭제할 전화번호 정보를 입력하세요");
	sc.nextLine();
	System.out.println("이름>>");
	String name = sc.nextLine();
	map.remove(name);
	System.out.println(name+"님의 정보를 삭제하였습니다");
	}

private void update() {  //수정
	System.out.println("수정할 전화번호 정보를 입력하세요");
	sc.nextLine();
	System.out.println("수정 전 이름>>");
	String name = sc.nextLine();
	map.remove(name);
	System.out.println("이름>>");
	String uName = sc.nextLine();
	System.out.println("전화번호>>");
	String tel = sc.nextLine();
	System.out.println("주소>>");
	String addr = sc.nextLine();
	
	map.put(uName, new Phone(uName, tel, addr));
	
	System.out.println(name+"수정완료!!");

	}

private void insert() { //등록
	
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		sc.nextLine();
		System.out.println("이름>>");
		String name = sc.nextLine();
		System.out.println("전화번호>>");
		String tel = sc.nextLine();
		System.out.println("주소>>");
		String addr = sc.nextLine();
		map.put(name, new Phone(name,tel,addr)); //객체생성
		System.out.println(name+"님의 전화번호 등록완료!!");	
}

private int displayMenu() { //메뉴 보이기
System.out.println("------------------");
System.out.println("1. 전화번호 등록\n"
		+ "2. 전화번호 수정\n"
		+ "3. 전화번호 삭제\n"
		+ "4. 전화번호 검색\n"
		+ "5. 전화번호 전체 출력\n"
		+ "0. 프로그램 종료");
System.out.println("------------------");
System.out.println("번호입력>>");
int num = sc.nextInt();
	return num;	
   }
}
class Phone {
	String name;
	String tel;
	String addr;
	
	Phone(String name, String tel, String addr){
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
	
}