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
		System.out.println(this.name+"가(이) 먹이를 먹습니다");
	}
	
	public void sound()
	{
		System.out.println(this.name+"가(이) 울부짓습니다");
	}
	
}
