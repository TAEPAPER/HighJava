package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.stream.FileImageOutputStream;

/*서버와 클라이언트가 접속이 이루어지면 
클라이언트가 D드라이브의 D_OTHER 폴더에 있는  '펭귄.JPG'파일을 
서버로 전송하면 서버는 이 데이터를 받아서
D드라이브의 D_OTHER폴더에 있는 down 폴더에 '펭귄_전송본.jpg'로 저장한다

서버 : 소켓으로 입력받아서 파일로 출력
클라이언트 : 파일로 입력받아서 소켓으로 출력
*/

/*클라이언트가 D드라이브의 D_OTHER 폴더에 있는  '펭귄.JPG'파일을 
서버로 전송*/
public class TcpFileClient {
	private Socket socket;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	
	public void clientStart() {
		
		File file = new File("d:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getName()+"가 없습니다");
			System.out.println("파일 전송 작업을 중단합니다");
		return;
		}
		
		try {
			socket = new Socket("localhost",7777);
			System.out.println("파일 전송 시작...");  
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(
				  socket.getOutputStream()	
					);
			
			byte[] temp = new byte[1024];
			int len =  0;          //읽어온개수
			//파일 내용을 읽어와 소켓으로 출력한다
			while((len = bis.read(temp))>0) {
				bos.write(temp,0,len);
			}
			bos.flush();
			System.out.println("파일 전송 완료...");
		
		} catch (IOException e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
			
		}finally {
			if(bos!=null)try {bos.close();} catch(IOException e) {}
			if(bis!=null)try {bis.close();} catch(IOException e) {}
			if(socket!=null)try {socket.close();} catch(IOException e) {}
		}	
	}
	public static void main(String[] args) {
		new TcpFileClient().clientStart();

	}
}
