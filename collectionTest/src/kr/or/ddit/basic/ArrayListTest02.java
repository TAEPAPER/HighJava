package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제 ) 5명의 사람이름을 입력받아 ArrayList에 저장한후 이들 중 '김'씨 성의 이름을 모두 출력하시오
 *  (입력은  Scanner 객체를 이용한다)
 */

public class ArrayListTest02 {

	public static void main(String[] args) {
		//리스트에 저장
		ArrayList<String> list  = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		
		//스캐너로 배열에 이름 담기
		int count =0;
		while(count !=5) {
			System.out.println("이름>");
			String input = sc.nextLine();
			list.add(input);
			count++;
		}
		
		//1.charAt 이용하기
		ArrayList<String> KimList = new ArrayList<String>();
		for(String str : list) {
			if(str.charAt(0) == '김') {
				KimList.add(str);
			}
		}
		System.out.println(KimList);
		
		//2.substring이용하기
		for(String str : list) {
			if(str.substring(0,1).equals("김")) {
				System.out.println(str);
			}
		}
	   //3.indexOf 이용하기
		for(String str : list) {
			int index = str.indexOf("김");
			if(index == -1) {
				continue;
			}else {
				System.out.println(str);
			}
		}

		for(String str: list) {
			if(str.indexOf("김") ==0) {
				System.out.println(str);
			}
		}
		
		
		
//			4.contains 이용하기 //**중간이거나 마지막에 있어도 출력이 되기 때문에 안된다!!**
//		for(String str : list) {
//			if(str.contains("김") == true) {
//				System.out.println(str);
//			}
//		}

		//4.startsWith 이용하기
		for(String str: list) {	
			if(str.startsWith("김")==true) {
		System.out.println(str);
			}
	}
	
		
		
		
		

	}

}
