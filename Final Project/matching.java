public class matching {
    Node[] residents;
    Node[] hospitals;

    // Constructor
    public matching(Node[] residents, Node[] hospitals) {
        this.residents = residents; 
        this.hospitals = hospitals;
    }

    public void assign() {
        int rIndex = 0; // To keep track of which resident we are on in the resident array
        Node r = residents[0]; // The first resident
        Node h = null;
        while (r.isFree() == true && r.getSize() > 0) {
            String pref = r.getPref().get(0).getName(); // getting the first hospital from the residents preferences
            h = hopsitals[Integer.parseInt(pref.substring(1)+1)]; // Connecting the residents preference to the actual hospital in the array
            if ()
        }
    }
}
