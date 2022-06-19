package study06_13_02;

import java.io.*;		//�����ϰ� ��� ��Ű�� ����!

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
			while((ch=fr.read())!=-1) //-1�� ���ö����� ������ ������ ���κ�
			{
				System.out.println((char)ch);  	//���Ͽ��� ������ ���� Ÿ���̶�
			}
		}
		catch(Exception e) //�ͼ����� �Ȼ������ ������ close�� �ȵǴϱ�
		{
			e.printStackTrace();
		}
		//�̷��� finally�� �Ἥ ���������� ����ǰ� ��!
		finally
		{
			try
			{
				fr.close();
			}
			
			catch(Exception e)
			{
				System.out.println("fr.close() �ͼ���: ");
				e.printStackTrace();
			}
		}
	}

}
