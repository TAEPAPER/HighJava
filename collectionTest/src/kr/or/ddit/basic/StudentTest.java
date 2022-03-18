package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  문제) 학번,이름(String), 국어점수, 영어점수, 수학점수,총점,등수를 멤버로 갖는 Student클래스를 만든다
  	   이 Student클래스의 생성자에서는 학번, 이름, 국어점수,영어점수,수학점수만 매개변수로 받아서 초기화한다.
       이 클래스는 학번의 오름차순으로 정렬할 수 있는 내부정렬기준을 구현한다.
       
       이 Student객체는 List에 저장하여 관리한다
       
       List에 저장된 Student객체를 총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이되는
        외부 정렬 기준클래스도 작성하시오.
       
       (단, 등수는 List에 전체 데이터가 모두 저장된 후에 구한다    
 */

public class StudentTest {
 //등수를 구하는 메서드
	public  void setRanking(ArrayList<Student> stuList) {
		for(Student stu1 : stuList) { //기준이 되는 데이터를 위한 반복문(등수를 구할 값)
			int rank = 1;    //처음에는 등수를 1로 초기화한다.
			//비교 대상을 찾기위한 반복문
			for(Student stu2 : stuList) {
				//기준보다 큰 값을 만나면 rank값을 증가시킨다
				if(stu1.getSum()<stu2.getSum()) {
					rank++;
				}
			}
			//구해진 등수를 Student객체의 rank변수에 저장한다
			stu1.setRank(rank);
		}
	}

	public static void main(String[] args) {
		StudentTest test = new StudentTest();
		
		
		ArrayList<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student(24,"김기웅",80,70,55));
		stuList.add(new Student(45,"박태정",55,23,65));
		stuList.add(new Student(14,"이정규",57,46,89));
		stuList.add(new Student(7,"오지현",55,70,80));
		stuList.add(new Student(88,"김자바",87,76,84));
		test.setRanking(stuList); //등수를 구하는 메서드로 하심!

//			내가 한것!
//          for(int i =0; i<stuList.size(); i++) {
//			stuList.get(i).rank =1;
//			for(int j = i+1; j<stuList.size();j++) {
//				if(stuList.get(i).sum <stuList.get(j).sum) {
//					stuList.get(i).rank++;
//				}
//			}	
//		}
		System.out.println("정렬전");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		
		//학번의 오름차순으로 정렬하기
		System.out.println("학번정렬");
		Collections.sort(stuList);
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		
		//총점이 같을 때 이름의 오름차순으로 하기
		Collections.sort(stuList, new SortStuNumDesc());
		System.out.println("총점 같을 때 이름 오름차순");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
	}
}
class Student implements Comparable<Student>  {

	int StuNum;
	String name;
	int korean;
	int english;
	int math;
	int sum;
	int rank;
	
	
	Student(int StuNum, String name, int korean,int english, int math ){ //생성자
		super();
		this.StuNum = StuNum;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		sum = korean + english + math;
	
	}
	public int getStuNum() {
		return StuNum;
	}
	public void setStuNum(int stuNum) {
		StuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
	
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Student [StuNum=" + StuNum + ", name=" + name + ", korean=" + korean + ", english=" + english
				+ ", math=" + math + ", sum=" + sum + ", rank=" + rank + "]";
	}

	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Student stu) {  //학번 오름차순 내부정렬 기준
		if(StuNum >stu.getStuNum()) {
			return 1;
		}else if(StuNum <stu.getStuNum()) {
			return -1;
		}else {
			return 0;
		}
		//return Integer.compare(StuNum, stu.getNum());
	}
}


class SortStuNumDesc implements Comparator<Student>{

	//List에 저장된 Student객체를 총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이되는
    //외부 정렬 기준클래스도 작성하시오.
	
	
	@Override  
	public int compare(Student stu1, Student stu2) {
			if(stu1.getSum()> stu2.getSum()) {  //내림차순 
				return -1;
			}else if(stu1.getSum()< stu2.getSum()) {
				return 1; //바꿔
			}else if(stu1.getSum() == stu2.getSum()) {
				if(stu1.getName().compareTo(stu2.getName())<0) {
					return -1;
					
					//return stu1.getName().compareTo(stu2.getName());
				}else {
				return 1;
				// return Integer.compare(stu1.getSum(), stu2.getSum())*-1;
				}
			  }else {
		      return 0;
			}
			
	}

}


