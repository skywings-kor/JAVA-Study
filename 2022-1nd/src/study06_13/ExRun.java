package study06_13;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1=null;

		//�̻��·� ����Ұ��-�����߻�
//		String str2;
//		System.out.println(str2);

		//�׷��� �̷��� ���� �־��ٰ��-toString ���ڿ� ��ü�� ������� �����ϴ°ǵ� �� �� ���°�,
		//�ֳ��ϸ� null���� ������ �ֱ� �����̴�.
		//�ͼ��� �ڵ� �޺κ� ������ �ȳ����� ������ �ͼ��� ����� �κп��� �����Ϸ���
//		//�ߴ��߱� �����̴�.
//		String str2=null;
//		System.out.println(str2.toString());
//		System.out.println("�ͼ��� �ڵ� �޺κ�");
		
		
		//�迭 �ͼ��� ���� ü��
		int[] myInt=new int[5];
		myInt[0]=1;
		myInt[1]=2;
		myInt[2]=3;
		myInt[3]=4;
		myInt[4]=5;
		
		//�̷��� �ᵵ �� ���� ���𸻰�
		//int[] my=new int[] {1,2,3,4,5};
		//�ڹ� �ͼ��ǿ� ���� �κ��� ����ǰ� �˷���
//		System.out.println(myInt[4]);
//		System.out.println("�ͼ��� �ڵ� �� �κ�");
//		
		
		//try�� �ͼ����� ����ų �� �ִ� ���� ��� �����ϴ� ������ �ϰ� ��
		try {
//			System.out.println(myInt[6]);
//			System.out.println("Ʈ���� �Ʒ� ����!");
			System.out.println(str1.toString());
			//���� �κ��� ���� ���Ѽ� ������ �� ����! ������ Array���ϸ� �迭 ���� �����θ� ĳġ!
			//ArrayIndexOutOfBoundsException
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("�迭 �ͼ��� �߻�!");

		}
		
		
		catch(NullPointerException e)//������ �߻��ϴ� �����϶� �� �ȿ� �ִ� �ڵ带 �����Ŵ
		{
			System.out.println("���ڿ� �ͼ��� �߻�!!");
			
			//���� �ڵ带 ������!
			String msg=e.getMessage();
			System.out.println(msg);
			e.printStackTrace();
			
		}
		
		//�̰� ��ü�� �̰� ���� �θ� �̰͸� ����Ǽ� ��ü �˻��ϴ� ���� �� �Ʒ��� �ξ����
		catch(Exception e)
		{
			System.out.println("�� �� ���� �����Դϴ�!");
		}
		
		finally
		{
			//�ͼ��� �߻� ���ο� ������� �׻� ����Ǿ�� �� �ڵ�
			//���� ���ҽ� ��ȯ ������ �ۼ�
			
		}
		
		System.out.println("�ͼ��� �ڵ� �� �κ�");
		
		
	}

}
