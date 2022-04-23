package java_book;

public class Q7_made_bankUID {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		
		Q7_made_bankaccount user1=new Q7_made_bankaccount("12-38-14","28383-2332",3000);
		user1.checkbank();
		
		user1.inputb(3500);
		user1.checkbank();
		
		user1.depositb(1000);
		user1.checkbank();
		
	}
	

}
