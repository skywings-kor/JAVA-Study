package study05_02;

public class Cow extends Animal{
	
	public Cow(String name)
	{
		super(name);
	}
	
	public void eat()
	{
		System.out.println(this.name+"��(��) Ǯ�� �Խ��ϴ�");
	}
	
	public void sound()
	{
		System.out.println(this.name+"��(��) ���� �ϰ� ��ϴ�");
	}
	
}
