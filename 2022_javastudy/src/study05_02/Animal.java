package study05_02;

public class Animal {
	String name;
	String color;
	boolean hasTail;
	
	public Animal(String name)
	{
		this.name=name;
	}
	
	public void eat()
	{
		System.out.println(this.name+"��(��) ���̸� �Խ��ϴ�");
	}
	
	public void sound()
	{
		System.out.println(this.name+"��(��) ��������ϴ�");
	}
	
}
