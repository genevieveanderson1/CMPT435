import java.util.*;

public class Hospital {
    int id; // Hospital id
    ArrayList<String> residentPrefList; // Hospital's list of which residents they prefer
    ArrayList<Resident> residentAssigned; // Residents assigned to hospital
    int cap; // Capacity of hospital

    public Hospital() {
        id = 0;
        residentPrefList = new ArrayList<String>();
        residentAssigned = new ArrayList<Resident>();
        cap = 0;
    }

    public Hospital(int id, ArrayList<String> residentPrefList, int cap) {
        this.id = id;
        this.residentPrefList = residentPrefList;
        residentAssigned = new ArrayList<Resident>();
        this.cap = cap;
    }

    public String toString() {
        String result = "id: " + id + "res pref list: " + Arrays.toString(residentPrefList.toArray());
        return result;
    }
}