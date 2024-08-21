package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AllAnagram {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String anaStr = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> anaMap = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < anaStr.length(); i++) {
            char anaTmp = anaStr.charAt(i);
            if(anaMap.containsKey(anaTmp)) anaMap.put(anaTmp, anaMap.get(anaTmp)+1);
            else anaMap.put(anaTmp, 1);

            char tmp = str.charAt(i);
            if(map.containsKey(tmp)) map.put(tmp, map.get(tmp)+1);
            else map.put(tmp, 1);
        }
        if(anaMap.equals(map)) answer++;

        for (int i = anaStr.length(); i < str.length(); i++) {
            char add = str.charAt(i);
            char remove = str.charAt(i-anaStr.length());

            if(map.containsKey(add)) map.put(add, map.get(add)+1);
            else map.put(add, 1);

            if(map.containsKey(remove)){
                if(map.get(remove)==1) map.remove(remove);
                else map.put(remove, map.get(remove)-1);
            }

            if(map.equals(anaMap)) answer++;
        }
        System.out.println(answer);
    }
}