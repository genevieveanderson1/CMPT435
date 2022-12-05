import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main (String[] args) {  
        Node[] residents = new Node[11]; // 11 residents
        Node[] hospitals = new Node[5]; // 5 hospitals
        int resCap = 0; // initializing to 0
        int hospCap = 0;

        try { //Trying to find the file
            File file = new File("final-project-data.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String item = sc.nextLine();
                if (item.startsWith("r")) {
                    // index of will find where the colon is in each string - its in different spots each time because sometimes there are double digits
                    Node res = new Node(item.substring(0,item.indexOf(':')), null); // putting r1,...,r11 each in their own node
                    residents[resCap++] = res; 
                    item = item.substring(item.indexOf(':')+2); // Go from everything after the colon/ space
                    
                    String[] temp = item.split(" "); // String array of the residents preferences
                    for (int i = 0; i<temp.length; i++) { // We are adding each residents hospital preferences to each residents node
                        Node hospPref = new Node(temp[i], null);
                        res.setPref(hospPref); 
                    }
                }
                else if (item.startsWith("h")) {
                    int capacity = Integer.parseInt(item.substring(item.indexOf(':')+2, item.indexOf(':')+3)); // For figuring out what the capacity is for each hospital, converting string into an integer
                    Node hosp = new Node(item.substring(0,item.indexOf(':')), null, capacity); // putting h1,...,h5 each in their own node
                    hospitals[hospCap++] = hosp; 
                    item = item.substring(item.indexOf('-')+2); // Go from everything after the colon/ space
                    String[] temp = item.split(" "); // String array of the hospitals resident preferences
                    for (int i = 0; i<temp.length; i++) { // We are adding each hospital's resident preferences to each hospital node
                        Node resPref = new Node(temp[i], null);
                        hosp.setPref(resPref); 
                    }
                }

            }
        }
        catch (FileNotFoundException e) { //If we cant find the file
            e.printStackTrace();
        }

        // testing to see if my linked lists are good
        /*for (int i = 0; i<residents.length; i++) {
            System.out.println(residents[i]);
        }
        for (int i = 0; i<hospitals.length; i++) {
            System.out.println(hospitals[i]);
        }*/

        matching match = new matching(residents, hospitals);
        match.assign();
        for (int i = 0; i<residents.length; i++) {
            System.out.println(residents[i]);
        }

    }
}