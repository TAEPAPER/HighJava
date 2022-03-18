package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 *   컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *   
 *   컴퓨터의 가위 바위 보는 난수를 이용해서 구하고, 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력받는다.
 *   
 *   입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 *   5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 *   
 *   5초 안에 입력이 있으면 승패를 구해서 출력한다.
 *   
 *   결과 예시) 
 *   1) 5초안에 입력이 없을 때
 *      - 결 과 -
 *      시간 초과로 당신이 졌습니다.
 *      
 *   2) 5초안에 입력이 있을 때
 *   - 결 과 -
 *   컴퓨터 : 가위
 *   당 신 : 바위
 *   결과 : 당신이 이겼습니다 //컴퓨터가 이겼습니다// 비겼습니다
 *   
 *   
 */
public class ThreadTest07 {

	public static void main(String[] args) {
		
		Thread com = new Computer(); //  쓰레드 생성
		Thread input = new inputrsp(); 
		Thread count = new Count();
		
		com.start();
		input.start();
		count.start();	
	}
}
//컴퓨터의 가위바위보 
class Computer extends Thread{
	public static String computer;	
	@Override
	public void run() {
		String[] rsp = new String[]{"가위", "바위", "보"};
		int index = (int)(Math.random()*3);
		computer = rsp[index];
	}
}
//사용자가 가위바위보를 입력하는 메서드
class inputrsp extends Thread{
	public static boolean inputCheck = false;
	@Override
	public void run() {
	String client = JOptionPane.showInputDialog("가위 바위 보 중에 입력>>");
	inputCheck = true;
	System.out.println("-결 과-");
	switch(Computer.computer) {
	case("가위") :
		if(client.equals("가위")) 	
		System.out.println("컴퓨터 : "+ Computer.computer);
		System.out.println("당신 : "+ client);
		System.out.println("결과 : 비겼습니다");
		if(client.equals("바위")) {
			System.out.println("컴퓨터 : "+ Computer.computer);
			System.out.println("당신 : "+ client);
			System.out.println("결과 : 당신이 이겼습니다");
		if(client.equals("보")) {
			System.out.println("컴퓨터 : "+ Computer.computer);
			System.out.println("당신 : "+ client);
			System.out.println("결과 : 당신이 졌습니다");
		}
		}
		break;
	case("바위") :
		if(client.equals("바위")) { 	
			System.out.println("컴퓨터 : "+ Computer.computer);
			System.out.println("당신 : "+ client);
			System.out.println("결과 : 비겼습니다");}
			if(client.equals("가위")) 	{
				System.out.println("컴퓨터 : "+ Computer.computer);
				System.out.println("당신 : "+ client);
				System.out.println("결과 : 당신이 졌습니다");}
				if(client.equals("보")) {
					System.out.println("컴퓨터 : "+ Computer.computer);
					System.out.println("당신 : "+ client);
					System.out.println("결과 : 당신이 이겼습니다");
				} break;
	case("보")  :
		if(client.equals("보")) {
			System.out.println("컴퓨터 : "+ Computer.computer);
			System.out.println("당신 : "+ client);
			System.out.println("결과 : 비겼습니다");}
			if(client.equals("가위")) 	{
				System.out.println("컴퓨터 : "+ Computer.computer);
				System.out.println("당신 : "+ client);
				System.out.println("결과 : 당신이 이겼습니다");}
				if(client.equals("바위")) 	{
					System.out.println("컴퓨터 : "+ Computer.computer);
					System.out.println("당신 : "+ client);
					System.out.println("결과 : 당신이 졌습니다");	}
				break;
			}
		}
	}

//카운트 다운을 진행하는 쓰레드
class Count extends Thread{
	@Override
	public void run() {
		for(int i =10; i>=1; i--) {
			System.out.println(i);
			if(inputrsp.inputCheck) {
				return; 
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			}
		System.out.println("10초가 지났습니다.시간 초과로 당신이 졌습니다");
		System.exit(0);
	
	}
}
