public class App{
	public static void main(String[] args) {
		Animal [] animals = {
			new Cow(),
			new Dog(),
			new Bird()
		};
		
		//Animal myCow = new Cow();
		//myCow.eat();
		
		//Animal myDog = new Dog();
		//myDog.eat();
		
		for (int i =0; i<animals.length; i++){
			animals[i].eat();
			animals[i].speak();
		}
	}
}