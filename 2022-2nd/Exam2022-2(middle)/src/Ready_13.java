import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import javax.swing.table.*;
import javax.swing.tree.*;

public class Ready_13{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fp=new File("C:\\classtemp\\list.txt");
		String data;
		StringTokenizer st;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fp));
			while((data=br.readLine())!=null)
			{
				st=new StringTokenizer(data," ");
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
