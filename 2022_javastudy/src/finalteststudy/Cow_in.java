package finalteststudy;

public class Cow_in implements Animal_in{
	
	public void sound(int time)
	{
		for(int i=1;i<=time;i++)
		{
			System.out.println("����");
		}
	}
	
	public void eat(String food)
	{
		System.out.println(food+"�� �Խ��ϴ�");
	}


}
