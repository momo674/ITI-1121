public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
        long startTime = System.currentTimeMillis();
        if (hourlyRate <= 0){throw new IllegalArgumentException("Hourly rate of arrival is invalid");}
        double avgQueueSize = 0;
        int n = 1;
	    while (true){
            System.out.println("====Setting lot capacity to: " + n +"====");
            for (int x = 0; x<NUM_RUNS; x++){
                Simulator sim = new Simulator(new ParkingLot(n), hourlyRate, 86400); //args[1]
                sim.simulate();
                long runTimeLength = System.currentTimeMillis() - startTime;
                System.out.println("Simulation run " + x + " (" + (runTimeLength) + "ms); " + "Queue Length at the end of simulation run: " + sim.getIncomingQueueSize());
                startTime = System.currentTimeMillis();
                avgQueueSize = avgQueueSize + (double)sim.getIncomingQueueSize();
            }
            avgQueueSize = avgQueueSize / 10;
            if (avgQueueSize <= THRESHOLD){
                return n;
            }
            else{
                n = n+1;
                avgQueueSize = 0;
            }
        }
        
	}

	public static void main(String args[]) {
	    
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();


        
		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}