import java.util.*;

public class Merge {
    
    String[] magicItems;  // Declaring that there is a string array of the magic items
    int comparisons = 0; // Declaring comparisons

    // Merge sort constructor
    public Merge(String[] magicItems) { // String array
        this.magicItems = magicItems; // The string array will be populated with the magic items
    }

    // Thought process
        // First, split array in half until there are "n" many arrays of size 1
        // One level at a time, compare values while merging array
        // Repeat this process until the magic items are fully sorted and there is one complete array

    // The actual splitting and merging
    public void mergeSort(String[] originalA, int startIndex, int endIndex) {
        if (startIndex < endIndex) { 
            int middle = startIndex + (endIndex - startIndex)/2; // Dividing to get middle value
            // Recursion
            mergeSort(originalA, startIndex, middle); // Splitting
            mergeSort(originalA, middle + 1, endIndex); // Splitting
            merge(originalA, startIndex, middle, endIndex); // Merging
            comparisons++;
        }
    }

    // The algorithm for the merging
    public void merge(String[] A, int leftIndex, int middle, int rightIndex) {
        int size1 = middle - leftIndex + 1; // Size of first array
        int size2 = rightIndex - middle; // Size of second array

        // Temporary arrays for merging purposes
        String[] left = new String[size1]; 
        String[] right = new String[size2];

        // Populating the arrays 
        for (int i = 0; i < size1; i++) {
            left[i] = A[i + leftIndex]; // This array starts at 0 and goes to the middle
        }
        for (int j = 0; j < size2; j++) {
            right[j] = A[middle + 1 + j]; // j starts at middle + 1, we are going to add values to the right array starting at index 0
        }

        int i = 0; // Index for left array
        int j = 0; // Index for the right array
        int k = leftIndex; // Index for the "original array"

        while (i < size1 && j < size2) {
            if (left[i].compareTo(right[j]) <= 0) {
                A[k] = left[i]; // Sorting, left array value will be put in the original array if the left value is less than the right value
                i++; // Left array gets incremented if this happens
            }
            else {
                A[k] = right[j]; // Right array value will be put into the original array
                j ++; // Right array gets incremented
            }
            k++; // Something is always getting added to the original array for each pass through of the while loop
            comparisons++; // Counting comparisons here
        }

        // Two while loops to take care of if the arrrays arent the same size, or if we begin with an array with an odd amount of values
        while (i < size1) {
            A[k] = left[i]; 
            i++;
            k++;
        }
        while (j < size2) {
            A[k] = right[j];
            j++;
            k++;
        } 
    }

    // Function for toString
    public String toString() {
        String result = ""; // Initializing result variable as empty
        /*for (int i = 0; i < magicItems.length; i++) { // Beginning at 0; go until the end of magic items; increment by 1
            // Setting result to a string of all of the magic items 
            result += magicItems[i] + "\n"; //+= is adding each result on to the previous result, \n is so that it gets split up by line 
        }*/
        result += "Merge sort comparisons: " + comparisons; // Labeling the comparisons
        return result;
    }
}