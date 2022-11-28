import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class main {
    public static void main(String[] args) {

        ArrayList<Vertex> vertices = new ArrayList<Vertex>(); // vertices that will be provided to the graph 
        ArrayList<Edge> edges = new ArrayList<Edge>(); 

        try { //Trying to find the file
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
                    int weight = 0;
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
                        vertices.get(firstVertex).add(e);
                    }
                }
                else if (parse[0].equals("new") && parse[1].equals("graph")) {   
                    Graph graph = new Graph();
                    graph.setGraph(vertices, edges);
                    graph.shortest();
                    printResults(vertices, graph); // Results
                    vertices.clear(); // So that the graphs aren't added on top of each other
                }
            }
            /* For the last graph
            Graph graph = new Graph();
            graph.setGraph(vertices);
            graph.printResults();
            vertices.clear();   */
        }
        catch (FileNotFoundException e) { // If we cant find the file
            e.printStackTrace();
        }
    }

    public static void printResults(ArrayList<Vertex> vertices, Graph g) {
        for (int i = 1; i < vertices.size(); i ++) {
            System.out.println("1 -> " + vertices.get(i) + " cost is " + vertices.get(i).getValue() + "; path is" + g.path(vertices.get(i)));
        }
    }
}