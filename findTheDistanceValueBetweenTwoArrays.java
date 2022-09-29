import java.util.Arrays;

public class findTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        /*
         * Given two integer arrays arr1 and arr2, and the integer d, return the
         * distance value between the two arrays.
         * 
         * The distance value is defined as the number of elements arr1[i] such that
         * there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
         */
        int[] arr1 = {1,4,2,3};
        int[] arr2 = {-4,-3,6,10,20,30};
        System.out.println(findTheDistanceValue(arr1, arr2, 3));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d){
        Arrays.sort(arr2);

        int count = 0;

        for(int n : arr1){
           if(notInRange(arr2, (n - d), (n + d))){
            count++;
           } 
        }

        return count;
    }

    // Checks if the array doesn't contain any value in range (from <= value <= to) using binary search
    private static boolean notInRange(int[] arr, int from, int to){
        int start = 0; 
        int end = arr.length - 1;

        while(start <= end){
            int middle = (start + end) / 2;

            if(arr[middle] >= from && arr[middle] <= to){
                return false;
            }

            if(arr[middle] < from){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }

        return true;
    }
}
