package study05_30;

public class Person {
	//int countOfInstance;		//초기값은 0임 //이렇게 하면 각각 하나씩 만들어져서 카운트되서 잘못됨
	static int countOfInstance;
	
	String name;
	
	public Person(String name)
	{
		this.name=name;
		countOfInstance++;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCount()
	{
		return   countOfInstance;
	}
	
	
}
