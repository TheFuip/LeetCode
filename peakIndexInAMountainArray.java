public class peakIndexInAMountainArray {
    public static void main(String[] args) {
        /*
         * An array arr a mountain if the following properties hold:
         * 
         * arr.length >= 3
         * There exists some i with 0 < i < arr.length - 1 such that:
         * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
         * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
         * Given a mountain array arr, return the index i such that arr[0] < arr[1] <
         * ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
         * 
         * You must solve it in O(log(arr.length)) time complexity.
         */
        int[] nums = {3,4,5,1};
        System.out.println(peakIndex(nums));
    }
    public static int peakIndex(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        //while start is less than end...
        while(start < end){
            //here we will set middle to start + (end - start) / 2 -> we put start first to avoid a stackoverflow or some kind of weird memory error, and we start it by end - start, otherwise we will get a negative index exception error
            int middle = start + (end - start) / 2;
            
            //if nums[middle] is less than the next index set start to the middle + 1
            if(nums[middle] < nums[middle + 1]){
                start = middle + 1;
            }else{ //otherwise set end to the middle
                end = middle;
            }    
        }

        return start;
    }
}
