package kr.or.ddit.basic.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		     //MySingleton test1 = new MySingleton(); //외부에서 new 명령으로 생성 불가
			MySingleton test2 = MySingleton.getInstance();
			MySingleton test3 = MySingleton.getInstance();
			//생성자입니다 한번 출력 : 객체가 한번 생성되었다는 뜻~!
			
			
			//같은 값을 참조한다
			System.out.println("test2 ==> "+test2);
			System.out.println("test3 ==> "+test3);
		
			System.out.println(test2 == test3);
			System.out.println(test2.equals(test3));
			
			test2.displayTest();
	}
}
