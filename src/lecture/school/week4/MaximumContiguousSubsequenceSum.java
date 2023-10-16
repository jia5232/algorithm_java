package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumContiguousSubsequenceSum {
    public static int maxValue = Integer.MIN_VALUE;
    public static void recursion(int[] arr, int lt, int rt){
        if(lt == rt){
            maxValue = Math.max(maxValue, arr[rt]);
            return;
        }
        if(lt < rt){
            int mid = (lt+rt)/2;
            recursion(arr, lt, mid);
            recursion(arr, mid+1, rt);
            int tmpLeft = Integer.MIN_VALUE, tmpRight = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = mid; i >= lt; i--){
                sum+=arr[i];
                tmpLeft = Math.max(tmpLeft, sum);
            }
            sum = 0;
            for (int i = mid+1; i <= rt; i++){
                sum+=arr[i];
                tmpRight = Math.max(tmpRight, sum);
            }
            maxValue = Math.max(maxValue, tmpLeft);
            maxValue = Math.max(maxValue, tmpRight);
            maxValue = Math.max(maxValue, tmpLeft+tmpRight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            recursion(arr, 0, n-1);
            if(maxValue<=0) System.out.println(0);
            else System.out.println(maxValue);
            maxValue = Integer.MIN_VALUE;
        }
    }
}
