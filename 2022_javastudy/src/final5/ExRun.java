package final5;

import java.io.*;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File fp=null;
		FileReader fr=null;
		
		try
		{
			fp=new File("D://test.txt");
			fr= new FileReader(fp);
			
			int ch;
			while((ch=fr.read())!=-1)
			{
				System.out.println((char)ch);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				fr.close();
			}
			
			catch(Exception t)
			{
				t.printStackTrace();
			}
		}
		
		
	}

}
