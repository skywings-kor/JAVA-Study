package java_ppt;

public class Extends_study_ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Extends_study_Student user1=new Extends_study_Student("홍길동","충남","남","010-1111-1111","컴공","20192929","3");
		Extends_study_Membership user2=new Extends_study_Membership("남남남","충북","여","010-222-222","프로그래머","개발");
		user1.stuprint();
		System.out.println("");
		user2.memberprint();
		
	}

}
