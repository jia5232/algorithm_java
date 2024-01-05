package lecture.school.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Team {
    static boolean[] ch;
    static int answer;
    public static void DFS(int[] arr, int index){
        if(ch[index]){
            answer++;
            return;
        }
        ch[index] = true;
        DFS(arr, arr[index]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n+1]; //인덱스 그대로 사용
            for (int j = 1; j <= n; j++) arr[j] = Integer.parseInt(st.nextToken());
            ch = new boolean[n+1]; //인덱스 그대로 사용
            answer = 0;
            for (int j = 1; j <= n; j++) {
                if(ch[j]) continue;
                DFS(arr, j);
            }
            System.out.println(answer);
        }
    }
}