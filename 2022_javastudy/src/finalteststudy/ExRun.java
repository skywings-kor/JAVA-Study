package finalteststudy;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat c1=new Cat();
		
		
		c1.eat();
		c1.sound();
		
		Cow w1=new Cow();		//지금 보니까 추상메소드 방문하였습니다가 이거 맞춰나오는거 보니 순서대로 방문하네요.
		w1.eat();
		w1.sound();
	}

}
