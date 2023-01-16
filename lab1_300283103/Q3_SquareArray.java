public class Q3_SquareArray{
	public static int[] createArray(int size){
		int actual_size=size+1;
		int[] array = new int[actual_size];
		for (int i = 0; i<actual_size;i++){
			array[i] = i*i;
		}
		return array;
	}
	public static void main(String[] args){
		int[] arr = createArray(12);
		for(int i = 0; i<arr.length;i++){
			System.out.println("The square of " + i + " is: " + arr[i]);
		}
	}
}