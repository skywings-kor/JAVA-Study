package study05_16;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Cat cat= new Cat();
//		
//		cat.sound();
//		cat.eat();
//		
//		Cow cow=new Cow();
//		cow.eat();
//		cow.sound();
//		
		
		Cat_i cat=new Cat_i();
		Cow_i cow=new Cow_i();
		
		cat.eat("생선");
		cat.sound(3);
		cow.eat("건초");
		cow.sound(4);
	}

}
