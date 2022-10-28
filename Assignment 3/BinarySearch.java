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

    // need to know the index of the value being searched
    // If it is found, where is it?
    // binary search return int that is the index of the array where the target was found
    // dont modify the array
    // only modify the index of where we start and stop


    // Function for Binary Search
    public int binary(String [] A, int start, int stop, String target) {
        int midPoint = (start+stop)/2; // Finding the midpoint - Alan said to do floor
        comparisons++; // Counting comparisons here 
        if (start > stop) {
            return -1; // This is so that we know the target was no found because negative indexes dont exist in arrays
        }
        else if (target.equals(A[midPoint])) {
            // Should I return comparisons here or midpoint?
            return midPoint; // midPoint is the index of what we are searching for
        }
        else if (target.compareTo(A[midPoint])<0) {
            return binary(A, start, midPoint, target); // Recursion for the first half of the array
        }
        else { // It wasnt the other scenarios so the target must be larger than the midpoint or not there at all - right?
            return binary(A, midPoint + 1, stop, target); // Recursion for the second half of the array
        }
    }

      // Function for toString 
      public String toString() {
        String result = ""; // Initializing result variable as empty
        int totalComparisons = 0;
        for (int i = 0; i < targetArray.length; i++) { // Beginning at 0; go until the end of target array; increment by 1
            totalComparisons += comparisons;
            comparisons = 0;
            result += "\n" + (i+1) + ": target word: " + targetArray[i] + " which was found at index:  " + binary(magicItems, 0, magicItems.length, targetArray[i]) + " and the number of comparisons is: " + comparisons;
        }
        double average = ((double)(totalComparisons))/targetArray.length; // dobule for decimal places
        result += "\n Average: =" + String.format("%.2f", average); // Labeling average
        return result;
    }
}