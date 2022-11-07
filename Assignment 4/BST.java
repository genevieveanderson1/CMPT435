public class BST {

    Node root;
    String path;
    int comparisons;

    // Constructor
    public BST() {
        root = null;
        path = "";
        comparisons = 0;
    }

    public Node insert(Node node, String value) {
        if (node == null) {
            return new Node(value); // New node we are inserting
        }
        // Determines which side of tree to place node
        if (value.compareTo(node.getName()) < 0) { // value we are trying to insert being compared to the "current" node
            node.left = insert(node.left, value); 
            path += "L ";
            comparisons++;
        } else { // Greater than
            node.right = insert(node.right, value);
            path += "R ";
            comparisons++;
        }
        return node;
    }

    // Function for setting the root
    public void setRoot(String value) {
        root = new Node(value);
    }

    // Function for printing the path
    public void path(String name) {
        System.out.println(name + ": " + path + " and the number of comparisons is : " + comparisons);
        path = "";
        int average += comparisons; 
        comparisons = 0;
    }

    //
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
