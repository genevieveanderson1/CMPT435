import java.util.*;

public class Merge {
    
    String[] magicItems;  // Declaring that there is a string array of the magic items

    // Constructor
    public Merge(String[] magicItems) { // String array
        this.magicItems = magicItems; // The string array will be populated with the magic items
    }

    public void mergeSort(String[] originalA, int startIndex, int endIndex) {
        String[] A = Arrays.copyOfRange(originalA, startIndex, endIndex);
        if (A.length > 1) {
            int middle = A.length/2;
            mergeSort(A, startIndex, middle);
            mergeSort(A, middle + 1, A.length - 1);
            merge(A, middle);
        }
    }

    public void merge(String[] A, int endIndex) {
        int firstIndex = 1;
        //int secondIndex = A;
    }




    // I dont know if any of this is right

    // Function for merging the string arrays
    public void merge(int String[], int aBeg, int aEnd, int bEnd) {

        // Determining the size of the string arrays that will be merged
        int s1 = aEnd - aBeg + 1; //String array 1
        int s2 = bEnd - aEnd; //String array 2

        // Temporary arrays to store lesser and greater
        int lesser[] = new int[s1]; // Why am I indexing s1 if s2 could also potentially have a lesser value?
        int greater[] = new int[s2];

        // Populating the temporary string arrays
        for (int i = 0; i < s1; ++i) { // Is ++i the same as i++
            lesser[i] = String[aBeg+i];
        }
        for (int j = 0; j < s2; ++j) {
            greater[j] = String[aEnd + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = aBeg;
        while (i < s1 && j < s2) {
            if (lesser[i] < greater[j]) {
                String[k] = lesser[i];
                i++;
            }
            else {
                String[k] = greater[j];
                j++;
            }
            k++;
        }

        while (i < s1) {
            String[k] = lesser[i];
            i++;
            k++;
        }
    }
}
