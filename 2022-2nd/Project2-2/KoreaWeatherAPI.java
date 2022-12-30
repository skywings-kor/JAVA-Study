import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;


import java.io.*;
import java.util.StringTokenizer;


public class KoreaWeatherAPI {
	//SQL부분
	String URL="jdbc:mysql://localhost:3306/weather?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	//설정부분
	String madeArea="temp";
	
	//가져올 떄 사용할 변수
	int remainStr;
	
	String temp;
	String apiArea="";
	String apiDate;
	String apiAvgTemp;
	String apiMinTemp;
	String apiMaxTemp;
	String apiRain;
	String apiSnow;
	String apiCloud;
	
	Double chapiAvgTemp;
	Double chapiMinTemp;
	Double chapiMaxTemp;
	Double chapiRain;
	Double chapiSnow;
	Double chapiCloud;
	
	KoreaWeatherAPI(String location,String start, String end)
	{
    	try
    	{
    		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=BUNKSXe6EQnnJ0KG4gRUWaLRwifdFbKcE3gk%2BgSWfrdGx21g5RK2%2BJzJQxSYrifltnKGRopwDdGtp%2FqoM8wrwg%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호 Default : 1*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("366", "UTF-8")); /*한 페이지 결과 수 Default : 10*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default : XML*/
            urlBuilder.append("&" + URLEncoder.encode("dataCd","UTF-8") + "=" + URLEncoder.encode("ASOS", "UTF-8")); /*자료 분류 코드(ASOS)*/
            urlBuilder.append("&" + URLEncoder.encode("dateCd","UTF-8") + "=" + URLEncoder.encode("DAY", "UTF-8")); /*날짜 분류 코드(DAY)*/
            urlBuilder.append("&" + URLEncoder.encode("startDt","UTF-8") + "=" + URLEncoder.encode(start, "UTF-8")); /*조회 기간 시작일(YYYYMMDD)*/
            urlBuilder.append("&" + URLEncoder.encode("endDt","UTF-8") + "=" + URLEncoder.encode(end, "UTF-8")); /*조회 기간 종료일(YYYYMMDD) (전일(D-1)까지 제공)*/
            urlBuilder.append("&" + URLEncoder.encode("stnIds","UTF-8") + "=" + URLEncoder.encode(location, "UTF-8")); /*종관기상관측 지점 번호 (활용가이드 하단 첨부 참조)*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());
            BufferedReader rd;
            
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            //System.out.println(sb);
            
            //builder로 연결한 것을 다시 문자열로 변환
            String test=sb.toString();
            
            //SQL 부분
            makeConnection();
			stmt=con.createStatement();
            StringTokenizer st;
            st=new StringTokenizer(test,"\"");
            
            String command;
            while((remainStr=st.countTokens())!=0)
            {
            	temp=st.nextToken();

            	//위치지역이름
            	if(temp.equals("stnNm")==true)
            	{
            		st.nextToken();
            		madeArea=st.nextToken();
            		
            		//System.out.println(madeArea);
            		if(madeArea.equals(",")==true)
            		{
            			madeArea="0";
            		}
            	}
            	
            	//날짜
            	else if(temp.equals("tm")==true)
            	{
            		st.nextToken();
            		apiDate=st.nextToken();
            		

            		//System.out.println(apiDate);
            		if(apiDate.equals(",")==true)
            		{
            			apiDate="0";
            		}
            	}
            	
            	//평균온도
            	else if(temp.equals("avgTa")==true)
            	{
            		st.nextToken();
            		apiAvgTemp=st.nextToken();
            		

            		//System.out.println(apiAvgTemp);
            		if(apiAvgTemp.equals(",")==true)
            		{
            			apiAvgTemp="0";
            		}
            	}
            	
            	//최저온도
            	else if(temp.equals("minTa")==true)
            	{
            		st.nextToken();
            		apiMinTemp=st.nextToken();
            		

            		//System.out.println(apiMinTemp);
            		if(apiMinTemp.equals(",")==true)
            		{
            			apiMinTemp="0";
            		}
            	}
            	
            	//최고온도
            	else if(temp.equals("maxTa")==true)
            	{
            		st.nextToken();
            		apiMaxTemp=st.nextToken();

            		if(apiMaxTemp.equals(",")==true)
            		{
            			apiMaxTemp="0";
            		}

            		//System.out.println(apiMaxTemp);
            	}
            	
            	//평균 강수량
            	else if(temp.equals("sumRn")==true)
            	{
            		st.nextToken();
            		apiRain=st.nextToken();

            		if(apiRain.equals(",")==true)
            		{
            			apiRain="0";
            		}

            		//System.out.println(apiRain);
            	}
            	
            	//최심신적설
            	else if(temp.equals("ddMefs")==true)
            	{
            		st.nextToken();
            		apiSnow=st.nextToken();

            		if(apiSnow.equals(",")==true)
            		{
            			apiSnow="0";
            		}

            		//System.out.println(apiSnow);
            	}
            	
            	//평균전운량 (마지막부분)
            	else if(temp.equals("avgTca")==true)
            	{
            		st.nextToken();
            		apiCloud=st.nextToken();

            		if(apiCloud.equals(",")==true)
            		{
            			apiCloud="0";
            		}

            		//System.out.println(apiCloud);
            		
            		
            		//규민아 여기 문자열을 Double로 바꿔서 넣으면 될거니까 그렇게 이어서 하면 API 완성된다
            		chapiCloud=Double.parseDouble(apiCloud);
            		chapiMinTemp=Double.parseDouble(apiMinTemp);
            		chapiMaxTemp=Double.parseDouble(apiMaxTemp);
            		chapiRain=Double.parseDouble(apiRain);
            		chapiSnow=Double.parseDouble(apiSnow);
            		chapiAvgTemp=Double.parseDouble(apiAvgTemp);
            		
            		command="INSERT INTO mokpo VALUES ('"+madeArea+"','"+apiDate+"','"+chapiCloud+"','"+chapiMinTemp+"','"+chapiMaxTemp+"','"+chapiRain+"','"+chapiSnow+"','"+chapiAvgTemp+"')";
            		stmt.executeUpdate(command);
            		
            	}
            }
            
            rd.close();
            conn.disconnect();
    	}
    	
    	catch(Exception e)
    	{
    		System.out.println(apiCloud);
    		System.out.println(apiMinTemp);
    		System.out.println(apiMaxTemp);
    		System.out.println(apiRain);
    		System.out.println(apiSnow);
    		System.out.println(apiAvgTemp);
    		System.out.println(e.getMessage());
    	}
    	
        
	}
	
	
    
  	void makeConnection()
  	{
  		try 
  		{
  			Class.forName("com.mysql.cj.jdbc.Driver");
  		}
  		catch(Exception e)
  		{
  			System.out.println(e.toString());
  		}
  		
  		try 
  		{
  			con=DriverManager.getConnection(URL,"root","root");
  			System.out.println("OK");
  		}
  		catch(Exception t)
  		{
  			System.out.println(t.toString());
  		}
  	}
  	
}