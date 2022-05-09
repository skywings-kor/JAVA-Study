package study05_09;

public class SportsCar extends Vehicle{
	
	String vehicleType;
	
	public SportsCar (String type)
	{
		this.vehicleType=type;
	}
	
	public String getVehicleType()
	{
		return this.vehicleType;
	}
	
	public void run()
	{
		System.out.println(this.vehicleType);
	}
}
