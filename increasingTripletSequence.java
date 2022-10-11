public class increasingTripletSequence {
    public static void main(String[] args) {
        /*
         * Given an integer array nums, return true if there exists a triple of indices
         * (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
         * indices exists, return false.
         */
        int[] nums = {1,2,1,3};

        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums){
        if(nums.length < 3){
            return false;
        }
        
        int small = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= small){
                //will hold the smallest number present or the lowest value of the sequence
                small = nums[i];
            }else if(nums[i] <= max){
                //if the current i'th value of nums is greater than the small value set max to the current nums[i] 'th' value
                max = nums[i];
            }else{
                //otherwise, by sequential logic, we have a triplet subsequence, because if the i'th value of nums is greater than the small value, and the i'th value is greater than the max, return true as this indicates a triplet subsequence (i > small -> i > max ... therefore k < j < i)
                return true;
            }
        }
        return false;
    }
}
