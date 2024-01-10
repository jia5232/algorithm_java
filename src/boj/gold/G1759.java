package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G1759 {
    static String[] pm, arr;
    static int[] ch;

    static StringBuilder sb;

    public static void DFS(int pmIndex, int arrIndex, int L){
        if(pmIndex==L){
            sb = new StringBuilder();
            for (String s : pm) {
                sb.append(s);
            }
            String s = String.valueOf(sb);
            if(check(s)) {
                System.out.println(s);
            }
        }
        else{
            for (int i = arrIndex; i < arr.length; i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[pmIndex] = arr[i];
                    DFS(pmIndex+1, i+1, L);
                    ch[i] = 0;
                }
            }
        }
    }

    public static boolean check(String s){
        String[] strArr = s.split("");
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        int mo = 0;
        int ja = 0;
        for (String str : strArr) {
            if(set.contains(str)) mo++;
            else ja++;
        }
        if(mo>=1 && ja>=2) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        ch = new int[C];
        pm = new String[L];
        DFS(0, 0, L);
    }
}
