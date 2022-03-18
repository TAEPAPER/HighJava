package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//이 클래스는 소켓을 통해서 메세지를 보내는 역할을 담당하는 클래스이다. 

public class Sender extends Thread{  //보내기만하는 쓰레드
	private Socket socket;   
	private DataOutputStream dos; //문자열 아웃풋
	private Scanner scan; //입력받기
	private String name; //누가 보낸것인가
	//생성자
	public Sender(Socket socket) {
		this.socket = socket;
		scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		name = scan.nextLine();
		try {
			dos = new DataOutputStream(this.socket.getOutputStream());
		
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	@Override
		public void run() {
	
		while(dos !=null) {
			try {
				//이름과 입력한 문자열을 연결하여 전송한다.
				dos.writeUTF(name+ " : "+ scan.nextLine());
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
	}
	 
	
	
	

}
