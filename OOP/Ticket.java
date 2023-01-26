public class Ticket{
	private static int lastSerialNumber =0;
	private int serialNumber;
	
	public Ticket(){
		serialNumber = lasSerialNumber;
		lastSerialNumber++;
	}
	public int getSerialNumber(){
		return serialNumber;
	}
}