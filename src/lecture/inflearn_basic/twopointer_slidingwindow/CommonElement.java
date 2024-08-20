package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CommonElement {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) arr1[i] = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) arr2[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int idx1 = 0, idx2 = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (idx1<n1 && idx2<n2){
            if(arr1[idx1]==arr2[idx2]){
                arrayList.add(arr1[idx1]);
                idx1++;
                idx2++;
            } else if(arr1[idx1]<arr2[idx2]){
                idx1++;
            } else {
                idx2++;
            }
        }
        for(int i : arrayList){
            System.out.print(i+" ");
        }
    }
}