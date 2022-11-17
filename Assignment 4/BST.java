public class BST {

    Node root;
    String path;
    int comparisons;
    String findPath; // For when we are finding the path of the target being searched in the tree
    int findComparisons; // For when we are finding the target in the tree
    int totalComparisons; // For the average
    int findTotalComparisons;

    // Constructor
    public BST() {
        root = null;
        path = "";
        comparisons = 0;
        findPath = "";
        findComparisons = 0;
        totalComparisons = 0;
        findTotalComparisons = 0;
    }

    // Function for setting the root
    public void setRoot(String value) {
        root = new Node(value);
    }

    // Function for inserting nodes into the tree
    public Node insert(Node node, String value) {
        if (node == null) {
            return new Node(value); // New node we are inserting
        }
        // Determines which side of tree to place node, will compare the value we are trying to insert to the "current" node
        if (value.compareTo(node.getName()) < 0) { // Less than "current" node
            node.left = insert(node.left, value); 
            path += "L ";
            comparisons++;
        } else { // Greater than "current" node
            node.right = insert(node.right, value);
            path += "R ";
            comparisons++;
        }
        return node;
    }

    // Function for finding nodes in the tree
    public Node find(Node node, String target) {
        findComparisons++;
        if (target.equals(node.getName())) { 
            return node;
        }
        else if (target.compareTo(node.getName()) < 0) { // Searching left hand side of tree
            findPath += "L ";
            find(node.getLeft(), target);
        }
        else { // Searching right hand side
            findPath += "R ";
            find(node.getRight(), target);
        }
        return null; // If the target is not found
    }

    // Function for printing the path and comparisons of when they are inserted
    public void path(String name) {
        System.out.println(name + ": " + path + " and the number of comparisons is: " + comparisons);
        path = "";
        totalComparisons += comparisons; 
        comparisons = 0;
    }

    // Function for printing the path and comparisons for when they are searched
    public void findPath(String name) {
        System.out.println(name + ": " + findPath + " and the number of comparisons is: " + findComparisons);
        findPath = "";
        findTotalComparisons += findComparisons;
        findComparisons = 0;
    }

    // Function for calculating the average
    public void average(int avgComparisons, int size) {
        double average = ((double)(avgComparisons))/size; // dobule for decimal places
        System.out.println("The average is: " + String.format("%.2f", average));
    }

    // Function for ITW
    public void ITW(Node node) {
        if (node == null) {
            return;
        }
        // Prints nodes in order
        ITW(node.left);
        System.out.println(node.getName());
        ITW(node.right);
    }
}
