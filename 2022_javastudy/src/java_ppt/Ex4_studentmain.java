package java_ppt;

public class Ex4_studentmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_student user1=new Ex4_student("ȫ�浿","tetet111","�׽��ͺμ�");
		Ex4_student user2=new Ex4_student("�ڱ浿","seses222","�̷��μ�");
		
		user1.printStudentInfo();
		user2.printStudentInfo();
		
		user1.setId("change111");
		user2.setName("changename11");
		user1.printStudentInfo();
		user2.printStudentInfo();
		
		
		
	}
	
	
	
}
