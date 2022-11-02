package Class_1004;

import java.io.*;
import java.util.StringTokenizer;

public class FileEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fp= new File("C:\\classtemp\\list.txt");
		String readData;
		StringTokenizer st;
		
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fp));
			
			while((readData=br.readLine())!=null)
			{
				st=new StringTokenizer(readData," ");
				String name=st.nextToken();
				System.out.println("이름:"+name);
				String telNum=st.nextToken();
				st=new StringTokenizer(telNum,"+");
				String telNumP1=st.nextToken();
				String telNumP2=st.nextToken();
				String telNumP3=st.nextToken();
				System.out.println("전화번호:"+telNumP1+"-"+telNumP2+"-"+telNumP3);
			}
			br.close();
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
