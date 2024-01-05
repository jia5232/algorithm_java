package boj.platinum;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003 {
    static class Node{
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            //새로운 값이 들어올 때마다 정렬대신 현재 수보다 큰 값들을 덱에서 제거해 시간 복잡도를 줄임
            while (!deque.isEmpty() && deque.getLast().value>now){
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));

            //범위에서 벗어난 값은 덱에서 제거
            if(deque.getFirst().index <=i-L){
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value+" ");
        }
        bw.flush();
        bw.close();
    }
}
