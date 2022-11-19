import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    ArrayList<Vertex> vertexList;
    int[][] adjList; // 2d array - array of an array
    int[][] matrix;

    // Constructor
    public Graph() {
        vertexList = null;
        adjList = null;
        matrix = null;
    }

    // Parameterized Constructor
    public Graph(ArrayList<Vertex> vList) {
        vertexList = vList;
        adjList = new int[vertexList.size() + 1][vertexList.size() + 1]; // +1 for formatting of the matrix
        matrix = new int[vertexList.size() + 1][vertexList.size() + 1];
    }

    // Setting the Graph
    public void setGraph(ArrayList<Vertex> vertices) {
        vertexList = vertices;
        adjList = new int[vertexList.size() + 1][vertexList.size() + 1];
        matrix = new int[vertexList.size() + 1][vertexList.size() + 1];
    }

    // Function for building matrix
    public void matrix() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r == 0 && c != 0) {
                    matrix[r][c] = c; // For making the list of numbers at the top for formatting
                }
                else if (c == 0 && r!= 0) {
                    matrix[r][c] = r; // For making the list of numbers at the side for formatting
                }
                else if (c != 0 && r != 0) { // Inside the matrix
                    boolean edge = vertexList.get(r - 1).haveEdge(c); // At each point in the matrix going through to see if it has an edge
                    if (edge == true) {
                        matrix[r][c] = 1; // If there is an edge the matrix point will be set to 1
                    }
                    else {
                        matrix[r][c] = 0; // If there isnt an edge
                    }
                } 
            }
        }
    }

    // Function for adjacency list
    public String adjList() {
        String result = "";
        for (int i = 0; i< vertexList.size(); i++) {
            Vertex v = vertexList.get(i); // Individual vertex
            result += "[" + v.getVertexByID() + "]" + Arrays.toString(v.neighbors.toArray()) + "\n"; // Formatting the adjacency list
        }
        return result; 
    }

    // Function for printing the results of the graph
    public void printResults() {
        for (int r = 0; r < matrix[0].length; r++) {
            System.out.print("[");
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + ", ");
            }
            System.out.println("]"); // For each line of the matrix
        }
        System.out.println(adjList()); // Printing the adjacency list
    }

    // Function for depth first traversal
    public void DFS(Vertex v) {
        if (v.processed == false) {
            System.out.println(v.getVertexByID());
            v.processed = true;
        }
        for (Vertex n: vertexList) { // For all the vertices in the vertex list 
            if (n.processed == false) {
                DFS(n);
            }
        }
    }

    // Function for breadth first traversal
    public void BFS(Vertex v) {
        Queue queue = new Queue();
        queue.enqueue(v);
        v.processed = true; 
        while (queue.isEmpty() == false) {
            Vertex currentVertex = queue.dequeue();
            System.out.println(currentVertex.getVertexByID());
            for (Vertex n: currentVertex.neighbors()) {
                if (n.processed == false) {
                    queue.enqueue(n);
                    n.processed = true;
                }
            }
        }
    }

    // Function for resetting prior to each traversale
    public void resetTraversal() {
        for (Vertex n: vertexList) {
            n.processed = false; // Making them all false again
            n.setNext(null);
        }
    }
}
