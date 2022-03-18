package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setNum(2);
//		p2.setName("이순신");
		
		
		p2.setNum(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
		System.out.println(p1.equals(p2)); //트루!!!!@#!#!#!#!
		
		HashSet<Person> testSet = new HashSet<Person>();  //중복불가
		testSet.add(p1);
		testSet.add(p3);
		
		System.out.println("Set의 사이즈 : "+testSet.size()); //중복된것은 들어가지 않는다
		testSet.add(p2);
		System.out.println("Set의 사이즈 : "+testSet.size()); //왜 두개가 나오는가? 
		System.out.println("p1 :"+p1.hashCode());
		System.out.println("p2 :"+p1.hashCode());
		System.out.println("p3 :"+p1.hashCode());
		
		
	/*
	 *  - equals()	==> 두 객체의 내용이 같은지 검사하는 메서드
	 *  - hashcode() ==> 두 객체의 동일성을 검사하는 메서드
	 *  HashSet, HashTable,HashMap과 같이 Hash로 시작하는 컬렉션 객체들은 객체의 의미상의 동일성을 비교하기 위해서
	 *  equals()와 hashCode()메서드를 호출해서 비교한다.
	 *  그러므로, 객체가 같은지 여부를 결정하려면 equals()메서드 뿐만 아니라 HashCode()메서드도 재정의 해야한다.
	 *  
	 *  
	 *  과제 : 쓰레드 예습해오기!!!
	 */
		
		
	}
}
class Person { 
	private int num;
	private String name;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	
//	@Override   //ctrl+space 
/*	public boolean equals(Object obj) {
		if(this == obj) { //참조값(주소값)비교
			return true;	
		}
		if(obj ==null) { 
			return false;
		}
		if(this.getClass()!=obj.getClass()) {
			return false ;   			// getClass() --클래스 종류가 무엇인지 나타냄
		}
		//매개변수값을 현재 객체 유형으로 형변환 한다.
		Person that = (Person)obj;
		if(this.name ==null && that.name !=null) {
			return false;
		}if(this.num == that.num && this.name ==  that.name) {
			return true;
		}
		if(this.num == that.num &&this.name.equals(that.name)) {
			return true;
		}
	return false;
	}
	
	*/
	
}