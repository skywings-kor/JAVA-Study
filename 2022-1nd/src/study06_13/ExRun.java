package study06_13;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1=null;

		//이상태로 출력할경우-오류발생
//		String str2;
//		System.out.println(str2);

		//그래서 이렇게 값을 넣어줄경우-toString 문자열 객체를 대상으로 실행하는건데 할 수 없는거,
		//왜냐하면 null값을 가지고 있기 때문이다.
		//익셉션 코드 뒷부분 문장이 안나오는 이유는 익셉션 생기는 부분에서 컴파일러가
//		//중단했기 떄문이다.
//		String str2=null;
//		System.out.println(str2.toString());
//		System.out.println("익셉션 코드 뒷부분");
		
		
		//배열 익셉션 에러 체험
		int[] myInt=new int[5];
		myInt[0]=1;
		myInt[1]=2;
		myInt[2]=3;
		myInt[3]=4;
		myInt[4]=5;
		
		//이렇게 써도 됨 위에 선언말고도
		//int[] my=new int[] {1,2,3,4,5};
		//자바 익셉션에 오류 부분이 저장되고 알려줌
//		System.out.println(myInt[4]);
//		System.out.println("익셉션 코드 뒷 부분");
//		
		
		//try로 익셉션이 일으킬 수 있는 것을 묶어서 감시하는 역할을 하게 됨
		try {
//			System.out.println(myInt[6]);
//			System.out.println("트라이 아래 구문!");
			System.out.println(str1.toString());
			//오류 부분을 한정 시켜서 실행할 수 있음! 저렇게 Array로하면 배열 관련 오류로만 캐치!
			//ArrayIndexOutOfBoundsException
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("배열 익셉션 발생!");

		}
		
		
		catch(NullPointerException e)//오류를 발생하는 구문일때 이 안에 있는 코드를 실행시킴
		{
			System.out.println("문자열 익셉션 발생!!");
			
			//오류 코드를 보여줌!
			String msg=e.getMessage();
			System.out.println(msg);
			e.printStackTrace();
			
		}
		
		//이건 전체라서 이걸 위에 두면 이것만 실행되서 전체 검사하는 것은 맨 아래에 두어야함
		catch(Exception e)
		{
			System.out.println("알 수 없는 오류입니다!");
		}
		
		finally
		{
			//익셉션 발생 여부와 관계없이 항상 실행되어야 할 코드
			//보통 리소스 반환 구문을 작성
			
		}
		
		System.out.println("익셉션 코드 뒷 부분");
		
		
	}

}
