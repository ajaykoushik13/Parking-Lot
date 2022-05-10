import java.io.IOException;

public class Main {
	static int availableSlots;
	public static void main(String[] args) throws IOException{
		ParkingSlot slot = new ParkingSlot();
		int num;
		availableSlots = slot.getFloors() * slot.getSpacePerFloor();
        do{
        	System.out.println("********************************");
        	System.out.println("Welcome");
        	System.out.println("Enter 1 for entry\nEnter 2 for exit\nEnter 3 to find the number of slots available in each floor\nEnter 0 to stop the program");
        	System.out.println("Available Slots : " + availableSlots);
        	System.out.println("********************************");
            num = Integer.parseInt(Input.scanner.readLine());
            if(num == 1)
            {
            	Ticket ticket = slot.bookTicket();
            	if(ticket == null)
            		System.out.println("Slots are full!!!Please Wait");
            	else
            	{
	            	System.out.println("Parking space is allocated");
	            	System.out.println("Your ticket id is "+ ticket.getTicketId());
	            	System.out.println("Go to " + (slot.getSlotId() / 10) + " floor " + (slot.getSlotId() % 10) + " Slot");
	            	availableSlots -= 1;
            	}
            }
            else if (num == 2)
            {	
            	availableSlots += 1;
            	slot.exitTicket();
            }
            else if(num == 3)
            {
            	slot.getSlotsAvailableInEachFloor();
            }
            else if(num == 0)
            	System.out.println("Program has stopped.Thank You");
            else
            System.out.println("Enter the correct number");
        }while(num != 0);
	}

}
