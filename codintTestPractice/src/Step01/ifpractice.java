package Step01;

import java.util.Scanner;

public class ifpractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		
		int M = sc.nextInt();
		sc.close();
		
		if(M<45) {
			M = 60-(45-M);
			H--;
			if(H<0) { //ex)0: 20분 
				H=23;
			}
			System.out.println(H + " "+ M);

		}else {
			M = M-45;
			System.out.println(H+" "+M);
			
		}
		
		
	}
}
