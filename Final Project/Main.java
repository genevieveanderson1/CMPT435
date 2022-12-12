import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {  
        ArrayList<Resident> residents = new ArrayList<Resident>(); 
        ArrayList<Hospital> hospitals = new ArrayList<Hospital>(); 


        System.out.println("------------------------------ Part 1: Ranked ------------------------------");


        try { //Trying to find the file
            File file = new File("final-project-data.txt");
            Scanner sc = new Scanner(file);


            while (sc.hasNextLine()) {
                String item = sc.nextLine();


                if (item.startsWith("r")) {
                    // index of will find where the colon is in each string - its in different spots each time because sometimes there are double digits
                    int id = Integer.parseInt(item.substring(1,item.indexOf(':'))); // putting r1,...,r11 each in their own resident object
                    String[] resHospPref = null;
                    if (id > 9) {
                        resHospPref = item.substring(5).split(" "); // putting the hospital preferences of the resident into a string array
                    }
                    else {
                        resHospPref = item.substring(4).split(" "); // putting the hospital preferences of the resident into a string array
                    } 
                    ArrayList<String> arrayResHospPref= new ArrayList<String>(); 
                    Collections.addAll(arrayResHospPref, resHospPref); // putting as an array list
                    Resident res = new Resident(id, arrayResHospPref); // creating the instance of a resident
                    residents.add(res); // adding each instance of a resident to the array list which holds all residents
                }


                else if (item.startsWith("h")) {
                    int capacity = Integer.parseInt(item.substring(item.indexOf(':')+2, item.indexOf(':')+3)); // For figuring out what the capacity is for each hospital
                    int id = Integer.parseInt(item.substring(1,item.indexOf(':'))); // Figuring out hospital id
                    String[] hospResPref = item.substring(item.indexOf('-')+2).split(" "); // putting each hospital in its own object
                    ArrayList<String> arrayHospResPref = new ArrayList<String>();
                    Collections.addAll(arrayHospResPref, hospResPref);
                    Hospital hosp = new Hospital(id, arrayHospResPref, capacity); // Adding each instance of a hospital to the array list which holds all hospitals
                    hospitals.add(hosp);
                }
            }
        }
        catch (FileNotFoundException e) { //If we cant find the file
            e.printStackTrace();
        }

        // testing lists
        /*for (int i = 0; i<residents.size(); i++) {
            System.out.println(residents.get(i));
        }
        for (int i = 0; i<hospitals.size(); i++) {
            System.out.println(hospitals.get(i));
        }*/

        matching match = new matching(residents, hospitals);
        match.assign();

        System.out.println("------------------------------ Part 2: Unranked ------------------------------");

        // Unranked

        residents.clear();
        hospitals.clear();

        try { //Trying to find the file
            File file = new File("Unranked.txt");
            Scanner sc = new Scanner(file);


            while (sc.hasNextLine()) {
                String item = sc.nextLine();


                if (item.startsWith("r")) {
                    // index of will find where the colon is in each string - its in different spots each time because sometimes there are double digits
                    int id = Integer.parseInt(item.substring(1,item.indexOf(':'))); // putting r1,...,r11 each in their own resident object
                    String[] resHospPref = null;
                    if (id > 9) {
                        resHospPref = item.substring(5).split(" "); // putting the hospital preferences of the resident into a string array
                    }
                    else {
                        resHospPref = item.substring(4).split(" "); // putting the hospital preferences of the resident into a string array
                    } 
                    ArrayList<String> arrayResHospPref= new ArrayList<String>(); 
                    Collections.addAll(arrayResHospPref, resHospPref); // putting as an array list
                    Resident res = new Resident(id, arrayResHospPref); // creating the instance of a resident
                    residents.add(res); // adding each instance of a resident to the array list which holds all residents
                }


                else if (item.startsWith("h")) {
                    int capacity = Integer.parseInt(item.substring(item.indexOf(':')+2, item.indexOf(':')+3)); // For figuring out what the capacity is for each hospital
                    int id = Integer.parseInt(item.substring(1,item.indexOf(':'))); // Figuring out hospital id
                    Hospital hosp = new Hospital(id, null, capacity); // Adding each instance of a hospital to the array list which holds all hospitals
                    hospitals.add(hosp);
                }
            }
        }
        catch (FileNotFoundException e) { //If we cant find the file
            e.printStackTrace();
        }

        Unranked unranked = new Unranked(residents, hospitals);
        unranked.unrankedAssign();


    }
}