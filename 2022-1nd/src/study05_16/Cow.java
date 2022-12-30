package study05_16;

public class Cow extends Animal{
	
	@Override
	public void eat()
	{
		System.out.println("풀을 먹는다");
	}
	
	@Override
	public void sound()
	{
		System.out.println("음매~");
	}
}
