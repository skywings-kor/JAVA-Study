package study05_09;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bus b1=new Bus("���� �׷�����");
		Truck t1=new Truck("��� ȭ����");
		
		
		Bus b2=new Bus("���� �׷�����2");
		Truck t2=new Truck("��� ȭ����2");
		
		
		Bus b3=new Bus("���� �׷�����3");
		Truck t3=new Truck("��� ȭ����3");
		
		
		Driver driver = new Driver();
//		driver.driveBus(b1);
//		driver.driveTruck(t1);
//		
//		driver.driveBus(b2);
//		driver.driveTruck(t2);
//		
//		driver.driveBus(b3);
//		driver.driveTruck(t3);
		
		driver.drive(b1);
		driver.drive(b2);
		driver.drive(b3);
		
		Bus b=new Bus("bus");
		b.getVehicleType();
		Vehicle v=new Bus("bus");
		
		
	}

}
