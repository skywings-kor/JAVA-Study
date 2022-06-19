package study06_13_02;

import java.io.*;		//간단하게 모든 패키지 선언!

public class ExRun {

	public static void main(String[] args) {
		
		String fpath="D:\\";
		String fname="myfile.txt";
		File file=null;
		FileReader fr=null;
		//		File file=new File(fpath+fname);
		//		FileReader fr=new FileReader(file);
		
		try 
		{
			file=new File(fpath+fname);
			fr=new FileReader(file);
			
			int ch;
			while((ch=fr.read())!=-1) //-1이 나올때까지 읽으면 파일의 끝부분
			{
				System.out.println((char)ch);  	//파일에서 읽으면 문자 타입이라서
			}
		}
		catch(Exception e) //익셉션이 안생길수도 있으면 close가 안되니까
		{
			e.printStackTrace();
		}
		//이럴때 finally를 써서 공통적으로 실행되게 함!
		finally
		{
			try
			{
				fr.close();
			}
			
			catch(Exception e)
			{
				System.out.println("fr.close() 익셉션: ");
				e.printStackTrace();
			}
		}
	}

}
