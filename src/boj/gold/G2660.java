package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Candidate implements Comparable<Candidate>{
    int score;
    int number;

    public Candidate(int score, int number) {
        this.score = score;
        this.number = number;
    }

    @Override
    public int compareTo(Candidate o) {
        if(this.score==o.score){
            return this.number - o.number;
        } else {
            return this.score - o.score;
        }
    }
}

public class G2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        String[] inputArr;
        while(true){
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            if(a==-1 && b==-1) break;
            else{
                arrayList.get(a).add(b);
                arrayList.get(b).add(a);
            }
        }

        Queue<Integer> queue;
        int[] check;

        for (int i = 1; i <= n; i++) {
            queue = new LinkedList<>();
            check = new int[n+1];

            queue.add(i);
            check[i] = 1;

            int friendScore = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int tmp = queue.poll();
                    for(int k : arrayList.get(tmp)){
                        if(check[k]==0){
                            check[k] = 1;
                            queue.add(k);
                        }
                    }
                }
                friendScore++;
            }
            candidates.add(new Candidate(friendScore-1, i));
        }

        Collections.sort(candidates);

        int minScore = n-1;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < candidates.size(); i++) {
            Candidate candidate = candidates.get(i);
            if(i==0){
                minScore = candidate.score;
            }
            if(candidate.score==minScore) answer.add(candidate.number);
        }

        System.out.println(minScore+" "+answer.size());
        for (Integer a : answer) {
            System.out.print(a+" ");
        }
    }
}
