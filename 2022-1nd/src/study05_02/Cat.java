package study05_02;

public class Cat extends Animal{
	
	public Cat(String name)
	{
		super(name);
	}
	
	@Override
	public void eat()
	{
		System.out.println(this.name+"가(이) 고기를 먹습니다");
	}
	
	public void sound()
	{
		super.sound();
		System.out.println(this.name+"가(이) 야옹하고 웁니다");
	}
	
	
	
	
}
