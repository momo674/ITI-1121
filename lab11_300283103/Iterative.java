import java.util.NoSuchElementException;
public class Iterative {

	public static BitList complement( BitList in ) {
        BitList out = new BitList();
        Iterator i = out.iterator();
        Iterator inn = in.iterator();
		int value;
        while (inn.hasNext()) {
			value = inn.next();
            if (value == 0) {i.add(1);}
            else if (value == 1) {i.add(0);}
			
        }
		return out;
		
	}

	public static BitList or( BitList a, BitList b ) {
		Iterator a_it = a.iterator();
		Iterator b_it = b.iterator();
		BitList out = new BitList();
		Iterator o_it = out.iterator();
		if (a == null || b == null) {throw new IllegalArgumentException("Lists are different lengts.");}
		int a_value = 7;
		int b_value = 7;
		int out_value = 7;
		Boolean a_bool = null;
		Boolean b_bool = null;
		Boolean out_bool = null;
		while (a_it.hasNext() && b_it.hasNext()) {
			a_value = a_it.next();
			b_value = b_it.next();
			if (a_value == 0) { a_bool = false;}
			if (b_value == 0) { b_bool = false;}
			if (a_value == 1) { a_bool = true;}
			if (b_value == 1) { b_bool = true;}
			
			out_bool = (a_bool || b_bool);
			if (out_bool == false) {out_value = 0;}
			if (out_bool == true) {out_value = 1;}

			o_it.add(out_value);
		}

		if (a_it.hasNext() || b_it.hasNext()) {throw new IllegalArgumentException("Lists are different lengts.");}
		try{
			BitList a_clone = a;
			BitList b_clone = b;
			a_clone.removeFirst();
			b_clone.removeFirst();
		}
		catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Empty list.");
		}
		return out;

		
	}

	public static BitList and( BitList a, BitList b ) {
		Iterator a_it = a.iterator();
		Iterator b_it = b.iterator();
		BitList out = new BitList();
		Iterator o_it = out.iterator();
		if (a == null || b == null) {throw new IllegalArgumentException("Lists are different lengts.");}
		int a_value = 7;
		int b_value = 7;
		int out_value = 7;
		Boolean a_bool = null;
		Boolean b_bool = null;
		Boolean out_bool = null;
		while (a_it.hasNext() && b_it.hasNext()) {
			a_value = a_it.next();
			b_value = b_it.next();
			if (a_value == 0) { a_bool = false;}
			if (b_value == 0) { b_bool = false;}
			if (a_value == 1) { a_bool = true;}
			if (b_value == 1) { b_bool = true;}
			
			out_bool = (a_bool && b_bool);
			if (out_bool == false) {out_value = 0;}
			if (out_bool == true) {out_value = 1;}

			o_it.add(out_value);
		}

		if (a_it.hasNext() || b_it.hasNext()) {throw new IllegalArgumentException("Lists are different lengts.");}
		try{
			BitList a_clone = a;
			BitList b_clone = b;
			a_clone.removeFirst();
			b_clone.removeFirst();
		}
		catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Empty list.");
		}
		return out;
	}

	public static BitList xor( BitList a, BitList b ) {
		Iterator a_it = a.iterator();
		Iterator b_it = b.iterator();
		BitList out = new BitList();
		Iterator o_it = out.iterator();
		if (a == null || b == null) {throw new IllegalArgumentException("Lists are different lengts.");}
		int a_value = 7;
		int b_value = 7;
		int out_value = 7;
		Boolean a_bool = null;
		Boolean b_bool = null;
		Boolean out_bool = null;
		while (a_it.hasNext() && b_it.hasNext()) {
			a_value = a_it.next();
			b_value = b_it.next();
			if (a_value == 0) { a_bool = false;}
			if (b_value == 0) { b_bool = false;}
			if (a_value == 1) { a_bool = true;}
			if (b_value == 1) { b_bool = true;}
			
			out_bool = (a_bool ^ b_bool);
			if (out_bool == false) {out_value = 0;}
			if (out_bool == true) {out_value = 1;}

			o_it.add(out_value);
		}

		if (a_it.hasNext() || b_it.hasNext()) {throw new IllegalArgumentException("Lists are different lengts.");}
		try{
			BitList a_clone = a;
			BitList b_clone = b;
			a_clone.removeFirst();
			b_clone.removeFirst();
		}
		catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Empty list.");
		}
		return out;
	}
}