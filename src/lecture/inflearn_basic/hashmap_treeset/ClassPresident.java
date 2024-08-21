package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ClassPresident {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] arr = br.readLine().split("");
        for(String s : arr){
            if(map.containsKey(s)) map.put(s, map.get(s)+1);
            else map.put(s, 1);
        }
        int max = Integer.MIN_VALUE;
        for(int i : map.values()){
            if(i>max){
                max = i;
            }
        }
        String answer = "";
        for(String s : map.keySet()){
            if(map.get(s)==max){
                answer = s;
            }
        }
        System.out.println(answer);
    }
}