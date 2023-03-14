class Test2 {
    public static boolean error() {
        if ( true ) {
			System.out.println( "PENISPENISPENISPENISPENIS" );
            throw new RuntimeException( "an Exception" );
		}
        return false;
    }
    
    public static boolean display() {
        System.out.println( "-2-" );
        return true;
    }
    
    public static void main( String[] args ) {
        System.out.println( "-1-" );
        if ( error() || display() ) {
            System.out.println( "-3-" );
        }
        
        System.out.println( "-4-" );
    }
}