public class BinarySearch {
    String[] targetArray;
    String[] magicItems;
    int comparisons;

    // Constructor
    public BinarySearch(String[] magicItems, String[] targetArray) {
        this.magicItems = magicItems;
        this.targetArray = targetArray;
        comparisons = 0;
    }

    // Function for Binary Search
    public int binary(String [] A, int start, int stop, String target) {
        int midPoint = (start+stop)/2; // Finding the midpoint
        comparisons++; // Counting comparisons here 
        if (start > stop) {
            // Should I return comparisons or -1?
            return comparisons; // This is so that we know the target was no found because negative indexes dont exist in arrays
        }
        else if (target.equals(A[midPoint])) {
            // Should I return comparisons here or midpoint?
            return comparisons; // midPoint is the index of what we are searching for
        }
        else if (target.compareTo(A[midPoint])<0) {
            return binary(A, start, midPoint, target); // Recursion for the first half of the array
        }
        else {
            return binary(A, midPoint+1, stop, target); // Recursion for the second half of the array
        }
    }

      // Function for toString 
      public String toString() {
        String result = ""; // Initializing result variable as empty
        int totalComparisons = 0;
        for (int i = 0; i < targetArray.length; i++) { // Beginning at 0; go until the end of target array; increment by 1
            totalComparisons += comparisons;
            comparisons = 0;
            result += "\n" + (i+1) + ": target word - " + targetArray[i] + " and the number of comparisons is: " + binary(magicItems, 0, magicItems.length, targetArray[i]);
        }
        double average = ((double)(totalComparisons))/targetArray.length; // dobule for decimal places
        result += "\n Average: =" + average; // Labeling average
        return result;
    }
}