import java.util.*;

public class Hospital {
    int id;
    ArrayList<String> residentPrefList;
    ArrayList<Resident> residentAssigned; // residents assigned to hosp
    int cap; // capacity of hosp

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
