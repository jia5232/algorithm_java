package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char tmp = str1.charAt(i);
            if(map1.containsKey(tmp)) map1.put(tmp, map1.get(tmp)+1);
            else map1.put(tmp, 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char tmp = str2.charAt(i);
            if(map2.containsKey(tmp)) map2.put(tmp, map2.get(tmp)+1);
            else map2.put(tmp, 1);
        }
        if(map1.equals(map2)) System.out.println("YES");
        else System.out.println("NO");
    }
}