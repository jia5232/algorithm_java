package lecture.school.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maxmin {
    static int min, max, countRecursiveCall;

    public static void findMinMax(int lt, int rt, int[] arr){
        countRecursiveCall++;
        if(lt<=rt){
            if(rt-lt==0){
                min = Math.min(min, arr[lt]);
                max = Math.max(max, arr[lt]);
                return;
            }
            else if(rt-lt==1){
                min = Math.min(min, arr[lt]);
                min = Math.min(min, arr[rt]);
                max = Math.max(max, arr[lt]);
                max = Math.max(max, arr[rt]);
                return;
            }
            else{
                int mid = (lt+rt) / 2;
                findMinMax(lt, mid, arr);
                findMinMax(mid+1, rt, arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            countRecursiveCall = 0;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            findMinMax(0, n-1, arr);
            System.out.println(max + " " + min + " " + countRecursiveCall);
        }
    }
}