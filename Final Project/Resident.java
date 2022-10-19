public class Resident {
    Hospital [] residencyRank;
    int rankSize; 

    // Constructor - starting with an empty list
    public Resident() {
        rankSize = 5; // 5 hospitals
        residencyRank = new Hospital[rankSize];
    }

    // Parameterized constructor - if the data were to change
    public Resident(Hospital [] ranking) {
        residencyRank = ranking;
    }

}
