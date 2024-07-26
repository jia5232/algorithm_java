package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int w = Integer.parseInt(inputArr[1]);
        int l = Integer.parseInt(inputArr[2]);
        inputArr = br.readLine().split(" ");

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        int time = 0, sum = 0;

        for(int i=0; i<w; i++){
            bridge.add(0);
        }
        for(int i=0; i<n; i++){
            trucks.add(Integer.parseInt(inputArr[i]));
        }

        while (!bridge.isEmpty()){
            time++;
            sum -= bridge.poll();

            if(!trucks.isEmpty()){
                if(trucks.peek()+sum <= l){ //새로운 트럭이 다리 진입 가능
                    sum += trucks.peek();
                    bridge.add(trucks.poll());
                } else { //새로운 트럭이 다리 진입 불가능 -> 0을 추가하여 트럭이 이동하도록 함
                    bridge.add(0);
                }
            }
        }
        System.out.println(time);
    }
}
