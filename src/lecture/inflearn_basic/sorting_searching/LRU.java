package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int s = Integer.parseInt(inputArr[0]);
        int n = Integer.parseInt(inputArr[1]);
        int[] works = new int[n];
        inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            works[i] = Integer.parseInt(inputArr[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int w : works) {
            if(queue.contains(w)){
                queue.remove(w);
            }
            queue.offer(w);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i : queue){
            arrayList.add(i);
        }
        for (int i = arrayList.size()-1; i >= arrayList.size()-s; i--) {
            System.out.print(arrayList.get(i)+" ");
        }
    }
}