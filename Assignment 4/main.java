import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class main {
    public static void main(String[] args) {
        String[] magicItems = new String[666]; 
        try { //Trying to find the file
            File file = new File("magicitems.txt");
            Scanner sc = new Scanner(file);
            int index = 0; 

            while (sc.hasNextLine()) {
                String item = sc.nextLine(); 
                item = item.toUpperCase();
                magicItems[index ++] = item; 
            }
        }
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }

        //shuffle(magicItems);
        BST tree = new BST();
        tree.setRoot(magicItems[0]); // We can this because the first magic item will always be the root
        for (int i = 1; i < magicItems.length; i++) {
            tree.insert(tree.root, magicItems[i]);
            tree.path(magicItems[i]);
        }
        
        tree.ITW(tree.root);
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