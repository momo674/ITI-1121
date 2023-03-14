class Test {
	public static void b() {
		RuntimeException e = new RuntimeException("an exception");
		System.out.println("just made an exeption did not throw yet");
		
		if (5 > 1) {
			throw e;
		} else if (1>= 5) {
			throw e;
		}
		System.out.println("I just threw an exception!")
	}
	public static void a(){
		b();
	}
	public static void main(String[] args){
		System.out.println("-1-");
		
		a();
		
		
		System.out.println("-2-");
	}
}