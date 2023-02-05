import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
  /**
   * The delimiter that separates values
   */
  private static final String SEPARATOR = ",";

  /**
   * The delimiter that separates the parking lot design section from the parked
   * car data section
   */
  private static final String SECTIONER = "###";

  /**
   * Instance variable for storing the number of rows in a parking lot
   */
  private int numRows;

  /**
   * Instance variable for storing the number of spaces per row in a parking lot
   */
  private int numSpotsPerRow;

  /**
   * Instance variable (two-dimensional array) for storing the lot design
   */
  private CarType[][] lotDesign;

  /**
   * Instance variable (two-dimensional array) for storing occupancy information
   * for the spots in the lot
   */
  private  Car[][] occupancy;
  private int empty_row_counter;

  /**
   * Constructs a parking lot by loading a file
   * 
   * @param strFilename is the name of the file
   */
  public ParkingLot(String strFilename) throws Exception {
    if (strFilename == null) {
      System.out.println("File name cannot be null.");
      return;
    } else {

    }
    calculateLotDimensions(strFilename);
    populateFromFile(strFilename);
  }

  /**
   * Parks a car (c) at a give location (i, j) within the parking lot.
   * 
   * @param i is the parking row index
   * @param j is the index of the spot within row i
   * @param c is the car to be parked
   */
  public void park(int i, int j, Car c) {this.occupancy[i][j] = c;}

  /**
   * Removes the car parked at a given location (i, j) in the parking lot
   * 
   * @param i is the parking row index
   * @param j is the index of the spot within row i
   * @return the car removed; the method returns null when either i or j are out
   *         of range, or when there is no car parked at (i, j)
   */
  public Car remove(int i, int j) {
    if (i > numRows - 1 || j > numSpotsPerRow - 1) {return null;}
    else if (this.occupancy[i][j] == null) {return null;}
    else {
      Car removed_car = this.occupancy[i][j];
      this.occupancy[i][j] = null;
      return removed_car;
    }
  }

  /**
   * Checks whether a car (which has a certain type) is allowed to park at
   * location (i, j)
   * 
   * @param i is the parking row index
   * @param j is the index of the spot within row i
   * @return true if car c can park at (i, j) and false otherwise
   */
  public boolean canParkAt(int i, int j, Car c) {
    if (i > numRows - 1 || j > numSpotsPerRow - 1) {
      System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
      return false;
    }
    if (this.lotDesign[i][j] == CarType.NA) {
      System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
      return false;
    }
    if (this.occupancy[i][j] != null) {
      System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
      return false;
    } else {
      if (c.getType() == CarType.NA) {
        System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
        return false;
      } else if (c.getType() == CarType.SMALL) {
        if (this.lotDesign[i][j] == CarType.SMALL || this.lotDesign[i][j] == CarType.REGULAR
            || this.lotDesign[i][j] == CarType.LARGE) {
          return true;
        } else {
          System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
          return false;
        }
      } else if (c.getType() == CarType.ELECTRIC) {
        if (this.lotDesign[i][j] == CarType.ELECTRIC) {
          return true;
        } else {
          System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
          return false;
        }
      } else if (c.getType() == CarType.LARGE) {
        if (this.lotDesign[i][j] == CarType.LARGE) {
          return true;
        } else {
          System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
          return false;
        }
      } else if (c.getType() == CarType.REGULAR) {
        if (this.lotDesign[i][j] == CarType.LARGE || this.lotDesign[i][j] == CarType.REGULAR) {
          return true;
        } else {
          System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
          return false;
        }
      }
      System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ")" + " cannot be parked at (" + i + ", " + j + ")");
      return false;
    }
  }

  /**
   * @return the total capacity of the parking lot excluding spots that cannot be
   *         used for parking (i.e., excluding spots that point to CarType.NA)
   */
  public int getTotalCapacity() {
    int nacount = 0;
    for (int i = 0; i < (this.lotDesign).length; i++){
      for (int j = 0; j < (this.lotDesign[i]).length; j++){
        if (this.lotDesign[i][j] == CarType.NA) {nacount++;}
      }
    }
    int total = ((this.numRows * this.numSpotsPerRow) - nacount);
    return total;

  }

  /**
   * @return the total occupancy of the parking lot (i.e., the total number of
   *         cars parked in the lot)
   */
  public int getTotalOccupancy() {
    int count = 0;
    for (int i = 0; i < occupancy.length; i++) {
      for (int j = 0; j < occupancy[i].length; j++) {
        if (occupancy[i][j] != null) {
          count++;
        }
      }
    }
    return count; 
  }

  
/**
calculateLotDimensions method determines the numRows (Rows) and the numSpotsPerRow(Col) by:
1.opening the file and reading how many lines there are in the matrix until the line equals the sectioner variable (loop)
2. after gaining the numRows, we loop through one row to determine how many columns there are since we can assume are texts given to us will be rectangular.
3.we then set the variables to the gained values.
**/
  private void calculateLotDimensions(String strFilename) throws Exception {
    // instance variables
    this.numRows = 0;
    this.numSpotsPerRow = 0;
    this.empty_row_counter = 0;
    String row, rowToRead;

    // file scanner
    Scanner scanner = new Scanner(new File(strFilename));
    row = scanner.nextLine();
    rowToRead = row;

    // row counter
    while ((row.equals(SECTIONER) == false)) {
      if (row.equals("") == true) {
        empty_row_counter++;
      }
      this.numRows++;
      row = scanner.nextLine();
    }

    // column counter

    for (int i = 0; i < rowToRead.length(); i++) {
      if (rowToRead.charAt(i) == 'E' || rowToRead.charAt(i) == 'S' || rowToRead.charAt(i) == 'R'
          || rowToRead.charAt(i) == 'L' || rowToRead.charAt(i) == 'N') {
        this.numSpotsPerRow++;
      }
    }

    scanner.close();
    // final variables
    this.numRows -= this.empty_row_counter;
  }

  
  
/**
populateFromFile method does the following:
1. opens file and reads the text letters to convert into a string array which will then be turned into the initalization of lotdesign array
this is done by using a while loop to see if the line has a line after it to read the file.

2. after creating lot design array, we continue to repeat the same for a new string array that will be then converted into occupancy array by seeing where the cars at the bottom of the file want to be parked.
**/
  private void populateFromFile(String strFilename) throws Exception {
    File parking = new File(strFilename);
    Scanner myReader = new Scanner(parking);
    String line;
    
    // creating lot design (String version).
    String[] line_into_array;
    String[][] indexing_array = new String[this.numRows][this.numSpotsPerRow];
    int count = 0;

    // PROCESS TO CREATE STRING LOT DESIGN
    while (myReader.hasNextLine()) {
      line = myReader.nextLine();
      if (line.equals("")) {
        line = myReader.nextLine();
      } else if (line.equals("###")) {
        break;
      }
      if (line.equals("###")) {
        break;
      }
      line_into_array = line.split("\\s+");
      for (int i = 0; i < this.numSpotsPerRow; i++) {
        indexing_array[count][i] = line_into_array[i];
      }
      count++;
    }

    // TURNING STRING LOT DESIGN DATA INTO LOTDESIGN ARRAY

    this.lotDesign = new CarType[this.numRows][this.numSpotsPerRow];
    for (int x = 0; x < this.numRows; x++) {
      for (int y = 0; y < this.numSpotsPerRow; y++) {
        if (indexing_array[x][y].contains("S")) {
          this.lotDesign[x][y] = CarType.SMALL;
        } else if (indexing_array[x][y].contains("E")) {
          this.lotDesign[x][y] = CarType.ELECTRIC;
        } else if (indexing_array[x][y].contains("R")) {
          this.lotDesign[x][y] = CarType.REGULAR;
        } else if (indexing_array[x][y].contains("L")) {
          this.lotDesign[x][y] = CarType.LARGE;
        } else if (indexing_array[x][y].contains("N")) {
          this.lotDesign[x][y] = CarType.NA;
        }
      }
    }

    
    //creating occupancy array
    this.occupancy = new Car[this.numRows][this.numSpotsPerRow];
    while (myReader.hasNextLine()) {
        line = myReader.nextLine();
        // System.out.println(line);
        if (line.equals("")) {
          line = myReader.nextLine();
        }
        line_into_array = line.split("\\s+");
        for (int r = 0; r < line_into_array.length; r++) {
          String unformated_string = line_into_array[r];
          String formated_string = unformated_string.replace(",", "");
          line_into_array[r] = formated_string;
        }
      //Now we have an array of four items, [0] - row index [1] - col index [2] CarType [3] platenumber
        int index_row = Integer.valueOf(line_into_array[0]); 
        int index_col = Integer.valueOf(line_into_array[1]);
        CarType cartype = Util.getCarTypeByLabel(line_into_array[2]);
        String platenumber = line_into_array[3];
      
      //creating car varrable of type car, if it can park at it's spot, it will call the park method
        Car current_car = new Car(cartype, platenumber);
        if (canParkAt(index_row, index_col, current_car)) {
          park(index_row, index_col, current_car);
        }
        
    }

    
  

  // /**
  // * Produce string representation of the parking lot
  // *
  // * @return String containing the parking lot information
  // */
  }
  
  public String toString() {
    // NOTE: The implementation of this method is complete. You do NOT need to
    // change it for the assignment.
    StringBuffer buffer = new StringBuffer();
    buffer.append("==== Lot Design ====").append(System.lineSeparator());

    for (int i = 0; i < lotDesign.length; i++) {
      for (int j = 0; j < lotDesign[0].length; j++) {
        buffer.append(
            (lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j]) : Util.getLabelByCarType(CarType.NA));
        if (j < numSpotsPerRow - 1) {
          buffer.append(", ");
        }
      }
      buffer.append(System.lineSeparator());
    }

    buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

    for (int i = 0; i < occupancy.length; i++) {
      for (int j = 0; j < occupancy[0].length; j++) {
        buffer.append("(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
        buffer.append(System.lineSeparator());
      }

    }
    return buffer.toString();
  }


  /**
   * <b>main</b> of the application. The method first reads from the standard
   * input the name of the file to process. Next, it creates an instance of
   * ParkingLot. Finally, it prints to the standard output information about the
   * instance of the ParkingLot just created.
   * 
   * @param args command lines parameters (not used in the body of the method)
   * @throws Exception
   */
  public static void main(String args[]) throws Exception {

    StudentInfo.display();

    System.out.print("Please enter the name of the file to process: ");

    Scanner scanner = new Scanner(System.in);

    String strFilename = scanner.nextLine();

    ParkingLot lot = new ParkingLot(strFilename);

    

    System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

    System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

    System.out.print(lot);

  }
}