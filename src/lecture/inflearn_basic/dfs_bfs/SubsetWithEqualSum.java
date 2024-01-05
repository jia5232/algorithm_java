package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class SubsetWithEqualSum {
//    static String answer = "NO";
//    static boolean flag = false;
//    static int n, total;
//    static StringTokenizer st;
//
//    public static void DFS(int L, int sum, int[] arr){
//        if(flag) return;
//
//        if(sum > (total/2)) return;
//
//        if(L==n){
//            if(total == 2*sum){
//                answer = "YES";
//                flag = true;
//            }
//        }
//        else{
//            DFS(L+1, sum+arr[L], arr);
//            DFS(L+1, sum, arr);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//            total += arr[i];
//        }
//        DFS(0, 0, arr);
//        System.out.println(answer);
//    }
//}

public class SubsetWithEqualSum {
    static String answer = "NO";
    static boolean flag = false;
    static int n, total;

    public static void DFS(int L, int sum, int[] arr){
        if(flag) return;

        if(sum > (total/2)) return;

        if(L==n){
            if(total == sum*2){
                answer = "YES";
                flag = true;
            }
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }
}