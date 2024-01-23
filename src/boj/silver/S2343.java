package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2343 {
    static int[] lectures;
    public static int count(int capacity){ //해당 용량으로 처리할 수 있는 장수
        int tmp = 0;
        int num = 1;

        for (int lecture : lectures) {
            if(tmp+lecture <= capacity){
                tmp += lecture;
            }
            else{
                num++;
                tmp = lecture;
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lN = Integer.parseInt(st.nextToken()); //강의 개수
        int bN = Integer.parseInt(st.nextToken()); //블루레이 개수
        st = new StringTokenizer(br.readLine());
        lectures = new int[lN];
        for (int i = 0; i < lN; i++) lectures[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        // 적정 용량을 구헤내는 것이므로 최대길이의 강의(한장의 최소 용량) ~ 전체강의의 총합(한장의 최대 용량) 사이에서 찾는다.
        int lt = Arrays.stream(lectures).max().getAsInt();
        int rt = Arrays.stream(lectures).sum();
        while (lt <= rt){
            int mid = (lt+rt) / 2;
            if(count(mid)<=bN) {//해당 용량으로 처리할 수 있는 최대 장수가 전체 블루레이보다 작으면 개당 용량을 좀 줄여봐도 됨.
                answer = mid; //줄여볼거긴 한데 일단 지금 용량은 결괏값에 담아놓고 가자.
                rt = mid-1;
            }
            else lt = mid+1;//최대 장수보다 크면 용량을 늘려야됨.
        }
        System.out.println(answer);
    }
}
