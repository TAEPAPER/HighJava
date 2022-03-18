package RegisterMail;

import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class exampleMail {
	
	public static void main(String[] args) throws EmailException {
		Scanner sc = new Scanner(System.in);
		int rnd = (int)(Math.random()*999999+100000);
		String num = Integer.toString(rnd);
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.naver.com"); //SMTP의 서버를 지정
		email.setSmtpPort(465); // SMTP 서버의 포트주소를 지정
		email.setAuthenticator(new DefaultAuthenticator(IdPw.id,IdPw.pw)); // 보낼사람인증
		email.setSSLOnConnect(true); // SSL보안인증 활성화
		System.out.println("본인인증을 완료할 이메일 주소를 입력해주세요.");
		String mailAddr = sc.next();
		email.setFrom(mailAddr); // 보내는사람의 메일주소
		email.setSubject("본인인증 확인 메일"); // 보낼메일제목
		email.setMsg("본인인증을 위한 번호 " + num + " 입니다.");// 보낼메일 내용
		email.addTo(mailAddr); // 메일을 받는사람의 주소
		email.send();
		System.out.println("이메일 전송완료!");
		System.out.println("전송된 이메일 내용의 숫자를 입력해주세요.");
		String check = sc.next();
		if(check.equals(num)) {
			System.out.println("이메일 인증이 완료되었습니다.");
			System.out.println("회원가입 완료!");
		}else {
			System.out.println("이메일 인증에 실패하였습니다.");
			System.out.println("회원가입 실패...");
		}
	}
}
