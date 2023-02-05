public class App{
	
	public static void main(String[] args){
		Movie movie1 = new Movie("The Avengers", "Joss Whedon", "PG-13");
		Movie movie2 = new Movie("Step Brothers", "Adam McKay", "R");
		
		movie1.setRating("Dog");
		System.out.println(movie1.getRating());
		movie1.setTitle("Twerk");
		System.out.println(movie1.getTitle());
		movie1.setRating("PG-13");
		System.out.println(movie1.getRating());
		movie1.setDirector("Mohamad Ibrahim Radaideh");
		System.out.println(movie1.getDirector());
		System.out.println(movie1);
	}
}	