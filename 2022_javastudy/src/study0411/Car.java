package study0411;


public class Car {
	String vender,model,owner;
	
	public Car(String a)
	{
		this.vender=a;
		System.out.println("1�� ������");
	}
	
	
	public Car(String a,String b)		//2�� �� �������ٶ� ����Ǵ� �κ�
	{
		this(a);		//������ ȣ�ⱸ���� �ݵ�� ù ���ο��� �;��Ѵ�
//		this.vender=a;
		this.model=b;
		System.out.println("2�� ������");
	}
	
	
	
	public Car(String a,String b,String c)	//3�� �� �������ٶ� ����Ǵ� �κ�(�޼ҵ��� �����ε� �̴�)
	{
		this(a,b);
//		this.vender=a;
//		this.model=b;
		this.owner=c;
		System.out.println("3�� ������");
	}
	
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	public void carInfo()
	{
		System.out.printf("������:%s, ��:%s, ������:%s \n",this.vender,this.model,this.owner);
	}
	
	//()�ȿ� �ִ� �Ϳ� ���� ���� �Լ� �̸��̴��� �ش� �κ��� ã�ư��� ������
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
