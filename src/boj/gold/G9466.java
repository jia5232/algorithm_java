package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G9466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] selection = new int[n+1];
            for (int i = 1; i <= n; i++) {
                selection[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[n+1];
            boolean[] finished = new boolean[n+1];
            int inTeamCount = 0;

            for (int i = 1; i <= n; i++) {
                if(!visited[i]){
                    inTeamCount += dfs(i, selection, visited, finished);
                }
            }

            System.out.println(n-inTeamCount);
        }
    }

    private static int dfs(int current, int[] selection, boolean[] visited, boolean[] finished){
        visited[current] = true;
        int next = selection[current];

        if(!visited[next]){
            int result = dfs(next, selection, visited, finished);
            finished[current] = true;
            return result;
        } else if(!finished[next]){
            int count = 1;
            for(int i=next; i!=current; i=selection[i]){
                count++;
            }
            finished[current] = true;
            for (int i = next; i != current; i = selection[i]) {
                finished[i] = true; // 사이클 내의 모든 학생에 대해 팀 결성 과정 완료 표시
            }
            return count;
        }

        finished[current] = true;
        return 0;
    }
}
