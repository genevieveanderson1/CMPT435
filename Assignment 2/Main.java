import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main (String[] args) { 
        String[] magicItems = new String[666]; 
        try { //Trying to find the file
            File file = new File("magicitems.txt");
            Scanner sc = new Scanner(file);
            int index = 0; 

            while (sc.hasNextLine()) {
                String item = sc.nextLine();
                item = item.toUpperCase(); 
                item = item.replaceAll("\\s+",""); 
                Node magicItemsNode = new Node(item, null); 
                magicItems[index ++] = magicItemsNode.getName(); 
            }
        }
       catch (FileNotFoundException e) { //If we cant find the file
            e.printStackTrace();
        }

        Insertion insertSort = new Insertion(magicItems);
        Selection selectionSort = new Selection(magicItems);
        Quick quick = new Quick(magicItems);
        Merge merge = new Merge(magicItems); 

        shuffle(magicItems); // Shuffling
        selectionSort.selectionSort(magicItems); // Running the algorithm
        System.out.println(selectionSort); // Printing the comparisons

        shuffle(magicItems);
        insertSort.insertionSort(magicItems);
        System.out.println(insertSort);

        shuffle(magicItems);
        quick.quick(magicItems, 0, magicItems.length - 1);
        System.out.println(quick); 

        shuffle(magicItems);
        merge.mergeSort(magicItems, 0, magicItems.length - 1);
        System.out.println(merge); 
    } 

    // Shuffle function
    // Will be called prior to each sort being ran
    public static void shuffle(String[] magicItems){
        Random random = new Random();
        for (int i = magicItems.length - 1; i > 0; i--) { // Shuffling beginning from the last element
            int randInt = random.nextInt(i+1); // Choosing a random index for the shuffling
            String temp = magicItems[i]; // Setting the temporary variable to magicItems[i] to prepare for swap
            magicItems[i] = magicItems[randInt]; // Swapping
            magicItems[randInt] = temp;
        }
    }
}

/*
Code from when I was testing my sorts

Quick magicItemsQuick = new Quick(magicItems);
magicItemsQuick.quick(magicItems, 0, magicItems.length - 1);
System.out.println(magicItemsQuick);

Merge magicItemsMerge = new Merge(magicItems);
magicItemsMerge.mergeSort(magicItems, 0, magicItems.length - 1);
System.out.println(magicItemsMerge);

Selection magicItemsSelection = new Selection(magicItems);
magicItemsSelection.selection();
System.out.println(magicItemsSelection);

Insertion magicItemsInsertion = new Insertion(magicItems);
magicItemsInsertion.Insertion();
System.out.println(magicItemsInsertion);*/