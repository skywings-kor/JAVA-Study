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
		System.out.printf("%d���Ա�\n",a);
	}
	
	public void depositb(int b)
	{
		money=money-b;
		System.out.printf("%d�����\n",b);
		
	}
	
	public void checkbank()
	{
		System.out.printf("���¹�ȣ:%s\n",banknum);
		System.out.printf("�ֹι�ȣ:%s\n",usernum);
		System.out.printf("�� ��:%d\n",money);
	}
	
}
