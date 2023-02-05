public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
		 this.denominator = 1;
		 this.reduce();
    }

    public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		this.reduce();
		
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
		// calculating the denominator of the sum of two rational numbers
		int den = other.denominator * this.denominator;
		
		// calculating the numerator of the sum of two rational numbers
		int num = (other.denominator*this.numerator) + (this.denominator*other.numerator);
		
		Rational sum = new Rational(num, den);
		sum.reduce();
		return sum;
	}
	
	// Adds two rational objects
	public static Rational plus(Rational a, Rational b) {
		// calculating the denominator of the sum of two rational numbers
		int den = a.denominator * b.denominator;
				
		// calculating the numerator of the sum of two rational numbers
		int num = (a.denominator*b.numerator) + (b.denominator*a.numerator);
				
		Rational sum = new Rational(num, den);
		sum.reduce();
		return sum;
	}

    // Transforms this number into its reduced form

    private void reduce() {
		// calculating the greatest common divisor of the numerator and denominator
		int gcd = gcd(this.numerator, this.denominator);
		
		// reducing the rational number by dividing both
		// numerator and denominator by gcd
		this.numerator /= gcd;
		this.denominator /= gcd;
	}

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
	  if (a<0){a=a*(-1);}
	  else if (b < 0){b = b * (-1);}
    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
		this.reduce();
		other.reduce();
		float instance_decimal = (float) (this.getNumerator() / this.getDenominator());
		float otherr_decimal = (float) (other.getNumerator() / other.getDenominator());
      if (this.equals(other)){return 0;}
	  else if (instance_decimal > otherr_decimal){return 1;}
	  else{return -1;}
    }

    public boolean equals(Rational other) {
		if (this.plus(other).numerator==0) {
			return true;
		}
		return false;
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = Integer.toString(this.getNumerator());
    	} else {
    	    result = Integer.toString(this.getNumerator()) + "/" + Integer.toString(this.getDenominator());
    	}
    	return result;
    }

}