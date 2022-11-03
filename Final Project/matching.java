import java.util.*;

public class matching {
    Node[] residents;
    Node[] hospitals;

    // Constructor
    public matching(Node[] residents, Node[] hospitals) {
        this.residents = residents; 
        this.hospitals = hospitals;
    }

    // Function for assigning 
    public void assign() {
        int rIndex = 0; // To keep track of which resident we are on in the resident array
        Node r = residents[0]; // The first resident
        Node h = null;
        while (r.isFree() == true && r.getSize() > 0) {
            String pref = r.getPref().get(0).getName(); // getting the first hospital from the residents preferences
            h = hospitals[Integer.parseInt(pref.substring(1))-1]; // Connecting the residents preference to the actual hospital in the array
            if (!h.isFree()) { // if h is fully subscribed
                // based on h subscribed list, we are going to see whether or not h will be happy with the matches proposed by r (from the data given to us we can figure this out)
                Node worstResident = getWorst(h); // Figuring out the least desired resident in the subscribed list
                h.getSubscribed().remove(worstResident); // Removing the resident from the hospitals subscribed list
            }
            h.getSubscribed().add(r); // Putting the better resident in the worst residents spot
            if (!h.isFree()) {
                Node newWorst = getWorst(h);
                for (int i = h.getPref().indexOf(newWorst) + 1; i < h.getPref().size(); i++) { // Loop for deleting all residents after the found worst resident before
                    String name = h.getPref().get(i).getName(); // get preference array from hospital, getting the resident node, getting the name of the resident from the resident node
                    h.getPref().remove(i); // i is for deleting everything after the new worst resident - removing the resident from the hospitals list 
                    Node succesor = residents[Integer.parseInt(name.substring(1))-1]; // Getting the node to be able to remove it from the list
                    succesor.getPref().remove(h); // removing the hospital from the residents list 
                }            
            }
        }
    }

    // Function for figuring out hospitals least desired resident after the residents propose to the hospitals
    public Node getWorst(Node h) {
        int max = 0; // For tracking the least desired resident of each hospital, whicher index is largest means it is furthest down the list of preferred residents
        ArrayList<Node> sub = h.getSubscribed();
        ArrayList<Node> pref = h.getPref();
        Node worst = null; 
        for (int i = 0; i < sub.size(); i++) {
            Node res = sub.get(i); // getting the list of residents from the subscribed list
            int index = pref.indexOf(res); // Getting the index of the resident we are evaluating
            if (index > max) { // Checking to see if the index is greater than the current least desired index
                max = index;
                worst = res; // Setting the worst node to the least desired resident
            }
        }
        return worst;
    }
}