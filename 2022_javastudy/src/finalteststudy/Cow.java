package finalteststudy;

public class Cow extends Animal{
	
	@Override
	public void eat()
	{
		System.out.println("소가 풀을 먹는다");
	}
	
	@Override
	public void sound()
	{
		System.out.println("음메~");
	}
}
