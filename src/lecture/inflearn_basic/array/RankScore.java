package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// HashMap 사용
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

public class RankScore {
    public static void solution(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] < arr[j]) cnt++;
            }
            newArr[i] = cnt;
        }

        for (int i : newArr) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        solution(arr);
    }
}