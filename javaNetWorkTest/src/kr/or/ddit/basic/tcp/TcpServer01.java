package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
	public static void main(String[] args) throws IOException {
          	//TCP소켓 통신을 하기 위해   ServerSocket객체를 생성한다
		 ServerSocket server = new ServerSocket(7777);
		 			System.out.println("접속을 기다립니다");
		 //accept()메서드 ==> 클라이언트의 연결 요청이 올 때까지 계속 기다린다.
		 //==>연결 요청이 오면 새로운 Socket객체를 생성해서 클라이언트의 Socket과 연결하여 반환한다.
		 Socket socket = server.accept();  //accept()에서 socket이 return 되어서 변수에 저장
		 
		 //accept()메서드 이후의 소스는 연결이 완료되어야만 실행된다.
		 System.out.println("클라이언트와 연결되었습니다");
		 System.out.println();
		 
		 System.out.println("접속된 상대방의 정보");
		 System.out.println("IP 주소 : "+ 
		 socket.getInetAddress().getHostAddress());
		 System.out.println("Port번호 : "+ socket.getPort());
		
		 System.out.println("접속된 현재 컴의 정보"); //서버입장
		 System.out.println("IP주소 : "+socket.getLocalAddress());
		 System.out.println("Port번호 : "+ socket.getLocalPort());
		 System.out.println();
		 
		 //클라이언트에게 메세지 보내기
		 
		 //Socket의 OutputStream객체를 구성해서 전송한다.
		 //(Socket의 getOutputStream()메서드를 이용한다.)
		 OutputStream out = socket.getOutputStream();  //바이트기반이니까 다루기 어려워
		 DataOutputStream dos = new DataOutputStream(out);//==> 문자로 해줘야해 //상황에 맞춰서 다른 보조스트림을 이용한다
		 
		//클라이언트에게 메세지 전송하기(소켓에서 쓰기 작업을 진행한다.)
		 dos.writeUTF("환영합니다.어서오세요");  //문자열을 출력하라
		 System.out.println("메세지를 보냈습니다...");
		 
		 //소켓과 스트림 닫기
		 dos.close();
		 socket.close();
		 server.close();
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
	}
}
