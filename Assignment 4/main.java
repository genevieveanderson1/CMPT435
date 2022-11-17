import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class main {
    public static void main(String[] args) {
        // BST code
        /*String[] magicItems = new String[666]; 
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

        String[] magicItemsFind = new String[42];
        try { //Trying to find the file
            File file = new File("magicitems-find-in-bst.txt");
            Scanner sc = new Scanner(file);
            int index = 0; 
            while (sc.hasNextLine()) {
                String item = sc.nextLine(); 
                item = item.toUpperCase();
                magicItemsFind[index ++] = item; 
            }
        }
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }
        BST tree = new BST();
        tree.setRoot(magicItems[0]); // We can do this because the first magic item will always be the root
        for (int i = 0; i < magicItems.length; i++) {
            tree.insert(tree.root, magicItems[i]);
            tree.path(magicItems[i]);
        }
        tree.average(tree.totalComparisons, magicItems.length);
        System.out.println("-----------------------Inserting the magic items done, now searching for the targets!------------------------");
        for (int i = 0; i < magicItemsFind.length; i++) { // Finding the target list in the bst
            tree.find(tree.root, magicItemsFind[i]);
            tree.findPath(magicItemsFind[i]);
        }
        tree.average(tree.findTotalComparisons, magicItemsFind.length);
        tree.ITW(tree.root);

*/

        // Graph codes now
        ArrayList<Vertex> vertices = new ArrayList<Vertex>(); // vertices that will be provided to the graph 

        try { //Trying to find the file
            File file = new File("graphs1.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String item = sc.nextLine(); 
                String[] parse = item.split(" ");
                if (parse[0].equals("add") && parse[1].equals("vertex")) {
                    Vertex v = new Vertex(Integer.parseInt(parse[2])); // Getting the vertex number and creating a new vertex based off of it
                    vertices.add(v); // adding the vertex to the array list of all the vertices
                }
                else if (parse[0].equals("add") && parse[1].equals("edge")) {
                    int firstVertex = Integer.parseInt(parse[2]); // First vertex the edge will be connected to 
                    int secondVertex = Integer.parseInt(parse[4]); // Second vertex the edge will be connected to
                    if (firstVertex == 0) {
                        vertices.get(firstVertex).add(vertices.get(secondVertex)); // Correlating the edges to the vertices array of all the vertices
                        vertices.get(secondVertex).add(vertices.get(firstVertex)); // Same as above, but vice versa so they are connected both ways
                    }
                    else {
                        vertices.get(firstVertex - 1).add(vertices.get(secondVertex - 1)); // Correlating the edges to the vertices array of all the vertices
                        vertices.get(secondVertex - 1).add(vertices.get(firstVertex - 1)); // Same as above, but vice versa so they are connected both ways
                    }
                }
                else if (parse[0].equals("new") && parse[1].equals("graph")) {   
                    Graph graph = new Graph();
                    graph.setGraph(vertices);
                    graph.matrix();
                    graph.adjList();
                    graph.printResults();
                    if (vertices.isEmpty() ==  false) {
                        System.out.println("-------------------------------------Below is the depth first traversal-------------------------------------");
                        graph.DFS(vertices.get(0));
                        graph.resetTraversal();
                        System.out.println("-------------------------------------Below is the breadth first traversal-------------------------------------");
                        graph.BFS(vertices.get(0));
                    } 
                    vertices.clear();
                }
            }
            // For the last graph
            Graph graph = new Graph();
            graph.setGraph(vertices);
            graph.matrix();
            graph.adjList();
            graph.printResults();
            if (vertices.isEmpty() ==  false) {
                System.out.println("-------------------------------------Below is the depth first traversal-------------------------------------");
                graph.DFS(vertices.get(0));
                graph.resetTraversal();
                System.out.println("-------------------------------------Below is the breadth first traversal-------------------------------------");
                graph.BFS(vertices.get(0));
            } 
            vertices.clear();   
        }
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }
    }
}