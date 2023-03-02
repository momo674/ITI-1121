/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */

public class B implements DeepCopyable{ // complete the class declaration as required

	private A a1, a2;

	public B( A a1, A a2){
		this.a1 = a1;
		this.a2 = a2;
	}

	public A getA1() {
		return a1;
	}

	public A getA2() {
		return a2;
	}

	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass() ) { return false; }
		if (this == o) { return true; }
		
		else {
			B other = (B) o;
			if (this.getA1() == null && other.getA1() != null) { return false; }
			if (this.getA2() == null && other.getA2() != null) { return false; }
			if (this.getA1().equals(other.getA1()) && this.getA2().equals(other.getA2())) {return true;}
			return false;
		}
	}
	public DeepCopyable deepCopy() {
		A a1param = null;
		A a2param = null;
		if (this.getA1() == null) { a1param = null; }
		
		else {
			if (this.getA1() != null) { a1param = (A) this.getA1().deepCopy(); }
			
			if (this.getA2() == null) { a2param = null; }
			else {
				if (this.getA2() != null) { a2param = (A) this.getA2().deepCopy(); }
				
				
			}
		}
		return (new B(a1param, a2param));
	}

}