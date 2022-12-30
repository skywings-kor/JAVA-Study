package study04_18;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student s1= new Student("홍길동","충남 아산시","남","010-6969-6969","컴퓨터공학", "2019292929","4");
		
		s1.print();
		
		String s=s1.gender;
		
		Membership m1= new Membership("홍길동","충남아산시","남","010-9696-8686","프로그래머","영화감상");
		m1.print();
		
	}
	
}

