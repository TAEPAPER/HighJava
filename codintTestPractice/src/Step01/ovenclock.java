package Step01;

import java.util.Scanner;

public class ovenclock {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("시");
		int A = sc.nextInt(); //시
		System.out.println("분");
		int B = sc.nextInt(); //분
		System.out.println("오븐시간");
		int C = sc.nextInt(); //요리하는데 필요한 시간
		
		B += C;
		if(B >60) {
			int count=0;
			do {
				B = B-60;
				count++;
			}while(B>=60);
			A = A+count;
		}else if(B == 60) {
				B = 0;
				A++;
			}
		if(A == 24) A = 0;
		if(A >24) {
			A = A-24;
		}
		System.out.println(A + " "+ B);
		
		
		}

}
