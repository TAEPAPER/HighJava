package Demo1;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class attachment {
public static void main(String[] args) throws EmailException {
	   System.out.println("=====첨부파일 보내기======");
	
	  EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath("D:/A_TeachingMaterial/05_JQuery/images/spongebob.png");//첨부파일 경로
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  attachment.setDescription("Picture of spongebob"); 
	  attachment.setName("스폰지밥.png"); //파일 이름

	  // Create the email message
	  MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.naver.com"); //SMTP의 서버 지정
		email.setSmtpPort(587);  //SMTP의 포트 지정
		email.setAuthenticator(new DefaultAuthenticator(IdPw.id, IdPw.pw));
		email.setSSLOnConnect(true); //SSL보안인증 활성화
		email.setFrom("com32415674@naver.com"); //보내는 사람 메일 주소
		email.setSubject("TestMail");   //메일 제목
		email.setMsg("This is a test mail ... :-)"); // 메일내용
		email.addTo("com32415674@naver.com");     //받는 사람 메일 주소
	  // add the attachment
	  email.attach(attachment);

	  // send the email
	  email.send();
	  System.out.println("=======첨부파일 보내기 성공===========");
}
}
