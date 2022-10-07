public class jumpGame {
    public static void main(String[] args) {
        /*
         * You are given an integer array nums. You are initially positioned at the
         * array's first index, and each element in the array represents your maximum
         * jump length at that position.
         * 
         * Return true if you can reach the last index, or false otherwise.
         */
        int[] nums = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }

    //greedy -> O(n) time | constant space 
    public static boolean canJump(int[] nums){
        //if there is only 1 element in the array just return true, ince we can onviously reach the end of the array
        if(nums.length == 1){
            return true;
        }

        //if the first value in the array is greater or equal than the number of elements present in the array return true
        if(nums[0] >= nums.length){
            return true;
        }

        //if the array starts with 0, that means we can not move up since we have 0 jumping power, therefore return false
        if(nums[0] == 0){
            return false;
        }

        //this will keep track of our starting jump power
        int count = nums[0];

        //since we set count to the first value in the array we start the array at the second element, and stop the loop once we reach the end of the array
        for(int i = 1; i < nums.length; i++){
            //if the current value of nums is greater or equal than count, we update count to reflect that value; however if count is set to 0 that means we cannot jump anymore so we dont count this conditional sequence and just deduct 1 from count
            if(nums[i] >= count && count > 0){
                count = nums[i];
            }else{ //otherwise if the value of count is greater than the value of nums[i] we just deduce 1 from count
                count--;
            }
        }

       //when it is all said and done, if count is negative value return false since we ran out of jumping power, otherwise if its 0 or greater than indicates we had enough jump power to rech the end successfully 
       return count < 0 ? false : true;
    }
}
