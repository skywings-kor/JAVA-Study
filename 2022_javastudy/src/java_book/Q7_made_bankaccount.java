package java_book;

public class Q7_made_bankaccount {
	String banknum;
	String usernum;
	int money;
	public Q7_made_bankaccount(String inbanknum,String inusernum,int inmoney)
	{
		banknum=inbanknum;
		usernum=inusernum;
		money=inmoney;
	}
	
	public void inputb(int a)
	{
		money=money+a;
		System.out.printf("%d원입금\n",a);
	}
	
	public void depositb(int b)
	{
		money=money-b;
		System.out.printf("%d원출금\n",b);
		
	}
	
	public void checkbank()
	{
		System.out.printf("계좌번호:%s\n",banknum);
		System.out.printf("주민번호:%s\n",usernum);
		System.out.printf("잔 액:%d\n",money);
	}
	
}
