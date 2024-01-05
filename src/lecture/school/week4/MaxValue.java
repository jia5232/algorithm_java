package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxValue {
    public static int maxValueIndex(int[] arr, int lt, int rt){
        if(lt>=rt){
            return lt;
        }
        int mid = (lt+rt) / 2;
        int leftMaxIndex = maxValueIndex(arr, lt, mid);
        int rightMaxIndex = maxValueIndex(arr, mid+1, rt);
        return arr[leftMaxIndex]>arr[rightMaxIndex] ? leftMaxIndex : rightMaxIndex;
    }

    public static int maxValue(int[] arr, int max, int index){
        if(index==arr.length) return max;
        max = Math.max(max, arr[index]);
        return maxValue(arr, max, index+1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
//            int index = maxValueIndex(arr, 0, n - 1);
//            System.out.println(arr[index]);
            System.out.println(maxValue(arr, 0, 0));
        }
    }
}