package lecture.school.middle_exercise;

//public class FindPeakValue {
//    public static void findPeakValue(int[] arr, int lt, int rt){
//        if(lt==rt){
//            System.out.println(arr[lt]);
//            return;
//        }
//        int mid = (lt+rt) / 2;
//        if(arr[mid-1]<arr[mid]) findPeakValue(arr, mid+1, rt);
//        else findPeakValue(arr, lt, mid-1);
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {12, 15, 72, 25, 32, 35, 40, 45, 31, 26, 12, 9, 7, 3};
//        findPeakValue(arr, 0, arr.length-1);
//    }
//}

public class FindPeakValue {
    public static void findPeakValue(int[] arr, int lt, int rt) {
        if (lt <= rt) {
            int mid = (lt + rt) / 2;

            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
                // arr[mid]가 좌우 이웃보다 큰 경우에만 피크로 처리합니다.
                System.out.println(arr[mid]);
            }

            if (mid == 0 || arr[mid - 1] <= arr[mid]) {
                // 왼쪽 부분 배열을 탐색
                findPeakValue(arr, mid + 1, rt);
            }

            if (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]) {
                // 오른쪽 부분 배열을 탐색
                findPeakValue(arr, lt, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 72, 25, 32, 35, 40, 45, 31, 26, 12, 9, 7, 3};
        findPeakValue(arr, 0, arr.length - 1);
    }
}