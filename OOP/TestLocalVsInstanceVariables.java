public class TestLocalVsInstanceVariables{
	public static void main(String[] args){
		//int i; gives error since i is just null memory
		//i++;
		Point myPoint;
		myPoint = new Point();
		System.out.println(myPoint.x);
		
		myPoint.x = 1;
		myPoint.y = 1;
		System.out.println(myPoint.sumCoordinates());

		myPoint.x++;
		System.out.println(myPoint.x);
		System.out.println(myPoint.sumCoordinates());
		
		


		
		
		
	}
}