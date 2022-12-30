package study05_02;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat animal1=new Cat("고양이");
		Cow animal2=new Cow("소");
		
//		animal1.eat();
//		animal1.sound();
//		
//		animal2.eat();
//		animal2.sound();
//		
//		animal2.eat();
//		animal2.sound();
		
		
		Animal[] animals=new Animal[]
				{
						new Cat("고양이1"),new Cow("소1"),new Cow("소2"),
						new Cat("고양이2"),new Cow("소3"),new Cow("고양이3")
						
				};
		
		for(int i=0;i<animals.length;i++)
		{
			animals[i].eat();
			animals[i].sound();
		}
	}

}
