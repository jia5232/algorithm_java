package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Travel {
    public static int Find(int v){
        if(unf[v]==v) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    static int[] unf;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            unf = new int[n+1];
            for (int j = 1; j <= n; j++) unf[j] = j;
            answer = 0;

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int fa = Find(a);
                int fb = Find(b);
                if(fa!=fb){
                    Union(fa, fb);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
