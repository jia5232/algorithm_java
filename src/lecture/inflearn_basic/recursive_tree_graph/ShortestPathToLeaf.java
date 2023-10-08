package lecture.inflearn_basic.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

// 최단거리 문제 -> BFS로 푸는것이 정답! but 연습을 위해 DFS도 사용해본다!
public class ShortestPathToLeaf {
    static Node root;

    public static int DFS(int L, Node root){
        if(root.lt==null && root.rt==null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }

    public static int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if(cur.lt==null && cur.rt==null) return L; //말단노드면 그때의 레벨 리턴!
                if(cur.lt!=null) Q.add(cur.lt);
                if(cur.rt!=null) Q.add(cur.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
    }
}
