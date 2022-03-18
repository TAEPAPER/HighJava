//package kr.or.ddit.basic;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///*
// *  10마리의 말들이 경주하는 경마 프로그램 작성하기
// *  
// *   말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 
// *   이 클래스는 말이름(String), 등수(int), 현재위치(int)로 멤버변수로 갖는다.
// *   그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부정렬이 있다.
// *   (Compare인터페이스 구현)
// *   
// *   경기 구간은 1~50 구간으로 되어있다.
// *   **경기가 끝나면 등수 순으로 출력**한다
// *   경기가 진행 중일때는 중간 중간에 말들의 위치를 아래와 같이 나타낸다.
// *   예)
// *   01번말 :--->-------------------------------
// *   02번말 :------>----------------------------

// *    :
// *   10번말 :---->------------------------------
// *   
// */
//
//
//public class ThreadTest13Me { //내가 한것!
//   public static List<HorseM> hs ;
//
//	public static void main(String[] args) {
//		hs = new ArrayList();
//		hs.add(new HorseM("1번말"));
//		hs.add(new HorseM("2번말"));
//		hs.add(new HorseM("3번말"));
//		hs.add(new HorseM("4번말"));
//		hs.add(new HorseM("5번말"));
//		hs.add(new HorseM("6번말"));
//		hs.add(new HorseM("7번말"));
//		hs.add(new HorseM("8번말"));
//		hs.add(new HorseM("9번말"));
//		hs.add(new HorseM("10번말"));
//		// 쓰레드 시작
//		
//		for (HorseM h : hs) {
//			h.start();
//		}
//		//중간 중간에 출력해주기
//	Outer : while(true) {
//		for(int i =0; i< hs.size(); i++) {
//			System.out.print(hs.get(i).name +":");
//			for(int j =1; j<=50; j++) {
//		      if(hs.get(i).place==j) {
//		    	  System.out.print(">");
//		      }else {
//		    	  System.out.print("-");
//		      } 
//		    }
//			System.out.println();
//		}
//		System.out.println("************************************************************");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//		int count =0;	
//		for(HorseM h : hs) {
//			Thread.State state = h.getState();
//			if(state == Thread.State.TERMINATED) {
//				count++;
//			}
//		}
//		if(count == hs.size()) {
//			break Outer;
//		}
//	}
//		 //모든 사람의 출력이 끝날 때까지 기다린다
//		for (HorseM h : hs) {
//			try {
//				h.join();
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//		for(int i =0; i<hs.size(); i++) {
//			for(int j=0 ;j<hs.size(); j++) {
//				if(hs.get(i).time>hs.get(j).time) {
//					    hs.get(i).rank++;
//				}
//			  }
//			}
//		System.out.println();
//		System.out.println(" 최종경기결과 (등수순으로 출력)");
//		Collections.sort(hs); //내부정렬
//		for(HorseM h : hs) {
//			System.out.println(h);
//		}
//	}
//}
//		//말에 관한 쓰레드
//class HorseM extends Thread  implements Comparable<Horse> {
//	String name; // 말이름
//	int rank =1 ; // 말 등수
//	int place; // 현재위치
//	long time;
//	
//	public HorseM(String name) {
//		this.name = name;
//	}
//	@Override
//	public void run() {
//		// 말의 위치를 랜덤으로 설정해주는 것
//	 long startTime = System.currentTimeMillis();
//		for ( int i = 1; i <= 50; i++) {
//			place = i;
//			try {
//				Thread.sleep((int) (Math.random()*500));
//			} catch (InterruptedException e) {
//			}		
//		}
//		long endTime = System.currentTimeMillis();
//		time = (endTime - startTime);
//		System.out.println(name+"이 들어왔습니다");
//		return;
//	}
//	@Override//등수를 오름차순으로 처리 //그냥 원래대로 하면된다
//	public int compareTo(HorseM h) {
//		return Integer.compare(rank, h.rank);
//	}
//	@Override
//	public String toString() {
//		return "[name=" + name + ", rank=" + rank +"]";
//	}
//	@Override
//	public int compareTo(Horse o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//}
//
//
//
//
//
