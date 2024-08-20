package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CombineArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arrA[i] = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        int[] arrB = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arrB[i] = Integer.parseInt(st.nextToken());
        int idxA = 0, idxB = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (idxA<arrA.length && idxB<arrB.length){
            if(arrA[idxA]<arrB[idxB]){
                arrayList.add(arrA[idxA++]);
            }else{
                arrayList.add(arrB[idxB++]);
            }
        }
        if(idxA<arrA.length){
            for (int i = idxA; i < arrA.length; i++) {
                arrayList.add(arrA[i]);
            }
        }
        if(idxB<arrB.length){
            for (int i = idxB; i < arrB.length; i++) {
                arrayList.add(arrB[i]);
            }
        }
        for (int i : arrayList) {
            System.out.print(i+" ");
        }
    }
}