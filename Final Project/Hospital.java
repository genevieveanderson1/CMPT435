public class Hospital {
    String [] hospitalRank; // the hospitals ranking of the residents
    String name; 
    int capacity; 

    // Constructor - starting with an empty list
    public Hospital() {
        capacity = 11; // 11 residents
        hospitalRank = new String[capacity];
    }

    // Parameterized constructor - if the data were to change
    public Hospital(String [] ranking) {
        hospitalRank = ranking;
    }
    
}
