package study0411;


public class Car {
	String vender,model,owner;
	
	public Car(String a,String b,String c)
	{
		this.vender=a;
		this.model=b;
		this.owner=c;
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
	
	
	
}
