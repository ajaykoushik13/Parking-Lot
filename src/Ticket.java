import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Ticket
{
	private Vehicle vehicle;
	private Space space;
	private double inTime;
	private double outTime;
	private int ticketId;
	public Ticket(Space space, Vehicle vehicle) throws IOException
	{
		System.out.println("Enter the In Time ");
		inTime = Double.parseDouble(Input.scanner.readLine());
		setInTime(inTime);
		setSpace(space);
		setVehicle(vehicle);
		setTicketId();
	}
	
	private void setTicketId()
	{
		ArrayList allTicketId = new ArrayList();
		Random rand = new Random();
		int id = rand.nextInt(2000);
		while(allTicketId.contains(id))
			id = rand.nextInt(2000);
		this.ticketId = id;
		
	}
	
	public int getTicketId()
	{
		return ticketId;
	}
	public double getInTime() 
	{
		return inTime;
	}
	
	public void setVehicle(Vehicle vehicle)
	{
        this.vehicle = vehicle;
    }
	
	private void setInTime(double inTime)
	{
		this.inTime = inTime;
	}
	
	private void setSpace(Space space)
	{
		this.space = space;
	}

	public Vehicle getVehicle()
	{
		return vehicle;
	}
	public Space getSpace()
	{
		return space;
	}
}
