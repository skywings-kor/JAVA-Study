package study05_16;

public class Cat_i implements IMyinterface{
	public void eat(String food) {
		System.out.println("����̰�"+food+"�� �Դ´�");
	}
	
	
	public void sound(int times)
	{
		for(int i=0;i<times;i++)
		{
			System.out.println("�߿�~");
		}
		
	}
	
}


// �����ڵ�-> ExRun 
// ������ü(���� ��ü)-> Cat_i,Cow_i ��

//���� ��ü�� �����ϴ� Ŭ����=����Ŭ����	