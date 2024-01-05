package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kids {
    public static void solution(int[] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] cloneArr = arr.clone(); //깊은 복사
        Arrays.sort(cloneArr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=cloneArr[i]) arrayList.add(i+1);
        }
        for (Integer i : arrayList) System.out.print(i+" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        solution(arr);
    }
}