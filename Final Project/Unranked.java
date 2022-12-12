import java.util.*;

public class Unranked {
    ArrayList<Resident> residents;
    ArrayList<Hospital> hospitals;

    // Constructor
    public Unranked(ArrayList<Resident> residents, ArrayList<Hospital> hospitals) {
        this.residents = residents; 
        this.hospitals = hospitals;
    }

    // Function for assigning 
    public void unrankedAssign() {

        int index = 0;

        // I will be placing residents in their desired hosptials on a first come first serve basis

        for (int i = 0; i < residents.size(); i++ ) { // going through the residents to put them in hospitals
            String firstHospID = residents.get(i).hospitalPrefList.get(0); // getting the first hosptial from the residents list
            Hospital hospital = hospitals.get(Integer.parseInt(firstHospID.substring(1)) - 1); // Getting the number of the hospital
            
            while (hospital.cap == hospital.residentAssigned.size()) { // while the hospital has not reached its capacity
                index++; // moving on to the next hosptial
                firstHospID = residents.get(i).hospitalPrefList.get(index);
                hospital = hospitals.get(Integer.parseInt(firstHospID.substring(1)) - 1); // Getting the number of the hospital
            }

            hospital.residentAssigned.add(residents.get(i)); 
            System.out.println("Match found! Resident " + residents.get(i).id + ", Hospital " + hospital.id); 
        }
    }
}
