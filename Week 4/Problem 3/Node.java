
class Node {
    int val;
    Node left;
    Node right;

    public Node(String val){
        this.val = Integer.parseInt(val);
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}