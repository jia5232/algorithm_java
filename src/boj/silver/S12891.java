package boj.silver;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class S12891 { //DNA 비밀번호
//    public static void main(String[] args) throws IOException {
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int p = Integer.parseInt(st.nextToken());
//        String str = br.readLine();
//        char[] DNA = str.toCharArray();
//        st = new StringTokenizer(br.readLine());
//        int[] intArr = new int[4];
//        for (int i = 0; i < 4; i++) intArr[i] = Integer.parseInt(st.nextToken());
//        char[] charArr = {'A', 'C', 'G', 'T'};
//
//        int answer = 0;
//
//        for (int i = 0; i < n - p; i++) { //비밀번호 한 케이스
//            int[] check = new int[4];
//
//            for (int j = i; j < i+p; j++) { //비밀번호 한 케이스 조사
//                for (int k = 0; k < 4; k++) {
//                    if(DNA[j]==charArr[k]) check[k]++;
//                }
//            }
//
//            boolean available = true;
//            for (int j = 0; j < 4; j++) { //그 케이스에서 조건 충족했는지 검사
//                if(intArr[j] > check[j]) available = false;
//            }
//            if(available) answer++;
//        }
//
//        System.out.println(answer);
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12891 { //DNA 비밀번호
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] DNA = str.toCharArray();
        st = new StringTokenizer(br.readLine());
        int[] intArr = new int[4];
        for (int i = 0; i < 4; i++) intArr[i] = Integer.parseInt(st.nextToken());
        char[] charArr = {'A', 'C', 'G', 'T'};
        int[] check = new int[4];

        int answer = 0;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 4; j++) {
                if(DNA[i]==charArr[j]) check[j]++;
            }
        }

        boolean available = true;
        for (int i = 0; i < 4; i++) {
            if(intArr[i]>check[i]) available = false;
        }
        if(available) answer++;

        for (int i = p; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if(DNA[i-p]==charArr[j]) check[j]--;
                if(DNA[i]==charArr[j]) check[j]++;
            }

            available = true;
            for (int j = 0; j < 4; j++) {
                if(intArr[j]>check[j]) available = false;
            }
            if(available) answer++;
        }

        System.out.println(answer);
    }
}