package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		//싱글 쓰레드 프로그램 (순차적으로 실행이된다)
		for(int i =1; i<=200; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		for(int i =1; i<=200; i++) {
			System.out.print("$");
		}
		
		
		
		

	}

}
