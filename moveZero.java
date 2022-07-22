
public class moveZero {
    public static void main(String[] args) {
        /*
         * Given an integer array, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
         * Note: cannot make a copy of the array
         * 
         * EX: [0,1,0,3,12] = [1,3,12,0,0]
         */
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums){
        int temp = 0;

        /*
         * Basic runthrough is this for example [0,1,0,3,12]
         * nums[i] = 0 -> so just ignore conditional sequence
         * nums[i] = 1 -> first conditional sequence true -> i(= 1) is greater than temp(= 0) -> second conditional sequence true
         * set nums[temp](= 0) -> nums[i](= 1) -> nums[i](= 1) -> 0 + increment temp by one, rinse and repeat :P
         */
        for(int i = 0; i < nums.length; i++){
           if(nums[i] != 0){
            if(i > temp){
                nums[temp] = nums[i];
                nums[i] = 0;
            }
            temp++;
           }
        }

        for(int n: nums){
            System.out.print(n + ", ");
        }
    }
}
