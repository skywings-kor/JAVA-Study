package study05_30;

public class Person {
	//int countOfInstance;		//�ʱⰪ�� 0�� //�̷��� �ϸ� ���� �ϳ��� ��������� ī��Ʈ�Ǽ� �߸���
	static int countOfInstance;
	
	String name;
	
	public Person(String name)
	{
		this.name=name;
		countOfInstance++;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCount()
	{
		return   countOfInstance;
	}
	
	
}
