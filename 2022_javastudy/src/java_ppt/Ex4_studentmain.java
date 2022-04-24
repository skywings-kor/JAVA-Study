package java_ppt;

public class Ex4_studentmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_student user1=new Ex4_student("홍길동","tetet111","테스터부서");
		Ex4_student user2=new Ex4_student("박길동","seses222","미래부서");
		
		user1.printStudentInfo();
		user2.printStudentInfo();
		
		user1.setId("change111");
		user2.setName("changename11");
		user1.printStudentInfo();
		user2.printStudentInfo();
		
		
		
	}
	
	
	
}
