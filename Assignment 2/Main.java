import java.io.File;
import java.io.FileNotFoundException;
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

        //Testing to see if queue is populating correctly
        Quick magicItemsQuick = new Quick(magicItems);
        magicItemsQuick.quick();

        /*Testing selection sort
        Selection magicItemsSelection = new Selection(magicItems);
        magicItemsSelection.selection();
        System.out.println(magicItemsSelection);

        //Testing insertion sort
        Insertion magicItemsInsertion = new Insertion(magicItems);
        magicItemsInsertion.Insertion();
        System.out.println(magicItemsInsertion); */
    } 
}


