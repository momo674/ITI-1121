/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */


public class A implements DeepCopyable{ // complete the class declaration as required
	
	private int a , b, c;

	public A(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {return this.a;}
	public int getB() {return this.b;}
	public int getC() {return this.c;}
	
	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass()) {return false;}
		else {
			A other = (A) o;
			if (this.getA() == other.getA() && this.getB() == other.getB() && this.getC() == other.getC()) {return true;}
			return false;
		}
	}
	
	public DeepCopyable deepCopy(){
		return new A(this.a, this.b, this.c);
	}

}
