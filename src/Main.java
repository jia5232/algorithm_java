import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] board;

    public static int getCoinNum(int r, int c){
        int answer = 0;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                answer += board[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        String[] inputArr;
        for(int i=0; i<n; i++){
            inputArr = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i+2>=n || j+2>=n) continue;

                answer = Math.max(answer, getCoinNum(i, j));
            }
        }
        System.out.println(answer);
    }
}