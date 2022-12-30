package Class_1004_BookMGM_PGM;

import java.io.*;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

//책정보가 담겨진 소스파일을 읽어 Book 객체 생성 후 관리가 용이하게 해주는  Class
public class BookInformationReader {
	void readBokkInformationReader(MainFrame mf)
	{
		//상대경로, 절대경로
		File fp= new File("C:\\classtemp\\bookList.txt");
		String readData;
		StringTokenizer st;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fp));
			
			while((readData=br.readLine())!=null)
			{
				Book book=new Book();
				//반드시 시험이요
				st=new StringTokenizer(readData,"/");
				book.id=st.nextToken();
				book.title=st.nextToken();
				book.author=st.nextToken();
				book.bulisher=st.nextToken();
				book.year=st.nextToken();
				book.type=st.nextToken();
				mf.bookList.add(book);
				System.out.println(book.id);
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("파일 입출력관련 예외발생");
		}
		
		
	}
	
}
