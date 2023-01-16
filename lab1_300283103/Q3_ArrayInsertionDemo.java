public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int[] biggerArray = new int[(beforeArray.length) + 1];
        int i = 0;
        while (i != indexToInsert){
            biggerArray[i] = beforeArray[i];
            i++;
        }
        biggerArray[i] = valueToInsert;
        i++;

        for(int j = i; j<(beforeArray.length +1);j++){
            biggerArray[j] = beforeArray[j-1];
        }

        return biggerArray;
        
	}

	public static void main(String[] args)
    {
        int[] beforeArray = new int[]{1,5,4,7,9,6};
        System.out.println("Array before insertion: ");
        for(int i =0; i<beforeArray.length;i++){
            System.out.println(beforeArray[i]);
        }
        int insert = 15;
        int pos = 3;
        
        int[] a = insertIntoArray(beforeArray, pos, insert);
        System.out.println("Array after insertion of " + insert +" at posistion " + pos );
        for(int i =0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}