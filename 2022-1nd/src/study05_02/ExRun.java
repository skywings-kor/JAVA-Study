package study05_02;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat animal1=new Cat("�����");
		Cow animal2=new Cow("��");
		
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
						new Cat("�����1"),new Cow("��1"),new Cow("��2"),
						new Cat("�����2"),new Cow("��3"),new Cow("�����3")
						
				};
		
		for(int i=0;i<animals.length;i++)
		{
			animals[i].eat();
			animals[i].sound();
		}
	}

}
