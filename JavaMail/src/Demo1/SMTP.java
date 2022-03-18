package Demo1;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP {

	public static void sendMail(String recepient) {
		/*
		 * Property에 SMTP서버의 정보를 설정함 ※사용하는 이메일 계정에서 SMTP 사용에 대한 허용도 꼭 해줘야함 
		 * Properties :
		 * Properties 클래스는 Hashtables의 하위 클래스 [Key,Value] HashMap과 큰 차이가 없지만, 
		 * Properties 클래스는 파일 입출력을 지원한다
		 * 
		 * 
		 *  javax.mail.AuthenticationFailedException이 발생하는 것은 아래와 같이 보안 수준이 낮은 앱 허용을 해주지 않아서 발생하게 됩니다. 
		 *	구글/네이버 -> 보안에 들어가서 가장 하단에 허용함을 변경
		 * 
		 */
		System.out.println("Prepare to send email"); // SMTP :이메일을 전송하기 위해서 사용되는 통신규약 , 메일을 전송하는 경우에 사용

		Properties properties = new Properties(); // Properties 객체 생성
		properties.put("mail.smtp.auth", "true"); // 사용자 인증 사용여부 (true : id/pw 사용)
		properties.put("mail.smtp.starttls.enable", "true"); // TLS 보안인증 활성화 :인터넷에서 데이터를 안전하게 전송하기 위한 인터넷 통신 규약 프로토콜
		properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP의 주소 
		properties.put("mail.smtp.port", "587"); // TLS 통신을 할 포트 [네이버 : 587 | 구글 : 587 /465 ]

		final String myAccountEmail = IdPw.id;// 발신자의 메일계정
		final String password = IdPw.pw; // 발신자의 메일 비밀번호

		/*
		 * Session : 
		 * 클라이언트와 서버의 연결 정보를 유지하게 하는 것  mail api에 의해 사용된 값과 properties에 대한 정보를 저장
		 * Session을 message관련 객체에 파라미터로 넘겨줘서 메일 전송 진행 
		 * SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성해주기
		 */
		Session session = Session.getInstance(properties, new Authenticator() {
			// new Authenticator() : user name과 password가 필요한 경우에 어플리케이션에 호출해주는 객체

			@Override // 비밀번호 승인이 필요할 때 호출된다
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		// Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한 한다.
		Message message = prepareMessage(session, myAccountEmail, recepient);

		try {
			// 아래의 메서드에서 리턴받은 message를 transport 클래스를 사용하여 메일 전송
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println("Message Sending fail..."); // 메일 전송 실패시 출력
			e.printStackTrace();
		}
		System.out.println("Message Sending sucessfully"); // 메일전송이 성공적으로 완료되면 출력
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		// 세션과 발신자의 메일과 보낼 사용자의 메일주소

		Message message = new MimeMessage(session); // javax.mail에서 제공하는 MimeMessage를 생성
		try {
			message.setFrom(new InternetAddress(myAccountEmail)); // 발신자의 메일계정 지정
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient)); // 수신자 메일 주소지정
			message.setSubject("안녕하세요"); // 메일 제목지정
			message.setText("javax.mail을 통해서 메일 보냅니다~"); // 메일 내용지정
			return message; // 메세지를 리턴.
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {

			e.printStackTrace();
		}
		return null;
	}

}
