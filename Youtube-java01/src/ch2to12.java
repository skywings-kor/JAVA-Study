
public class ch2to12
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(10.0/3);		//나눈 값을 실수로 얻으려면 한쪽이 .0 이렇게 실수여야 가능함
		
//		System.out.printf("%d%n",15);
//		System.out.printf("%#o%n",15);
//		System.out.printf("%#x%n",15);
//		System.out.printf("%s",Integer.toBinaryString(15));	//2진 문자로 바꿔주는거 15-> 1111
//		
//		double f=123.456789;
//		System.out.printf("%f\n",f);
//		System.out.printf("%e\n",f);		//지수 형태로 값 출력
		
		
		System.out.printf("[%5d]%n",10);		//왼쪽정렬
		System.out.printf("[%-5d]%n",10);		//오른쪽정렬
		System.out.printf("[%05d]%n",10);		//오른쪽정렬 나머지 0으로채움
		System.out.printf("[%5d]%n",1234567);
		
		double d=1.23456789;
		System.out.printf("%.6f\n",d);		//총 14자리, 뒤에는 10자리 나오게
		
		System.out.printf("[%s]\n","www.codechobo.com");
		System.out.printf("[%20s]\n","www.codechobo.com");
		System.out.printf("[%-20s]\n","www.codechobo.com");
		System.out.printf("[%.10s]\n","www.codechobo.com");	//10자리 까지만 출력
		
	
	}

}
