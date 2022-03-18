package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제2) 5명의 별명을 입력받아  ArrayList에 저장하고 
 *        별명의 길이가 가장 긴 별명을 출력하시오
 *       단, 별명의 길이가 같은 것을 입력할 수 있다
 */
public class ArrayListTest04 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i =0; i<5; i++) {
			System.out.println( i+1 + "번째 별명 입력>");
			String input = sc.nextLine();
			list.add(input);
		}
		
	    //제일 긴 별명의 길이가 저장될 변수 선언
		// ==>첫번째 별명의 길이로 초기화한다
		int maxLength = list.get(0).length();
		for(int i =1 ; i<list.size(); i++) {
			if(maxLength < list.get(i).length()) {
			   maxLength = list.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for(String str : list) {
			if(str.length()== maxLength) {
				System.out.println(str);
			}
		}
		
		
		

	}

}
