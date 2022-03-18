package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1)5명의 별명을 입력받아 ArrayList에 저장하고 이 별명 중에 제일 긴 별명을 출력하시오
 * (단, 별명의 길이는 모두 다르게 입력한다)
 * 
 */
public class ArrayListTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i =0; i<5; i++) {
			System.out.println("별명 입력>");
			String input = sc.nextLine();
			list.add(input);
		}
		
//		int max = list.get(0).length();
//		String maxname = list.get(0);
//		for(int i =0; i<list.size(); i++) {
//			for(int j=i+1; j<list.size(); j++) {
//				if(max<list.get(j).length()) {
//					max = list.get(j).length();
//					maxname = list.get(j);
//				}
//			}
//		}
//		System.out.println(maxname);
		
		
		//선생님이 한 것
		String maxAlias = list.get(0);
		for(int i =1 ; i<list.size(); i++) {
			if(maxAlias.length() < list.get(i).length()) {
				maxAlias = list.get(i);
			}
		}
		
		System.out.println(maxAlias);
		
		
		
		
		
	}
}
