import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class main {
    public static void main(String[] args) {

        // dynamic programming

        ArrayList<Vertex> vertices = new ArrayList<Vertex>(); // vertices that will be provided to the graph 
        ArrayList<Edge> edges = new ArrayList<Edge>(); 

        /*try { //Trying to find the file
            File file = new File("graphs2.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String item = sc.nextLine(); 
                String[] parse = item.split(" ");
                if (parse[0].equals("add") && parse[1].equals("vertex")) {
                    Vertex v = new Vertex(Integer.parseInt(parse[2])); // Getting the vertex number and creating a new vertex based off of it
                    vertices.add(v); // Adding the vertex to the array list of all the vertices
                }
                else if (parse[0].equals("add") && parse[1].equals("edge")) {
                    int firstVertex = Integer.parseInt(parse[2]); // First vertex the edge will be connected to 
                    int secondVertex = Integer.parseInt(parse[4]); // Second vertex the edge will be connected to
                    int weight = 0; // Initialize weight
                    if (parse[5].equals("")) {
                        weight = Integer.parseInt(parse[6]); // Weight of the edge
                    }
                    else {
                        weight = Integer.parseInt(parse[5]); // Weight of the edge
                    }
                    if (firstVertex == 0) {
                        Edge e = new Edge(vertices.get(firstVertex), vertices.get(secondVertex), weight); // Making an edge
                        edges.add(e); // adding the new edge to the array list of edges
                        vertices.get(firstVertex).add(e); // getting the edges that are correlated with each vertex;
                    }
                    else {
                        Edge e = new Edge(vertices.get(firstVertex - 1), vertices.get(secondVertex - 1), weight);
                        edges.add(e);
                        vertices.get(firstVertex - 1).add(e); 
                    }
                }
                else if (parse[0].equals("new") && parse[1].equals("graph") && vertices.size() > 0) {   
                    Graph graph = new Graph();
                    graph.setGraph(vertices, edges);
                    graph.shortest();
                    System.out.println("------------new graph--------------");
                    printResults(vertices, graph); // Results
                    vertices.clear(); // So that the graphs aren't added on top of each other
                    edges.clear();
                }
            }
            Graph graph = new Graph();
            graph.setGraph(vertices, edges);
            graph.shortest();
            System.out.println("------------new graph--------------");
            printResults(vertices, graph); // Results
            vertices.clear(); // So that the graphs aren't added on top of each other
            edges.clear();
        }
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }*/

        // spices 

        ArrayList<Spice> spices = new ArrayList<Spice>(); // to hold all the spices

        try { //Trying to find the file
            File file = new File("spice.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String item = sc.nextLine(); 
                if (item.startsWith("s")) {
                    String[] parse = item.split(";");
                    String[] color = parse[0].split(" ");
                    String[] totalPrice = parse[1].split(" ");
                    String[] quantity = parse[2].split(" ");
                    String c = color[color.length-1];
                    double tP = Double.parseDouble(totalPrice[totalPrice.length-1]);
                    int q = Integer.parseInt(quantity[quantity.length -1]);

                    Spice s = new Spice(c, tP, q);
                    if (spices.size() == 0) {
                        spices.add(s); // adding spices to the array list
                    }
                    else if (spices.get(0).unitPrice > s.unitPrice) {
                        spices.add(s); // since it is greater than the greatest spice in the list, it should be added in the beginning
                    }
                    else {
                        spices.add(0,s); 
                    }
                }
                else if (item.startsWith("k")) {
                    String[] parse = item.split(" ");
                    int cap = Integer.parseInt(parse[parse.length-1].substring(0,parse[parse.length-1].length()-1)); // parsing to get the knapsack number
                    System.out.println(Arrays.toString(spices.toArray()));
                }
            }
        }
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }
    }

    public static void printResults(ArrayList<Vertex> vertices, Graph g) {
        for (int i = 1; i < vertices.size(); i ++) {
            System.out.println("1 -> " + vertices.get(i) + " cost is " + vertices.get(i).getValue() + "; path is " + g.path(vertices.get(i)));
        }
    }

    public static void greedy(int cap, ArrayList<Spice> spices) {
        
    }
}