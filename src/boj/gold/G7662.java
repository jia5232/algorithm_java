package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class G7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            String[] inputArr;
            for (int i = 0; i < n; i++) {
                inputArr = br.readLine().split(" ");
                String m = inputArr[0];
                int num = Integer.parseInt(inputArr[1]);
                if(m.equals("I")){
                    if(map.containsKey(num)){
                        map.put(num, map.get(num)+1);
                    } else{
                        map.put(num, 1);
                    }
                }
                else{
                    if(!map.isEmpty() && num==-1){
                        if(map.get(map.firstKey())==1){ //최솟값이 하나면 키 지워버리고
                            map.remove(map.firstKey());
                        } else {
                            map.put(map.firstKey(), map.get(map.firstKey())-1); //여러개면 하나 감소
                        }
                    }else{//num==1
                        if(!map.isEmpty()){
                            if(map.get(map.lastKey())==1){
                                map.remove(map.lastKey());
                            } else {
                                map.put(map.lastKey(), map.get(map.lastKey())-1);
                            }
                        }
                    }
                }
            }
            if(map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey()+" "+map.firstKey());
        }
    }
}