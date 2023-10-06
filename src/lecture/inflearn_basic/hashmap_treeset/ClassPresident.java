package lecture.inflearn_basic.hashmap_treeset;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();

        String[] strArr = str.split("");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : strArr) {
//            hashMap.put(s, hashMap.getOrDefault(s, 0)+1);
            // getOrDefault -> 해당 키값이 존재하면 해당 키의 값을 가져오고 존재하지않으면 디폴트값을 가져옴.
            if(hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s)+1);
            else hashMap.put(s, 1);
        }

        int max = 0;
        String result = "";
        for (String s : hashMap.keySet()) {
            if(hashMap.get(s) > max){
                max = hashMap.get(s);
                result = s;
            }
        }
        System.out.println(result);
    }
}
