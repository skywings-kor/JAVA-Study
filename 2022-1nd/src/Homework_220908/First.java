
public class First {
	public static void main(String[] args)
	//static�� �겢�옒�뒪瑜� �쐞�븳寃� -�젙�쟻
	{
		// TODO Auto-generated method stub
		
		
		int hor,ver;
		First_Input typeIn=new First_Input();
		System.out.printf("가로입력: ");
		hor=typeIn.getInt();
		
		
		System.out.printf("세로입력: ");
		ver=typeIn.getInt();
		
		First_1 cal= new First_1(hor,ver);
		cal.calcu();
		System.out.printf("결과:%d",cal.res);
	}

}
