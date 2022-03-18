package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HotelManage {
	  	Scanner sc = new Scanner(System.in);
	  	HashMap<Integer, Hotel> map = new HashMap<Integer,Hotel>();
	  	
	public static void main(String[] args) {
		new HotelManage().start();
	}
  public void start() {
		System.out.println("*********************************************\n"
				+ "       호텔문을 열었습니다. 어서오십시요.\n"
				+ "*********************************************");
	  mapPut();
	  while(true) {
		  int choice=displayMenu();
		  switch(choice) {
		  case 1: checkIn();break;
		  case 2: checkOut();break;
		  case 3: status();break;
		  case 4: System.out.println("*********************************************");
		  		  System.out.println("호텔문을 닫았습니다");
		  		  System.out.println("*********************************************");  		  
		  }
	  }
  }
private void mapPut() {
	int roomNum = 201;
	String kind = "싱글룸";
	for(int i =0; i<9; i++) {
	map.put(roomNum,new Hotel(roomNum,kind));
	roomNum++;
	}
	roomNum = 301;
	kind = "더블룸";
	for(int i =0; i<9; i++) {
		map.put(roomNum,new Hotel(roomNum,kind));
		roomNum++;
		}
	roomNum = 401;
	kind = "스위트룸";
	for(int i =0; i<9; i++) {
		map.put(roomNum,new Hotel(roomNum,kind));
		roomNum++;
		}
}
private void status() { //객실상태
System.out.println("----------------------------------------------\n"
		+ "		현재 객실 상태\n"
		+ "----------------------------------------------\n"
		+ "방 번호	 방 종류	 투숙객 이름\n"
		+ "----------------------------------------------");
ArrayList<Integer> keyList = new ArrayList<Integer>(map.keySet());
Collections.sort(keyList);//키리스트 오름차순
for(Integer key : keyList ) {
	Hotel value	= map.get(key);
	//if(value.customer ==null) {value.customer = "-";}
	if(value.customer == null) {
			System.out.println(value.roomNum+"\t"+value.kind+"\t"+"-");
	}else {
		System.out.println(value.roomNum+"\t"+value.kind+"\t"+value.customer);
	}
}
System.out.println("--------------------------------------------------");
}
private void checkOut() {  //체크아웃
	System.out.println("----------------------------------------------\n"
			+ "   체크아웃 작업\n"
			+ "----------------------------------------------\n"
			+ "체크아웃 할 방 번호를 입력하세요.");
	System.out.print("방번호 입력>>");
	int roomNum = sc.nextInt();
	if(map.get(roomNum).customer ==null) {
		System.out.println(roomNum+"호 객실에는 체크인 한 사람이 없습니다");
		return;
	}
	String client = map.get(roomNum).customer;
	
	map.remove(roomNum);//정보를 아예없애고 
	String kind="";
	if(roomNum >=201 && roomNum<=209) {kind = "싱글룸";}
	if(roomNum >=301 && roomNum<=309) {kind = "더블룸";}
	if(roomNum >=401 && roomNum<=409) {kind = "스위트룸";}
	
	map.put(roomNum, new Hotel(roomNum, kind));//다시만들기
	System.out.println(roomNum+"호 객실의 "+client+"님 체크아웃을 완료하였습니다");
}
private void checkIn() { //체크인
	sc.nextLine();
	System.out.println("----------------------------------------------\n"
			+ "   체크인 작업\n"
			+ "----------------------------------------------\n"
			+ " * 201~209 : 싱글룸\n"
			+ " * 301~309 : 더블룸\n"
			+ " * 401~409 : 스위트룸\n"
			+ "----------------------------------------------\n");
	System.out.print("방 번호 입력>>");
	int roomNum = sc.nextInt();
	if(map.containsKey(roomNum)==false) {
		System.out.println(roomNum+"호 객실은 존재하지 않습니다");
		return;
	}
	if(map.get(roomNum).customer!=null) {
		System.out.println(roomNum+"호 객실은 이미 손님이 있습니다");
		return;
	}
	System.out.println("누구를 체크인 하시겠습니까?");
	sc.nextLine();
	System.out.print("이름 입력>>");
	String customer = sc.nextLine();
	String kind="";
	if(roomNum >=201 && roomNum<=209) {kind = "싱글룸";}
	if(roomNum >=301 && roomNum<=309) {kind = "더블룸";}
	if(roomNum >=401 && roomNum<=409) {kind = "스위트룸";}
	map.remove(roomNum);
	Hotel p = new Hotel(roomNum,kind);
	p.setCustomer(customer);
	map.put(roomNum,p);
	System.out.println("체크인이 완료되었습니다");
	System.out.println();
}
private int displayMenu() {
	  System.out.println("-----------------------------------------------------------");
	  System.out.println("어떤 업무를 하시겠습니까?");
	  System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
	  System.out.println("-----------------------------------------------------------");
	  System.out.print("선택>>");
	  int num = sc.nextInt();
	  return num;
  }
}
class Hotel{
	int roomNum; //방번호
	String kind; //방종류
	String customer; //투숙객 이름
	
	Hotel(int roomNum , String kind){
		this.roomNum = roomNum;
		this.kind = kind;
		String customer;	
	}
	@Override
	public String toString() {
		return "Hotel [roomNum=" + roomNum + ", kind=" + kind + ", customer=" + customer + "]";
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
}
