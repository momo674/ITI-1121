public class Combination {

    // Instance variables.
    // Remove this comment and declare your instance variables here
	int first_digit;
	int second_digit;
	int third_digit;
    // Constructor
	public Combination(){
		this.first_digit = 0;
		this.second_digit = 0;
		this.third_digit = 0;
	}
    public Combination( int first , int second, int third ) {
        this.first_digit = first;
		this.second_digit = second;
		this.third_digit = third;
    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
		
        // Put your code here and remove the line below
		if (other == null){
			return false;
			}
		else if (first_digit == other.first_digit && second_digit == other.second_digit && third_digit == other.third_digit){
			return true;
		}
		
		return false;
    }

    // Returns a String representation of this Combination.

    public String toString() {
		String s = Integer.toString(first_digit) + ":" + Integer.toString(second_digit) + ":" + Integer.toString(third_digit);
        // Put your code here and remove the line below
        return s;
    }

}