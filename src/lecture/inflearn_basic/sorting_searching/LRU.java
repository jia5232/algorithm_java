package lecture.inflearn_basic.sorting_searching;

import java.util.Scanner;

public class LRU {
    public static int[] solution(int size, int n, int[] arr){
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1; //인덱스 번호
            for (int i = 0; i < size; i++) if(cache[i]==x) pos=i; //cache hit
            if(pos==-1){ //cache miss -> 맨 뒤에서부터 땡김
                for (int i = size-1; i>=1 ; i--) {
                    cache[i] = cache[i-1];
                }
            }
            else{ //cache hit -> 히트인 곳에서부터 땡김
                for (int i = pos; i>=1 ; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : solution(s, n, arr)) System.out.print(i+" ");
    }
}
