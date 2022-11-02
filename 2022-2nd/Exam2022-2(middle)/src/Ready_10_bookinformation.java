import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;


public class Ready_10_bookinformation {
	void fileReadBook(Ready_10 main)
	{
		File fp=new File("C://classtemp//bookList.txt");
		String readD;
		StringTokenizer st;
		Ready_10_book r1= new Ready_10_book();
		try
		{
			BufferedReader br= new BufferedReader(new FileReader(fp));
			while((readD=br.readLine())!=null)
			{
				st=new StringTokenizer(readD,"/");
				r1.id=st.nextToken();
				r1.title=st.nextToken();
				r1.author=st.nextToken();
				r1.made=st.nextToken();
				r1.year=st.nextToken();
				r1.type=st.nextToken();
				
				main.booklist.add(r1);
				System.out.println(r1.id);
				
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
