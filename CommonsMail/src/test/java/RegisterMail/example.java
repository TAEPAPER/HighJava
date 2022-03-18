package RegisterMail;

import java.util.Scanner;

import org.apache.commons.mail.EmailException;

public class example {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws EmailException {
		
		System.out.println("====================회원가입==================");
		System.out.println("사용하실 아이디를 입력해주세요.");
		String id = sc.next();
		System.out.println("사용하실 비밀번호를 입력해주세요.");
		String password = sc.next();
		System.out.println("사용자의 이름을 입력해주세요");
		String name = sc.next();
		exampleMail.main(args);
	}
}
