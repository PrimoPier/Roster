import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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

        // getters
        public String getFName() {
            return firstName;
        }
        public String getLName() {
            return lastName;
        }
        public String getCollege() {
            return collegeName;
        }
        public int getNum() {
            return numberVal;
        }
        public int getAge() {
            return ageVal;
        }
        public int getWeight() {
            return weightVal;
        }
    }

    public void bubbleSort(int arr[]) {
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

    public void selectSort(String arr[]) {
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

        // create player object
        Player playerObj = new Player();
        
        // store strings
        List<String> rosterStrings = new ArrayList<String>();
        // load content of file
        Scanner scanner = new Scanner(new FileReader("Roster.txt")).useDelimiter(",\\s*");
        String scanString; // value to store string from file

        // check end of file
        while(scanner.hasNext()) {
            scanString = scanner.next();
            // add each string to arraylist
            rosterStrings.add(scanString);
        }

        // convert arraylist to array
        String[] rosterArray = rosterStrings.toArray(new String[100]); // creates new string array with size 100
        System.out.println(playerObj.getFName()); // to test player variables

        // user input menu
        boolean repeat;
        do {
            System.out.println("SELECT OPTION TO FILTER (fname, lname, college, number, age, weight), OR 'X' TO EXIT:");
            menuOpt = scanObj.nextLine().toLowerCase().trim();

            repeat = false;
            switch (menuOpt) {
                case "fname":
                    // selectSort(rosterArray);
                    scanObj.close();
                    break;
                case "lname":
                    // selectSort(rosterArray);
                    scanObj.close();
                    break;
                case "college":
                    // selectSort(rosterArray);
                    scanObj.close();
                    break;
                case "number":
                    // bubbleSort(rosterArray);
                    scanObj.close();
                    break;
                case "age":
                    // bubbleSort(rosterArray);
                    scanObj.close();
                    break;
                case "weight":
                    // bubbleSort(rosterArray);
                    scanObj.close();
                    break;
                case "X":
                case "x":
                    System.out.println("TERMINATING...");
                    break;
                default:
                    System.out.println("INVALID INPUT!");
                repeat = true;
            }
        } while (repeat); // repeats switch if repeat = true
    }
}
