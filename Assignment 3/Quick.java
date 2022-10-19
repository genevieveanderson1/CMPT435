import java.util.*;

public class Quick { 
    String[] magicItems; // Declaring that there is a string array of magic items
    int comparisons = 0; // Declaring comparisons
    
    // Quick sort constructor
    public Quick(String[] magicItems) {
        this.magicItems = magicItems;
    }

    // Thought process
        // First, choose random value as pivot
        // Compare all other values to the pivot and store them in arrays for lesser values, and greater values
        // Repeat this process until the magic items are fully sorted

    // To preseve O(nlogn) I will attempt to choose a pivot which is not the highest or lowest value
    public void choosePivot(String[] A, int low, int high) { // 
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low; // Doesn't allow for pivot value of the highest or lowest value, but rather a random value inbetween
        String temp = A[pivot]; // Setting the temporary variable to pivot
        A[pivot] = A[high]; // Swapping
        A[high] = temp;
    }

    // Function for swapping
    public void swap(String[] A, int lesserIndex, int greaterIndex) { // Array that will be used for swapping, the index of the lesser value, the index of the greater value
        String temp = A[lesserIndex]; // Setting the temporary variable to lesser index
        A[lesserIndex] = A[greaterIndex]; // Swapping 
        A[greaterIndex] = temp; 
    }

    // Function for partition
    // Splitting the magic items around the pivot into lesser and greater arrays 
    public int partition(String[] A, int low, int high) { 
        choosePivot(A, low, high); // Choosing pivot value 
        String pivot = A[high]; // Setting pivot value
        int i = low - 1;
        for (int j = low; j < high; j++) { 
            if (A[j].compareTo(pivot) < 0) { // If the second value is less than the last item in the array (pivot)
                i = i + 1; 
                swap(A, i, j); // Swapping the value located at i, with a smaller value
            }
            comparisons++; // Counting comparisons here
        }
        swap(A, i + 1, high); // Swapping so that the pivot value is where it belongs
        return i + 1;
    }

    // Function for quick sort
    public void quick(String[] originalA, int startIndex, int endIndex) { // Parameters start and end index so that when the array is getting split we can reference where to split
        if (startIndex < endIndex) {
            int split = partition(originalA, startIndex, endIndex);
            // Recursion
            quick(originalA, startIndex, split - 1); // Quick method from 1 to end of the values before the pivot value
            quick(originalA, split+1, endIndex); // Quick method from first value after the pivot to the end of the array
        }
    }

    //Function for toString 
    public String toString() {
        String result = ""; // Initializing result variable as empty
        /*for (int i = 0; i < magicItems.length; i++) { // Beginning at 0; go until the end of magic items; increment by 1
            // Setting result to a string of all of the magic items 
            result += magicItems[i] + "\n"; //+= is adding each result on to the previous result, \n is so that it gets split up by line 
        }*/
        result += "Quick sort comparisons: " + comparisons; // Labeling the comparisons
        return result;
    }  
}
