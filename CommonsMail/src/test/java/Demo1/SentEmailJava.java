package Demo1;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SentEmailJava { // commons-mail

	public static void main(String[] args) throws EmailException {
		System.out.println("메일 보내기 시작...");
		Email email = new SimpleEmail();
		email.setHostName("smtp.naver.com");// SMTP의 서버 지정
		email.setSmtpPort(465); // SMTP의 포트주소 지정
		email.setAuthenticator(new DefaultAuthenticator(IdPw.id, IdPw.pw));
		email.setSSLOnConnect(true); // SSL 보안인증 활성화
		email.setFrom("com32415674@naver.com"); // 보내는 사람 메일
		email.setSubject("TestMail"); // 메일 제목
		email.setMsg("This is a test mail  :-)"); // 메일 내용
		email.addTo("com32415674@naver.com"); // 받는 사람 주소
		email.send(); // 보내기

		System.out.println("메일 보내기 완료!!!");
	}

}
