package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int lt = 0, rt = 0, answer = 0;
        while (rt<=n){
            int tmp = 0;
            for (int j = lt; j < rt; j++) {
                tmp += arr[j];
            }
            if(tmp==m){
                answer++;
                lt++;
            }else if(tmp>m){
                lt++;
            }else{
                rt++;
            }
        }
        System.out.println(answer);
    }
}