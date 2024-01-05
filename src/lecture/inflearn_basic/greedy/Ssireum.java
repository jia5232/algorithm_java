package lecture.inflearn_basic.greedy;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Ssireum {
//    public static int solution(Person[] arr){
//        int answer = arr.length;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if(i==j) continue;
//                if(arr[j].height>arr[i].height && arr[j].weight>arr[i].weight){
//                    answer--;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int num = Integer.parseInt(br.readLine());
//        Person[] arr = new Person[num];
//        for (int i = 0; i < num; i++) {
//            st = new StringTokenizer(br.readLine());
//            arr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//        System.out.println(solution(arr));
//    }
//}
//
//class Person{
//    int height;
//    int weight;
//
//    public Person(int height, int weight) {
//        this.height = height;
//        this.weight = weight;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ssireum {

    public static int solution(Person[] arr){
        int answer = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==j) continue;
                if(arr[i].height<arr[j].height && arr[i].weight<arr[j].weight){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        Person[] arr = new Person[num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(solution(arr));
    }
}

class Person{
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}