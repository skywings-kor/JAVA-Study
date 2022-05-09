package study05_09;

public class Driver{
	
//	public void driveBus(Bus bus)
//	{
//		bus.run();
//	}
//	public void driveTruck(Truck truck)
//	{
//		truck.run();
//	}
//	
//	public void driveSportsCar(SportsCar sCar)
//	{
//		sCar.run();
//	}
//	
	public void drive(Vehicle v)
	{
		v.run();
		
		if(v instanceof Bus)
		{
			((Bus) v).getVehicleType();
		}
		
		else if(v instanceof Truck)
		{
			((Truck)v).getVehicleType();
		}
		
		else
		{
			System.out.println("Unknown class type object");
		}
			
	}
	
	
	
	
}
