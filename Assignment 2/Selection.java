public class Selection {

    String[] magicItems;  // Declaring that there is a string array
    int comparisons = 0; 

    // Selection sort constructor
    public Selection(String[] magicItems) { 
        this.magicItems = magicItems; // Initializing the string array will be populated with the magic items
    }

    // Function for selection sort 
    public int selectionSort() {
        int n = magicItems.length;
        for (int i = 0; i < n - 2; i++) { // Begin at 0; go until n - 2; increment by 1
            int smallPosition = i; // Setting small position variable to i
            for (int j = i + 1; j < n; j++) { // Begin at i (small position); go until n - 1; increment by 1

                comparisons ++; // also counting comparisons here
                if (magicItems[j].compareTo(magicItems[smallPosition]) < 0) { // If j is less than smallPostion then it will return a negative output
                    smallPosition = j; // Setting the small position variable to j if ......
                }
            }
            //Swapping the values will require a temporary variable
            String temp = magicItems[smallPosition]; // Setting the temporary variable to i because i is the small position
            magicItems[smallPosition] = magicItems[i]; // Swapping 
            magicItems[i] = temp; // Completing the swap, both values will be where they belong
        }

        return comparisons;
    }

    //Function for toString - returning what is inside the node rather than the object ID
    //Convert string array to string for printing the sorted list
    public String toString() {
        String result = ""; // Initializing result variable as empty
        for (int i = 0; i < magicItems.length; i++) { // Beginning at 0; go until the end of magic items; increment by 1
            // Setting result to a string of all of the magic items 
            result += magicItems[i] + "\n"; //+= is adding each result on to the previous result, \n is so that it gets split up by line 
        }
        return result;
    }  

    // Need something to print the number of comparisons
}
