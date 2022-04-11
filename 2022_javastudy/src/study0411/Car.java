package study0411;


public class Car {
	String vender,model,owner;
	
	public Car(String a)
	{
		this.vender=a;
		System.out.println("1번 생성자");
	}
	
	
	public Car(String a,String b)		//2개 값 전달해줄때 실행되는 부분
	{
		this(a);		//생성자 호출구문은 반드시 첫 라인에서 와야한다
//		this.vender=a;
		this.model=b;
		System.out.println("2번 생성자");
	}
	
	
	
	public Car(String a,String b,String c)	//3개 값 전달해줄때 실행되는 부분(메소드의 오버로딩 이다)
	{
		this(a,b);
//		this.vender=a;
//		this.model=b;
		this.owner=c;
		System.out.println("3번 생성자");
	}
	
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	public void carInfo()
	{
		System.out.printf("생산자:%s, 모델:%s, 소유자:%s \n",this.vender,this.model,this.owner);
	}
	
	//()안에 있는 것에 따라 같은 함수 이름이더라도 해당 부분을 찾아가서 실행함
//	public void printValue(Object object)
//	{
//		System.out.println(object);
//	}			
	public void printValue(char value)
	{
		System.out.println(value);
	}			
	public void printValue(String value)
	{
		System.out.println(value);
	}			
	public void printValue(double value)
	{
		System.out.println(value);
	}			
	
	
	
}
