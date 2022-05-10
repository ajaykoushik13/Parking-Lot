import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class ParkingSlot
{
	private final int floors = 2;
	private final int slots = 2;
	private static int slot[][];
	private int slotId;
	private static HashMap<Integer, ArrayList> tickets = new HashMap<Integer, ArrayList>();
	
	public ParkingSlot()
	{
		slot = new int [floors][slots];
	}
	
	private Space getAvailableSlot()
	{
		for(int i = 0; i < floors;i+=1)
		{
			for(int j = 0 ; j < slots;j+=1)
			{
				if(slot[i][j] == 0)
				{
					slotId = i * 10 + (j + 1);
					return new Space(i,j);
				}
			}
		}
		return null;
	}
	
	private Vehicle getVehicleInfo() throws IOException
	{
		System.out.println("Enter the Vehicle Number");
		String number = Input.scanner.readLine();
		return new Vehicle(number);
	}
	
	public Ticket bookTicket() throws IOException
	{
		ArrayList arr = new ArrayList();
		Space space = getAvailableSlot();
		if(space != null)
		{
			Vehicle vehicle = getVehicleInfo();
			slot[space.getFloor()][space.getSlot()] = 1;
			Ticket newTicket = new Ticket(space,vehicle);			
			arr.add(newTicket.getInTime());
			arr.add(vehicle.getNumber());
			arr.add(slotId);
			tickets.put(newTicket.getTicketId(), arr);
			System.out.println(tickets);
			return newTicket;
		}
		return null;
	}

	public void exitTicket() throws IOException
	{
		int ticketNumber;
		System.out.println("Enter the ticket number");
    	ticketNumber = Integer.parseInt(Input.scanner.readLine());
    	double fare = 30;
		double endTime;
		double startTime;
		int intpart ;
		double decipartStart;
		double decipartEnd;
		double hoursParked;
		System.out.println("Enter the Exit time");
	    endTime = Double.parseDouble(Input.scanner.readLine());
	    intpart = (int) endTime;
        decipartEnd =  endTime - intpart;
        startTime = (Double) tickets.get(ticketNumber).get(0);
        intpart = (int) startTime;
        decipartStart = startTime - intpart;
        if(decipartEnd >= decipartStart)
        {
        	hoursParked = endTime - startTime;
        }
        else
        {
        	decipartEnd += 0.60;
        	decipartEnd /= 10;
        	intpart = (int) endTime;
        	intpart -= 1;
        	int intpartStart = (int) startTime;
        	int deciEnd;
        	int deciStart;
        	intpart -= intpartStart;
        	deciEnd = (int) (decipartEnd * 1000);
        	deciStart = (int) (decipartStart * 100);
        	decipartEnd = (deciEnd - deciStart);
        	decipartEnd /= 100;
        	hoursParked = intpart + decipartEnd;
        }
        if(hoursParked <= 1)
        	fare = 30;
        else 
        {
        	double hours;
        	double farePerHour = 10;
        	hours = hoursParked - 1;
        	farePerHour *= hours;
        	fare += farePerHour;
        }
        int slotId = (Integer) tickets.get(ticketNumber).get(2);
        int floor = slotId / 10;
        int space = slotId % 10;
        slot[floor][space-1] = 0;
        System.out.println("Thanks for using Parking Lot!");
        System.out.println("Ticket ID: " + ticketNumber);
        System.out.println("Vechile Number: " + tickets.get(ticketNumber).get(1));
        System.out.println("In-Time Number: " + startTime);
        System.out.println("Out-Time Number: " + endTime);   
        System.out.println("Amount : " + Math.round(fare));
        System.out.println("Thank You!!! Visit Again");
        tickets.remove(ticketNumber);
	}
	
	public void getSlotsAvailableInEachFloor()
	{
		
		for(int i = 0; i < floors;i+=1)
		{
			int available = 0;
			for(int j = 0 ; j < slots;j+=1)
			{
				if(slot[i][j] == 0)
				{
					available += 1;
				}
			}
			System.out.println("Slots available in Floor "+  i + " is " + available);
		}
	}
	public int getSlotId()
	{
		return slotId;
	}
	public int getFloors()
	{
	    return floors;
	}

	public int getSpacePerFloor()
	{
	    return slots;
	}
} 
