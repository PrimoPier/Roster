import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    // player class
    public static class Player {
        private String firstName;
        private String lastName;
        private String collegeName;

        private int numberVal;
        private int ageVal;
        private int weightVal;

        public Player(String firstName, String lastName, int numberVal, int weightVal, int ageVal, String collegeName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.numberVal = numberVal;
            this.weightVal = weightVal;
            this.ageVal = ageVal;
            this.collegeName = collegeName;
        }
        public String toString() {
            return this.firstName;
        }
        public String getFName() {
            return firstName;
        }
    }

    public static void bubbleSort(int[] arr) {
        // temporary storage value
        int temp;
        // sorting
        for (int i=arr.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // print arr[]
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void selectSort(String[] arr) {
        // sorting
        for(int i=0; i<arr.length-1; i++) {
            // find min element, put into string
            int min = i;
            String minStr = arr[i];

            for (int j=i+1; j<arr.length; j++) {
                if (arr[j].compareTo(minStr) < 0) {
                    minStr = arr[j];
                    min = j;
                }
            }
            // swap min and first element
            if (min != i) {
                String temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        // print arr[]
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String menuOpt;
        // create scanner object
        Scanner scanObj = new Scanner(System.in);
        
        try {
            // open file
            FileInputStream fileInput = new FileInputStream("Roster.txt");
            Scanner scanner = new Scanner(fileInput);
            
            int j=0;
            Player[] rosterArray = new Player[100];

            // returns true if there is another line to read
            while(scanner.hasNextLine()) {
                String[] scanString = scanner.nextLine().trim().split("\\s+");
                // System.out.println(Arrays.toString(scanString)); // prints full roster to test values
                rosterArray[j] = new Player(scanString[0], scanString[1], Integer.parseInt(scanString[2]), Integer.parseInt(scanString[5]), Integer.parseInt(scanString[6]), scanString[8]);
                j++;
            }
            scanner.close();

        // user input menu
        boolean repeat;
        do {
            System.out.println("SELECT OPTION TO FILTER (fname, lname, college, number, age, weight), OR 'X' TO EXIT:");
            menuOpt = scanObj.nextLine().toLowerCase().trim();

            repeat = false;
            switch (menuOpt) {
                case "fname":
                    String[] rosterString = new String[100];
                    for(int i=0; i<j; i++) {
                        rosterString[i] = rosterArray[i].getFName();
                    }
                    selectSort(rosterString);
                    break;
                case "lname":
                    // selectSort(rosterArray);
                    break;
                case "college":
                    // selectSort(rosterArray);
                    break;
                case "number":
                    // bubbleSort(rosterArray);
                    break;
                case "age":
                    // bubbleSort(rosterArray);
                    break;
                case "weight":
                    // bubbleSort(rosterArray);
                    break;
                case "x":
                    System.out.println("TERMINATING...");
                    break;
                default:
                    System.out.println("INVALID INPUT!");
                repeat = true;
            }
        } while (repeat); // repeats switch if repeat = true
        } catch(IOException exception) {
        exception.printStackTrace();
        }
    }
}
