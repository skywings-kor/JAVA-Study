
public class ch2to12
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(10.0/3);		//���� ���� �Ǽ��� �������� ������ .0 �̷��� �Ǽ����� ������
		
//		System.out.printf("%d%n",15);
//		System.out.printf("%#o%n",15);
//		System.out.printf("%#x%n",15);
//		System.out.printf("%s",Integer.toBinaryString(15));	//2�� ���ڷ� �ٲ��ִ°� 15-> 1111
//		
//		double f=123.456789;
//		System.out.printf("%f\n",f);
//		System.out.printf("%e\n",f);		//���� ���·� �� ���
		
		
		System.out.printf("[%5d]%n",10);		//��������
		System.out.printf("[%-5d]%n",10);		//����������
		System.out.printf("[%05d]%n",10);		//���������� ������ 0����ä��
		System.out.printf("[%5d]%n",1234567);
		
		double d=1.23456789;
		System.out.printf("%.6f\n",d);		//�� 14�ڸ�, �ڿ��� 10�ڸ� ������
		
		System.out.printf("[%s]\n","www.codechobo.com");
		System.out.printf("[%20s]\n","www.codechobo.com");
		System.out.printf("[%-20s]\n","www.codechobo.com");
		System.out.printf("[%.10s]\n","www.codechobo.com");	//10�ڸ� ������ ���
		
	
	}

}
