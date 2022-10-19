import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
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
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }

        Quick quick = new Quick(magicItems);

        quick.quick(magicItems, 0, magicItems.length - 1);

        String[] targetArray = new String[42]; // String array with 42 items

        for (int i = 0; i < targetArray.length; i++) {
            Random random = new Random();
            int randInt = random.nextInt(magicItems.length); // idk if this is choosing repreats - is that okay?
            targetArray[i] = magicItems[randInt]; // Randomly choosing the items we are going to search for in the binary search
            // System.out.println(targetArray[i]); Printing the value that will be searched
        }

        Linear linear = new Linear(magicItems, targetArray);
        System.out.println(linear);
        // Notice that some comparisons are much higher than others
        // The phrases that start with "A" have much smaller number of comparisons since we alphabetically sorted the list prior to searching

        quick.quick(magicItems, 0, magicItems.length - 1);

        BinarySearch binary = new BinarySearch(magicItems, targetArray);
        System.out.println(binary);
    }
}