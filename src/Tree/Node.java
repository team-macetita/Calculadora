package Tree;

public class Node {
    public String operation;
    public double value;
    public Node left;
    public Node right;

    public Node(double value) {
        this.value = value;
    }

    public Node(String operation, double value) {
        this.operation = operation;
        this.value = value;
    }

    public String getDot(int i) {
        return getGraph(this, i, "");
    }

    private String getGraph(Node node, int i, String tag) {
        String dot = "node_" + i + tag + "[label = \"" + (node.operation != null ? node.operation + "\\n" : "")
                + node.value + "\"];\n";
        if (node.left != null) {
            dot += getGraph(node.left, i, tag + "_left");
            dot += "node_" + i + tag + " -> " + "node_" + i + tag + "_left;\n";
        }
        if (node.right != null) {
            dot += getGraph(node.right, i, tag + "_right");
            dot += "node_" + i + tag + " -> " + "node_" + i + tag + "_right;\n";
        }
        return dot;
    }
}