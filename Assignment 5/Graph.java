import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    ArrayList<Vertex> vertexList;
    ArrayList<Edge> edgeList;
    int[][] adjList; // 2d array - array of an array
    int[][] matrix;

    // Constructor
    public Graph() {
        vertexList = null;
        edgeList = null;
        adjList = null;
        matrix = null;
    }

    // Parameterized Constructor
    public Graph(ArrayList<Vertex> vList, ArrayList<Edge> eList) {
        vertexList = vList;
        edgeList = eList;
        adjList = new int[vertexList.size() + 1][vertexList.size() + 1]; // +1 for formatting of the matrix
        matrix = new int[vertexList.size() + 1][vertexList.size() + 1];
    }

    // Setting the Graph
    public void setGraph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        vertexList = vertices;
        edgeList = edges;
        adjList = new int[vertexList.size() + 1][vertexList.size() + 1];
        matrix = new int[vertexList.size() + 1][vertexList.size() + 1];
    }

    // Function for finding the shortest path - bellman ford algorithm
    public boolean shortest() {
        for (int i =0; i < vertexList.size() ; i++) {
            for (Edge e: edgeList) {
                relax(e); // e contains first and second vertex along with weight
            }
        }
        for (Edge e: edgeList) {
            if (e.getv2().getValue() > e.getv1().getValue() + e.getWeight()) {
                return false;
            }
        }
        return true;
    }

    // Function for relax - because it starts at infinity it must be "relaxed"
    public void relax(Edge e) {
        if (e.getv2().getValue() > e.getv1().getValue() + e.getWeight()) {
            e.getv2().setValue(e.getv1().getValue() + e.getWeight());
            e.getv2().setPredecessor(e.getv1());
        }
    }

    // Function for finding the path
    public String path(Vertex v) {
        String path = "";
        if (v.getVertexByID() == 1) {
            path += 1;
            return path;
        }
        else {
            path += path(v.getPredecessor()) + " -> " + v.getVertexByID();
        }
        return path;
    }
}