package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ssireum {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int h = Integer.parseInt(inputArr[0]);
            int w = Integer.parseInt(inputArr[1]);
            persons[i] = new Person(h, w);
        }
        Arrays.sort(persons);
        int answer = 0;
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            Person now = persons[i];
            if(maxWeight<now.weight){
                answer++;
                maxWeight = now.weight;
            }
        }
        System.out.println(answer);
    }

    static class Person implements Comparable<Person>{
        int height;
        int weight;

        public Person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o){
            if(this.height == o.height){
                return o.weight - this.weight;
            } else return o.height - this.height;
        }
    }
}