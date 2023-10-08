package lecture.inflearn_basic.recursive_tree_graph;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
