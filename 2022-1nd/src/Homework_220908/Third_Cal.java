
public class Third_Cal {
	
	int user;	//유저가 입력한 값 받는
	int res;
	int count=0;	//for문 카운트용
	public Third_Cal(int a)
	{
		this.user=a;
	}
	
	public void change()
	{
		for(int i=1; i<=500;i++)
		{
			res=i%user;	//나머지만 0일때 실행되도록 하기 위한 연산부분
			
			if(res==0)
			{
				System.out.printf("%d ",i);
				count=count+1;
			}
			
			if(count==5)//5번 출력했을 경우 다음줄로 넘어가기 위한 용도
			{
				System.out.printf("\n");
				count=0;		//count는 0으로 초기화
			}
			
		}
		
		
	}
}
