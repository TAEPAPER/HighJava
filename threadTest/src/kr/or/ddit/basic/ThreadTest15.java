package kr.or.ddit.basic;

public class ThreadTest15 {
	public static void main(String[] args) {
    ShareObject sObj = new ShareObject();
    TestThread th1 = new TestThread("test1", sObj);
    TestThread th2 = new TestThread("test2", sObj);
    th1.start();
    th2.start();
	}
}
//테스트 쓰레드
class TestThread extends Thread{
	
	private ShareObject sObj;
    public TestThread(String name, ShareObject sObj) {
    	super(name);  //쓰레드의  name 설정
    	this.sObj = sObj;
    }
	@Override
	public void run() {
		for(int i =1; i<=10; i++) {
			sObj.add();
		}
	}   
}
//공통으로 사용할 클래스
class ShareObject{
	private int sum = 0;
	/*동기화 하기  ==> synchronized를 이용해서 처리한다.
	 방법 1 ==> 메서드 자체에 동기화 설정을 하는 방법
			public synchronized void add(){
				처리할 내용들...
			}
	 방법 2 ==> 동기화 블럭으로 설정하는 방법
			public void add(){
			    synchronized(동기화할 객체){
			    처리할 내용들...}			
			    }
	 */
	         
	//방법 1
	//public synchronized void add() { //보호망느낌?(2번쓰레드가 진입을 못해) 1번쓰레드가 다 끝나면 그 때 보호망을 풀어준다.
	public void add() {
	synchronized (this) { //방법 2
	int n = sum;
		n+= 10;
		sum = n;
		System.out.println(Thread.currentThread().getName()
				+ "합계 : "+ sum);
		}
	}
}
