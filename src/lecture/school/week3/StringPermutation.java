package lecture.school.week3;

import java.util.Scanner;

public class StringPermutation {
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            count = 0;
            String str = scanner.next();
            boolean[] visited = new boolean[str.length()];
            perm(0, visited, str,0);
            System.out.println(count);
        }
    }

    private static void perm(int w, boolean[] visited, String str, int depth){
        if(str.length() == depth){
            if(w > 0){
                count++;
            }
            return;
        }

        for(int i = 0; i < str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                int sign = 1;
                if(depth % 2 == 1) sign = -1;

                int tmp = sign * (str.charAt(i) - 'a');

                perm(w + tmp, visited, str, depth + 1);
                visited[i] = false;
            }
        }
    }
}
