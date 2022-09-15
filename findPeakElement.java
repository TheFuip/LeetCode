public class findPeakElement {
    public static void main(String[] args) {
        /*
         * A peak element is an element that is strictly greater than its neighbors.
         * 
         * Given a 0-indexed integer array nums, find a peak element, and return its
         * index. If the array contains multiple peaks, return the index to any of the
         * peaks.
         * 
         * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
         * always considered to be strictly greater than a neighbor that is outside the
         * array.
         * 
         * You must write an algorithm that runs in O(log n) time.
         * 
         * Input: nums = [1,2,3,1]
         * Output: 2
         * Explanation: 3 is a peak element and your function should return the index
         * number 2.
         * 
         * binary search time :)
         * binary search is always O(log n) time complexity
         */
        int[] nums = {6,2,1,4,2,3,2};
        System.out.println(peakElement(nums));
        //System.out.println(solution(nums));
    }

    /*
     * binary search algorithm:
     * basic explanation:
     * 
     * have while loop condition being while start is less than end
     * middle will be the current value of start + end / 2
     * 
     */
    public static int peakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (start + end) / 2;
            System.out.println("mid " + mid);
            if(nums[mid] > nums[mid + 1]){
                end = mid;
                System.out.println("end " + end);
            }else{
                start = mid + 1;
                System.out.println("start "+ start);
            }
        }
        return start;
    }

    //2 pointer solution :: faster than the binary search option and less space too but since the problem asks for O(log n) runtime \/(-_-)\/
    public static int solution(int[] nums){
       //2 pointer
       int max = 0;
       int temp = nums[0];
       
       for(int i = 1; i < nums.length; i++){
           if(nums[i] > temp){
               temp = nums[i];
               max = i;
           }
       }
       return max; 
    }
}
