package study05_02;

public class Cat extends Animal{
	
	public Cat(String name)
	{
		super(name);
	}
	
	@Override
	public void eat()
	{
		System.out.println(this.name+"��(��) ��⸦ �Խ��ϴ�");
	}
	
	public void sound()
	{
		super.sound();
		System.out.println(this.name+"��(��) �߿��ϰ� ��ϴ�");
	}
	
	
	
	
}
