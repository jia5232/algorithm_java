package lecture.inflearn_basic.recursive_tree_graph;

import java.util.Scanner;

public class Subset {
    static int n;
    static int[] ch; //해당 숫자(L) 사용 여부를 0/1로 저장
    public static void DFS(int L){
        if(L==n+1){//종료 조건 : 재귀 트리의 끝에 왔을 떄 -> 하나의 경우의 수가 나온것이므로 ch를 돌며 해당 경우의 수에 포함된 숫자들을 출력
            String tmp = "";
            for (int i = 0; i <= n; i++) {
                if(ch[i]==1) tmp+=(i+" ");
            }
            //공집합은 출력하지 않음!
            if(tmp.length()>0) System.out.println(tmp);
        }
        else{
            ch[L] = 1;
            DFS(L+1); //L을 포함하는 경우

            ch[L] = 0;
            DFS(L+1); //L을 포함하지 않는 경우
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n+1];
        DFS(1);
    }
}
