package lecture.school.middle_exercise;

public class ReversingArray {

    public static void reversingArray(int[] arr, int lt, int rt){
        if(lt>=rt) return;
        swap(arr, lt, rt);
        reversingArray(arr, lt+1, rt-1);
    }

    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 4, 9, 2, 0, 8, 6};
        for (int i : arr) System.out.print(i+" ");
        System.out.println();
        reversingArray(arr, 0, arr.length-1);
        for (int i : arr) System.out.print(i+" ");
    }
}
