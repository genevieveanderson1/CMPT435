import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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
        System.out.println(insertSort.insertionSort());
        System.out.println(selectionSort.selectionSort());
        System.out.println(quick.quick(magicItems, 0, magicItems.length - 1));


        //Testing quick sort
        //Quick magicItemsQuick = new Quick(magicItems);
        //magicItemsQuick.quick(magicItems, 0, magicItems.length - 1);
        //System.out.println(magicItemsQuick);
    } 
}


