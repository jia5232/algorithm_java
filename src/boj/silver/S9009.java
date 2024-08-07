package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S9009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> array = new ArrayList<>();
            array.add(0);
            array.add(1);

            int nextFib;
            while (true){
                nextFib = array.get(array.size()-2) + array.get(array.size()-1);
                if(nextFib>n) break;
                array.add(nextFib);
            }

            List<Integer> answers = new ArrayList<>();

            for (int i = array.size()-1; i >= 0; i--) {
                if(array.get(i)<=n){
                    n-= array.get(i);
                    answers.add(array.get(i));
                }
            }

            Collections.sort(answers);
            answers.remove(0);

            for(int a : answers){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
