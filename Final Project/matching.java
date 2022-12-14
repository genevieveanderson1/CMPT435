import java.util.*;

public class matching {

    ArrayList<Resident> residents;
    ArrayList<Hospital> hospitals;

    // Constructor
    public matching(ArrayList<Resident> residents, ArrayList<Hospital> hospitals) {
        this.residents = residents; 
        this.hospitals = hospitals;
    }

    // Function for assigning 
    public void assign() {
        Resident r = residents.get(0);      
        while (r.free == true && r.hospitalPrefList.size() > 0) { 
            int id = Integer.parseInt(r.hospitalPrefList.get(0).substring(1)); // Getting the id of the first hospital from the residents preferences
            Hospital h = hospitals.get(id - 1); // Connecting the residents preference to the actual hospital in the array
            if (h.residentAssigned.size() == h.cap) { // if h is fully subscribed
                // Based on h subscribed list, we are going to see whether or not h will be happy with the matches proposed by r
                Resident worstResident = getWorst(h); // Figuring out the least desired resident in the subscribed list
                h.residentAssigned.remove(worstResident); // Removing the resident from the hospitals subscribed list
                worstResident.free = true; // Assign resident to be free
            }           
            System.out.println("Match found! Resident " + r.id + ", " + " Hospital " +  h.id);
            h.residentAssigned.add(r); // Putting the better resident in the worst residents spot
            r.free = false;
            if (h.residentAssigned.size() == h.cap) {
                Resident newWorst = getWorst(h); // Worst resident assigned to hospital
                String f = "r" + newWorst.id;
                String s = "h" + h.id;
                for (int i = h.residentPrefList.indexOf(f) + 1; i < h.residentPrefList.size(); i ++) { // Loop for deleting all residents after the found worst resident                  
                    String succesor = h.residentPrefList.get(i);
                    h.residentPrefList.remove(i); // Remove from hospital
                    residents.get(Integer.parseInt(succesor.substring(1)) - 1).hospitalPrefList.remove(s);           
                }            
            }          
            // Reassess which residents are free
            for (int i = 0; i< residents.size(); i++) {
                if (residents.get(i).free == true) {
                    r = residents.get(i);
                    i = residents.size(); // Stop looping
                }
            }
        }
    }

    // Function for figuring out hospitals least desired resident after the residents propose to the hospitals
    public Resident getWorst(Hospital h) { // Taking in hospital because this is where the list of desired residents is
        Resident worst = null;
        for (int i = h.residentPrefList.size() - 1; i >= 0; i--) { // Starting from the back of the list to find the worst one
            for (int j = 0; j < h.residentAssigned.size(); j++) {
                int id = Integer.parseInt(h.residentPrefList.get(i).substring(1)); // Getting the number for the worst resident
                if (id == h.residentAssigned.get(j).id) { // Going through assigned residents
                    worst = h.residentAssigned.get(j);
                    j = h.residentAssigned.size();
                    i = -1; 
                } 
            }
        }
        return worst;
    }
}