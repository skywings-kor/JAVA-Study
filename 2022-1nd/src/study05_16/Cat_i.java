package study05_16;

public class Cat_i implements IMyinterface{
	public void eat(String food) {
		System.out.println("고양이가"+food+"를 먹는다");
	}
	
	
	public void sound(int times)
	{
		for(int i=0;i<times;i++)
		{
			System.out.println("야옹~");
		}
		
	}
	
}


// 개발코드-> ExRun 
// 구현객체(안의 객체)-> Cat_i,Cow_i 임

//구현 객체를 생성하는 클래스=구현클래스	