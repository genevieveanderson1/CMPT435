public class Linear {
    String[] targetArray;
    String[] magicItems;
    int comparisons;

    // Constructor
    public Linear(String[] magicItems, String[] targetArray) {
        this.magicItems = magicItems;
        this.targetArray = targetArray; // 42 items
        comparisons = 0; // Initialize comparisons
    }

    // Function for linear search
    public int linear(String target) {
        for (int j = 0; j < magicItems.length; j++) { // Loop through all the magic items
            if (target.equals(magicItems[j])) {
                j = magicItems.length; // Ends loop without break statement - the loop goes while j is less than the magic items length
            }
            comparisons++;
        }
        return comparisons;
    }

    // Function for toString 
    public String toString() {
        String result = ""; // Initializing result variable as empty
        int totalComparisons = 0;
        for (int i = 0; i < targetArray.length; i++) { // Beginning at 0; go until the end of target array; increment by 1
            totalComparisons += comparisons;
            comparisons = 0;
            result += "\n" + (i+1) + ": target word: " + targetArray[i] + " and the number of comparisons is: " + linear(targetArray[i]);
        }
        double average = ((double)(totalComparisons))/targetArray.length; // Dobule for decimal places
        result += "\n Average: =" + String.format("%.2f", average); // Labeling average
        return result;
    }
}