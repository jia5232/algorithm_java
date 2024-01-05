package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ClassPresident {
    public static String solution(String str){
        String[] arr = str.split("");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : arr) {
            if(hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s)+1);
            else hashMap.put(s, 1);
        }
        String result = "";
        int max = Integer.MIN_VALUE;
        for (String s : hashMap.keySet()) {
            if(hashMap.get(s) > max){
                max = hashMap.get(s);
                result = s;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(str));
    }
}