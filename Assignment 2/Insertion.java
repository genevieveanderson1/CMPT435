public class Insertion {

    String[] magicItems;  // Declaring that there is a string array of the magic items
    int comparisons = 0; // Declaring comparisons

    // Constructor for insertion sort
    public Insertion(String[] magicItems) { // String array
        this.magicItems = magicItems; // The string array will be populated with the magic items
    }

    // Function for insertion sort 
    public void insertionSort(String[] A) {
        int size = magicItems.length;
        for (int i = 1; i < size; i++) { 
            int j = i - 1; 
            String smallPosition = magicItems[i]; 
            // Moving elements that are larger than the smallPosition to one position in front of where it currently is
            while (j >= 0 && smallPosition.compareTo(magicItems[j]) < 0) { // Comparing the small position to the magic items,  Checks if j is >= 0 prior
                magicItems[j + 1] = magicItems[j];
                j--;  
                comparisons ++;
            }
            // After determining the correct order of values, things need to get shifted
            magicItems[j+1] = smallPosition; 
        } 
    }

    // Function for to string 
    public String toString() {
        String result = ""; // Setting a string equal to what is inside the node
        /*for (int i = 0; i < magicItems.length; i++) {
            result += magicItems[i] + "\n"; // += is adding each result on to the previous result, \n is so that it gets split up by line 
        }*/
        result += "Insertion sort comparisons: " + comparisons;
        return result;
    }
}

/*Original code that didn't work 

        for (int i = 0; i < n - 1; i++) { 
            int smallPosition = i;
            String minValue = magicItems[smallPosition];
            int minIndex = i; // Setting this to i because it is where the loop is beginning
            for (int j = i; j < n - 1; j++) {
                if (magicItems[j].compareTo(minValue) < 0) { // Comparing j to all values, and determining whether or not it is the minimum value in the string of values
                    minValue = magicItems[j];
                    minIndex = j;
                }
            }
            // After determining the correct order of values, things need to get shifted
            for (int k = i; k < magicItems.length - 1; k++) { //
                magicItems[k] = magicItems[k++];  
            }
            magicItems[i] = magicItems[minIndex]; // Moving the smallest value to the front
        }

Programming lab help
Changed my code above to follow this format

        for (int i = 1; i < n; i++) {
            String key = magicItems[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(magicItems[j]) < 0) { 
                magicItems[j + 1] = magicItems[j];
                j--;
            }
            magicItems[j + 1] = key;
        }*/