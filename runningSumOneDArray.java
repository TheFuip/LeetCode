public class runningSumOneDArray {
    public static void main(String[] args) {
        /*
         * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]...nums[i]).
         * Return the running sum of nums.
         * EX: nums = [1,1,1,1,1] -> [1, 1+2 + 1+2+3 + 1+2+3+4] -> [1,2,3,4,5]
         */
        int[] nums = {3,1,2,10,1};

        nums = solution(nums);

        for(Integer i : nums){
            System.out.print(i + ", ");
        }
    }
    public static int[] solution(int[] nums){
        //set the sum to 0
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            //for each iteration have sum = sum + the current value index value stored inside of array nums;
            sum+=nums[i];

            //update the current index value of [i] with the current value of sum
            nums[i] = sum;
        }

        return nums;
    }
}
