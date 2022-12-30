
public class First_1 {
	//이건 필드임
	int res;
	int a,b;
	
	public First_1(int horizon, int ver)	//디폴트 생성자-원래는 자동으로 들어감
	//이걸 오버로드라고 함
	{
		this.a=horizon;
		this.b=ver;
	}
	
	public void calcu()
	{
		//이 안에서 변수를 선언하면 그건 변수임
		res=a*b;	//넓이 구해서 res에 넣음

	}
}
