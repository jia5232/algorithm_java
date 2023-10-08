package lecture.inflearn_basic.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS { // 넓이 우선 탐색 (레벨 탐색) -> 0레벨, 1레벨, 2레벨... 순서대로 탐색!
    static class Node{
        int data;
        Node lt, rt;
        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    static Node root; //root는 전역변수로 설정

    public static void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int L = 0; //루트 노드의 레벨은 0
        while (!Q.isEmpty()){ //큐가 비어있지 않을때 계속 실행
            int len = Q.size();
            System.out.print(L+": ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll(); //큐에서 하나 꺼내기
                System.out.print(cur.data+" ");
                if(cur.lt!=null) Q.add(cur.lt);
                if(cur.rt!=null) Q.add(cur.rt);
            }
            L++; //레벨 증가
            System.out.println();
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }
}
