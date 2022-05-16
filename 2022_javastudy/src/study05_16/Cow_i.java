package study05_16;

public class Cow_i {
	
	public void sound(int times)
	{
		for(int i=0;i<times;i++)
		{
			System.out.println("음메~");
		}
	}
	
	public void eat(String food)
	{
		System.out.println("소가 "+food+"를 먹는다");
	}
}
