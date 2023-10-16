package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void recursive(int lt, int rt, int[] arr, int k){
        if(lt <= rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==k){
                System.out.println(mid);
                return;
            }
            if(arr[mid]>k) rt = mid-1;
            else lt = mid+1;
            recursive(lt, rt, arr, k);
        }
        else System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < num; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            recursive(0, n-1, arr, k);
        }
    }
}
