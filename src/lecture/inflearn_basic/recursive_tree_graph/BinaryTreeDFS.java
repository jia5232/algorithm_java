package lecture.inflearn_basic.recursive_tree_graph;


public class BinaryTreeDFS { //깊이 우선 탐색
    static class Node{
        int data;
        Node lt;
        Node rt;

        public Node(int data){
            this.data = data;
            lt = rt = null;
        }
    }

    public static void DFS(Node root){
        if(root==null) return;
        else{
            // 전위 순회
//            System.out.print(root.data+" ");
//            DFS(root.lt);
//            DFS(root.rt);

            // 중위 순회
//            DFS(root.lt);
//            System.out.print(root.data+" ");
//            DFS(root.rt);

            // 후위 순회
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
}

/*
전위(preOrder): 부모 - 왼쪽 자식 - 오른쪽 자식 (1245367)
중위(inOrder): 왼쪽 자식 - 부모 - 오른쪽 자식 (4251637)
후위(postOrder): 왼쪽 자식 - 오른쪽 자식 - 부모 (4526731)
 */