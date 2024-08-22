package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class EmergencyRoom {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int[] arr = new int[n];
        inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        int cnt = 1;
        while (!queue.isEmpty()){
            Person now = queue.poll();
            if(queue.stream().anyMatch(p -> p.score > now.score)) queue.offer(now);
            else {
                if(now.number==m){
                    System.out.println(cnt);
                    break;
                } else {
                    cnt++;
                }
            }
        }
    }
}

class Person {
    int number;
    int score;

    public Person(int number, int score){
        this.number = number;
        this.score = score;
    }
}