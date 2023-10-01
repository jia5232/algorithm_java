package lecture.inflearn_basic.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// 1. 내 풀이 -> HashMap 사용
//public class RankScore {
//    public static void solution(int[] array){
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int[] new_array = array.clone(); //깊은 복사
//        for (int i : array) { //맵에 값 넣기
//            if(map.containsKey(i)) map.put(i, map.get(i)+1);
//            else map.put(i, 1);
//        }
//        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
//        Collections.sort(keySet); //오름차순 키 정렬
//        Collections.reverse(keySet); //내림차순 키 정렬
//
//        for (int i = 0; i < array.length; i++) {
//            new_array[i] = keySet.indexOf(array[i])+1;
//        }
//
//        for (int i : new_array) {
//            System.out.print(i + " ");
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        solution(arr);
//    }
//}

// 2. 강의 풀이 -> 이중 for문 사용
public class RankScore{
    public static void solution(int[] array){
        int[] new_array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int cnt = 1;
            for (int j = 0; j < array.length; j++) {
                if(array[i]<array[j]) cnt++;
            }
            new_array[i] = cnt;
        }
        for (int i : new_array) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr);
    }
}