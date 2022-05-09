package study05_09;

public class Truck extends Vehicle{
	
	String vehicleType;
	
	public Truck (String type)
	{
		this.vehicleType=type;
	}
	
	public String getVehicleType()
	{
		return this.vehicleType;
	}
	
	@Override
	public void run()
	{
		System.out.println(this.vehicleType+"이(가) 달린다");
	}
	
	
}
