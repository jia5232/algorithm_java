package lecture.school.middle_exercise;

public class LinearSum {
    public static int sum(int[] arr, int sum, int index){
        if(index==arr.length) return sum;
        return sum(arr, sum+arr[index], index+1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 2, 4};
        System.out.println(sum(arr, 0, 0));
    }
}
