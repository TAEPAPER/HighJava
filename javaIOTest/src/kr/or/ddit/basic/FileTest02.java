package kr.or.ddit.basic;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		File f1 = new File("d:/d_other/test.txt");
		
		System.out.println(f1.getName()+ "의 크기 :"+ f1.length()+"bytes");
		System.out.println("path : "+ f1.getPath()); //객체 생성할 때 지정한 경로가 그냥 path
		System.out.println("absolutpath : " + f1.getAbsolutePath()); //절대경로
		System.out.println();
		File f2 = new File(".");
		System.out.println();
		System.out.println("path : "+ f2.getPath()); //객체 생성할 때 지정한 경로가 그냥 path
		System.out.println("absolutepath : " + f2.getAbsolutePath()); //절대경로
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
