package study05_09;

public class Bus extends Vehicle{
	
	String vehicleType;
	
	public Bus (String type)
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
