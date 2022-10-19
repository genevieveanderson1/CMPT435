import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main (String[] args) {  
        try { //Trying to find the file
            File file = new File("data.txt");
            Scanner sc = new Scanner(file);
            Resident[] residents = new Resident[11];
            Hospital[] hospitals = new Hospital[5];
            int resCap = 0;
            int hospCap = 0;

            while (sc.hasNextLine()) {
                String item = sc.nextLine();
                if (item.startsWith("r")) {
                    item = item.substring(3); // Go from index 3 to the end because thats everything after the colon
                    Resident r = new Resident(item.split(" ")); // Putting the hospitals in an array where each hospitcal is seperate from each other
                    residents[resCap++] = r; 
                }
            }
        }
        catch (FileNotFoundException e) { //If we cant find the file
            e.printStackTrace();
        }
    }
}