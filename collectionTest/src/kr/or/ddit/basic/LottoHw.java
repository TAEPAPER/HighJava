package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LottoHw { //내가 한것!!

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int money=0;
		int moneyRest=0;
		int lottoPrice = 1000;
		HashSet<HashSet<Integer>> lotto = new HashSet<HashSet<Integer>>();
		while(true) {
		System.out.println("==========================");
		System.out.println("로또 프로그램");
		System.out.println("--------------------------");
		System.out.println("1.Lotto구입\n2.프로그램종료");
		System.out.println("==========================");
		System.out.print("메뉴선택>");
		int input = sc.nextInt();
		if(input ==1) {
			System.out.println("Lotto구입 시작");
			System.out.println("1000원에 로또번호 하나입니다");
			System.out.print("금액 입력>");
			money = sc.nextInt();
			if(money<1000) {System.out.println("입력금액이 너무 적습니다.로또번호 구입실패!!!");continue;}
			if(money>100000) {System.out.println("입력금액이 너무 많습니다.로또번호 구입실패!!!");continue;}
			int	count = money/lottoPrice;
			for(int i =0; i<count; i++) {
				HashSet<Integer> lo = new HashSet<Integer>();
				while(lo.size()<6) {
					lo.add((int)(Math.random()*45+1));
				}
				lotto.add(lo);
			}
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(HashSet<Integer> lo : lotto) {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.addAll(lo);
				list.add(list2);
			}//각각을 정렬해주기
			
			for(ArrayList<Integer> li : list) {
				Collections.sort(li);
			} 
			//출력하기
			int comma =1;
			for(int i =0; i<list.size(); i++) {
				System.out.print("로또넘버"+(i+1)+": ");
				for(int j=0; j<list.get(i).size();j++) {
					if(comma<=5) {
						System.out.print(list.get(i).get(j)+",");
						comma++;
					}else {
						System.out.println(list.get(i).get(j));
					}
				}
				comma =1;
			}
			moneyRest = money - 1000*count;
			System.out.println("받은금액은 "+money+"이고 거스름돈은 "+moneyRest+"입니다");
		}else {
			System.out.println("시스템을 종료합니다");
			System.exit(0);
		}
		}
		

	
	
	
	
	
	}

}
