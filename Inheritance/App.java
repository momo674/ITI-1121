public class App{
	public static void main(String[] args)
	{
		Chef normalChef = new Chef();
		normalChef.makeChicken();
		normalChef.makeSalad();
		
		ItalianChef marioChef = new ItalianChef();
		marioChef.makeChicken();
		ChineseChef asian = new ChineseChef();
		asian.makeChicken();
	}
}