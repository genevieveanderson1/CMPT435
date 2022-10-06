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

        //Testing to see if queue is populating correctly
        //Quick magicItemsQuick = new Quick(magicItems);
        //magicItemsQuick.quick();

        //Testing selection sort
        //Selection magicItemsSelection = new Selection(magicItems);
        //magicItemsSelection.selection();
        //System.out.println(magicItemsSelection);
        //System.out.println(comparisons);

        //Testing insertion sort
        //Insertion magicItemsInsertion = new Insertion(magicItems);
        //magicItemsInsertion.Insertion();
        //System.out.println(magicItemsInsertion); 



        //System.out.println(insertSort.insertionSort()); // Printing comparisons for insertion sort
        //System.out.println(selectionSort.selectionSort()); // Printing comparisons for selection sort

        shuffle(magicItems);
        quick.quick(magicItems, 0, magicItems.length - 1);
        System.out.println(quick); // Printing comparisons for quick sort
        // System.out.println(quick.quick(magicItems, 0, magicItems.length - 1)); // Printing comparisons for quick sort
        shuffle(magicItems);
        merge.mergeSort(magicItems, 0, magicItems.length - 1);
        System.out.println(merge); // Printing comparisons for quick sort


        //Testing quick sort
        //Quick magicItemsQuick = new Quick(magicItems);
        //magicItemsQuick.quick(magicItems, 0, magicItems.length - 1);
        //System.out.println(magicItemsQuick);

        //Testing merge sort
        //Merge magicItemsMerge = new Merge(magicItems);
        //magicItemsMerge.mergeSort(magicItems, 0, magicItems.length - 1);
        //System.out.println(magicItemsMerge);
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


