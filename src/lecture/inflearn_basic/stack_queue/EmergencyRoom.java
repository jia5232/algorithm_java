package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EmergencyRoom {
    public static int solution(int[] arr, int k){
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(new Person(i, arr[i]));
        }
        int answer = 1;
        while (!queue.isEmpty()){
            Person tmp = queue.poll();
            //자기보다 긴급한 사람을 하나라도 찾으면 큐로 다시 들어가고 바로 break!
            for (Person p : queue) {
                if(p.priority > tmp.priority){
                    queue.add(tmp);
                    tmp = null;
                    break;
                }
            }
            //tmp가 null이 아니라는건 자기보다 긴급한 사람이 뒤에 없다는 것!
            if(tmp != null) {
                if(tmp.id==k) return answer;
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, k));
    }

    static class Person{
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}