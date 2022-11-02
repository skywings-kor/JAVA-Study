import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;


public class Ready_8 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fp=new File("C:\\classtemp\\list.txt");
		
		String readData;
		StringTokenizer st;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fp));
			
			while((readData=br.readLine())!=null)
			{
				st=new StringTokenizer(readData," ");
				String name=st.nextToken();
				String telnum=st.nextToken();
				
				st=new StringTokenizer(telnum,"+");
				
				String t1=st.nextToken();
				String t2=st.nextToken();
				String t3=st.nextToken();
				
				System.out.println(name+"  "+t1+"-"+t2+"-"+t3);
			}
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
