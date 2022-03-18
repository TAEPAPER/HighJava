package kr.or.ddit.basic;

public class PracticeThreadTest14 {
public static void main(String[] args) {
	//공통으로 저장해줄 객체 생성
	 GongTong gt = new GongTong();
	 //원주율 계산하는 쓰레드
	 Calculate c = new Calculate();
	 c.setGt(gt);
	 //원주율 출력하는 쓰레드
	 PrintPI print = new PrintPI(gt);
	 
	 //스타트는 마지막에 해준다!!!
	 c.start();
	 print.start();
	
	
	
	}
}

//원주율을 공통으로 관리하는 클래스
class GongTong {
	private double result; //원주율 결과값을 저장할 변수
	//계산이 완료되었는지 체크하는 변수
	private volatile boolean isOk;
	
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public boolean getOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}	
}

//원주율을 계산하는 쓰레드
class Calculate extends Thread{
	private GongTong gt;
	
	//setter
	public void setGt(GongTong gt) {
		this.gt = gt;
	}
	@Override
	public void run() {
		
		double sum = 0.0;
		for(int i =1; i<=100000000; i++) {
			if((i/2)%2 ==0) {
				sum += 1.0/i;
			}else {
				sum -= 1.0/i;
			}	
		}
		gt.setResult(sum*4); //공통으로 사용될 변수에 넣어준다.
		gt.setOk(true);
	}	
}
//출력해주는 쓰레드
class PrintPI extends Thread{
	private GongTong gt;
	
	//생성자
	public PrintPI(GongTong gt) {
		this.gt = gt;
	}
	
	@Override
	public void run() {
		while(true) {
			if(gt.getOk()) {
				break;
			}
			System.out.println();
			System.out.println("결과 : "+ gt.getResult());
			System.out.println("원주율 : "+ Math.PI);
		
		}
		
		
	}
	
	
	
	
}


