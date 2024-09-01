package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 현재 숫자와 연산 순서를 저장할 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n});

        // 방문한 숫자를 저장할 집합
        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int num = current[current.length - 1]; //가장 마지막에 들어간 숫자 가져옴

            if (num == 1) {
                System.out.println(current.length - 1);
                for (int i = 0; i < current.length; i++) {
                    System.out.print(current[i] + " ");
                }
                return;
            }

            if (num % 3 == 0 && !visited.contains(num / 3)) {
                visited.add(num / 3);
                queue.add(append(current, num / 3));
            }
            if (num % 2 == 0 && !visited.contains(num / 2)) {
                visited.add(num / 2);
                queue.add(append(current, num / 2));
            }
            if (!visited.contains(num - 1)) {
                visited.add(num - 1);
                queue.add(append(current, num - 1));
            }
        }
    }

    private static int[] append(int[] arr, int newElement) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = newElement;
        return newArr;
    }
}


