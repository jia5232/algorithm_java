package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S20920 {
    static int n, m;

    static class Word implements Comparable<Word>{
        int cnt;
        int length;
        String word;

        public Word(int cnt, int length, String word){
            this.cnt = cnt;
            this.length = length;
            this.word = word;
        }

        @Override
        public int compareTo(Word o){
            if(this.cnt != o.cnt) return o.cnt - this.cnt;
            if(this.length != o.length) return o.length - this.length;
            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        ArrayList<Word> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length()<m) continue;
            if(map.containsKey(str)) map.put(str, map.get(str)+1);
            else map.put(str, 1);
        }
        for(String key : map.keySet()){
            answer.add(new Word(map.get(key), key.length(), key));
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(Word w : answer){
            sb.append(w.word).append("\n");
        }
        System.out.println(sb);
    }
}
