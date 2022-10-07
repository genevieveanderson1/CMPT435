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

        //Prior to each sort being run, I will shuffle the list of magic items 


        shuffle(magicItems);
        selectionSort.selectionSort(magicItems);
        System.out.println(selectionSort);

        shuffle(magicItems);
        insertSort.insertionSort(magicItems);
        System.out.println(insertSort);

        shuffle(magicItems);
        quick.quick(magicItems, 0, magicItems.length - 1);
        System.out.println(quick); // Printing comparisons for quick sort
        // System.out.println(quick.quick(magicItems, 0, magicItems.length - 1)); // Printing comparisons for quick sort
        shuffle(magicItems);
        merge.mergeSort(magicItems, 0, magicItems.length - 1);
        System.out.println(merge); // Printing comparisons for merge sort
    } 

    public static void shuffle(String[] magicItems){
        Random random = new Random();
        for (int i = magicItems.length - 1; i > 0; i--) {
            int randInt = random.nextInt(i+1);
            String temp = magicItems[i];
            magicItems[i] = magicItems[randInt];
            magicItems[randInt] = temp;
        }
    }
}

//System.out.println(insertSort.insertionSort()); // Printing comparisons for insertion sort
//System.out.println(selectionSort.selectionSort()); // Printing comparisons for selection sort

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