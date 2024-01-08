package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G13023 {
    static int[] ch;
    static ArrayList<ArrayList<Integer>> arrayList;

    static boolean arrive;

    public static void DFS(int n, int L){
        if(L==5 || arrive){
            arrive = true;
            return;
        }
        else{
            ch[n] = 1;
            for (Integer i : arrayList.get(n)) {
                if(ch[i]==0){
                    DFS(i, L+1);
                }
            }
            ch[n] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ch = new int[n];
        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }
        arrive = false;

        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println(1);
        else System.out.println(0);
    }
}
