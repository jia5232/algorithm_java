package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// java equals()는 맵의 key, value 값들을 다 비교해서 동일한 맵인지 비교해준다.
public class AllAnagram {
    public static int solution(int strLength, int anaLength, String[] strArr, String[] anaArr){
        int answer = 0;
        HashMap<String, Integer> anaMap = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < anaLength; i++) {
            if(anaMap.containsKey(anaArr[i])) anaMap.put(anaArr[i], anaMap.get(anaArr[i])+1);
            else anaMap.put(anaArr[i], 1);
        }

        for (int i = 0; i < anaLength; i++) {
            if(map.containsKey(strArr[i])) map.put(strArr[i], map.get(strArr[i])+1);
            else map.put(strArr[i], 1);
        }
        if(map.equals(anaMap)) answer++;

        for (int i = anaLength; i < strLength; i++) {
            //추가
            if(map.containsKey(strArr[i])) map.put(strArr[i], map.get(strArr[i])+1);
            else map.put(strArr[i], 1);

            //삭제
            if(map.get(strArr[i-anaLength]) == 1) map.remove(strArr[i-anaLength]);
            else map.put(strArr[i-anaLength], map.get(strArr[i-anaLength])-1);

            if(map.equals(anaMap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String anaStr = br.readLine();
        System.out.println(solution(str.length(), anaStr.length(), str.split(""), anaStr.split("")));
    }
}