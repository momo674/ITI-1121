public class Test3{
	public static void main( String[] args){
		//define sum at top
		int sum = 0;
		System.out.println(sum);
		for (int i = 0; i < 10; i++){
			System.out.println(i);
		}
		//int sum = 0; 
		for(int i=1; i<10; i++){
			sum += i;
		}
	}
}