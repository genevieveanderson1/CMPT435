import java.util.ArrayList;
import java.util.*;

public class Resident {
    int id;
    ArrayList<String> hospitalPrefList;
    boolean free; // to determine whether they have been assignmd or not

    public Resident() {
        id = 0;
        hospitalPrefList = new ArrayList<String>();
        free = true;
    }

    public Resident(int id, ArrayList<String> hospitalPrefList) {
        this.id = id;
        this.hospitalPrefList = hospitalPrefList;
        free = true;
    }

    public String toString() {
        String result = "id: " + id + "hospital preferences list: " + Arrays.toString(hospitalPrefList.toArray());
        return result;
    }
}
