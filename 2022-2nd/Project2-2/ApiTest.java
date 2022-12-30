
public class ApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//지역위치 133:대전, 108:서울, 112:인천,  184:제주, 105:강릉(강원도 동), 159:부산, 156:광주, 239:세종(데이터가 과거가 없어서 패스), 143: 대구
		//146:전주(전라북도), 99:파주(경기북부), 119:수원(경기남부), 101:춘천(강원도 북), 114:원주(강원도 남), 232:천안(충남), 131:청주(충북), 136:안동(경상북도), 152:울산, 192:진주(경상남도)
		//165:목포(전라남도)
		String location="165";
		
		
//		전체 api 돌리는거
		
		for(int i=20000101; i<=20191213;i=i+10000)
		{
			int endNum=i+1130;
			String start=Integer.toString(i);
			String end=Integer.toString(endNum);
			System.out.println(start);
			System.out.println(end);
			KoreaWeatherAPI run=new KoreaWeatherAPI(location,start,end);
		}
		
		//일부 안된 부분 돌리는거
		
		//KoreaWeatherAPI run=new KoreaWeatherAPI(location,"20120101","20121231");
	}

}
