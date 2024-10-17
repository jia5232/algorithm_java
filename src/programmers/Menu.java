package programmers;

import java.util.*;

public class Menu {
    public ArrayList<String> arrayList = new ArrayList<>();

    public int[] pm, ch;

    public HashMap<String, Integer> hashMap;

    public void DFS(int m, int L, int s, String[] orders){
        if(L==m){
            StringBuilder pmStr = new StringBuilder();
            for(int i : pm){
                pmStr.append((char)i);
            }
            String combination = pmStr.toString();
            int count = 0;
            for(String order : orders){
                if(isSubset(combination, order)){
                    count++;
                }
            }
            if(count>=2){
                hashMap.put(combination, count);
            }

        } else {
            for(int i=s; i<=90; i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(m, L+1, i+1, orders);
                    ch[i] = 0;
                }
            }
        }
    }

    private boolean isSubset(String combination, String order){
        for(char c : combination.toCharArray()){
            if(order.indexOf(c) == -1){
                return false;
            }
        }
        return true;
    }

    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for(int i : course){
            pm = new int[i];
            ch = new int[100];
            hashMap = new HashMap<>();
            DFS(i, 0, 65, orders);
            int max = 0;
            for(Integer value : hashMap.values()){
                max = Math.max(max, value);
            }
            for(String key : hashMap.keySet()){
                if(hashMap.get(key)==max){
                    arrayList.add(key);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList.toArray(new String[0]);
    }
}