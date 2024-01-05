package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Anagram {
    public static boolean solution(String s1, String s2){
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split("")) {
            if(map.containsKey(s)) map.put(s, map.get(s)+1);
            else map.put(s, 1);
        }
        for (String s : s2.split("")) {
            if(!map.containsKey(s)) return false;
            if(map.get(s)>0) map.put(s, map.get(s)-1);
            else return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        if(solution(str1, str2)) System.out.println("YES");
        else System.out.println("NO");
    }
}