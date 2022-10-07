public class Selection {

    String[] magicItems;  // Declaring that there is a string array
    int comparisons = 0; // Declaring the comparisons

    // Selection sort constructor
    public Selection(String[] magicItems) { 
        this.magicItems = magicItems; // Initializing the string array will be populated with the magic items
    }

    // Function for selection sort 
    public void selectionSort(String[] A) {
        int n = magicItems.length;
        for (int i = 0; i < n - 2; i++) { 
            int smallPosition = i; // Setting small position variable to i
            for (int j = i + 1; j < n; j++) { 
                comparisons ++; // Counting comparisons here
                if (magicItems[j].compareTo(magicItems[smallPosition]) < 0) { // If j is less than smallPostion then small position will be changed
                    smallPosition = j; // small position is now the index of the new smallest value found
                }
            }
            //Swapping the values will require a temporary variable
            String temp = magicItems[smallPosition]; // Setting the temporary variable to the small position
            magicItems[smallPosition] = magicItems[i]; // Swapping 
            magicItems[i] = temp; // Completing the swap, both values will now be where they belong
        }
    }

    // Function for toString - returning what is inside the node rather than the object ID
    // Convert string array to string for printing the sorted list
    public String toString() {
        String result = ""; // Initializing result variable as empty
        /*for (int i = 0; i < magicItems.length; i++) { // Beginning at 0; go until the end of magic items; increment by 1
            // Setting result to a string of all of the magic items 
            result += magicItems[i] + "\n"; //+= is adding each result on to the previous result, \n is so that it gets split up by line 
        }*/
        result += "Selection sort comparisons: " + comparisons;
        return result;
    }  
}
