package kr.or.ddit.basic.args;

public class ArgsTest {  //클래스
	//메서드를 호출할 때 사용되는 데이터의 개수가 실행될 때마다 다를 때...
	
	
	// 1.배열을 이용한 메서드
	// 예) 매개변수로 받은 정수들의 합계를 구하는 메서드
	//    (이 정수들의 개수는 상황에 따라 다르다.)
	public int sumArr(int[] data) { //배열을 파라미터로 받아서 구하는 메서드
		
		int sum =0;
		for(int i =0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	//가변형 인수 ==>메서드의 매기변수의 개수가 실행될 때마다 다를 때 사용한다
	// - 가변형 인수에 사용되는 매개변수는 메서드 안에서 배열로 처리된다.
	// - 가변형 인수는 한가지 자료형만 사용할 수 있다.
	// - 가변형 인수를 제일 뒤쪽에 배치해야한다
	public String sumArgs2(String name, int...data) {
		int sum = 0;
		for(int i =0; i<data.length; i++) {
			sum += data[i];
		}
		return name + "씨 총점 : "+sum;
	}
	
	public int sumArg(int...data/*,float...date2 (가변형인수는 한가지만 쓸 수 있다)*/) {

		int sum =0;
		for(int i =0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {

		ArgsTest test = new ArgsTest();
		int[] nums = {100,200,300};
		
		System.out.println(test.sumArr(nums));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5,6})); //데이터를 직접 넘겨줄 때!
		System.out.println("-------------------------------------------");
		
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		System.out.println(test.sumArgs2("홍길동", 1,2,3,4,5,6,7));
	

	}

}
