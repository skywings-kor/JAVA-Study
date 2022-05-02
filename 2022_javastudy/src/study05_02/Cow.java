package study05_02;

public class Cow extends Animal{
	
	public Cow(String name)
	{
		super(name);
	}
	
	public void eat()
	{
		System.out.println(this.name+"가(이) 풀을 먹습니다");
	}
	
	public void sound()
	{
		System.out.println(this.name+"가(이) 음메 하고 웁니다");
	}
	
}
