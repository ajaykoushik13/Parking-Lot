
public class Space {
	private int floor;
	private int slot;
	
	public Space(int floor,int slot)
	{
		this.setFloor(floor);
		this.setSlot(slot);
	}
	
	private void setFloor(int floor)
	{
		this.floor = floor;
	}
	
	private void setSlot(int slot)
	{
		this.slot = slot;
	}
	
	public int getFloor()
	{
		return floor;
	}
	
	public int getSlot()
	{
		return slot;
	}
}
