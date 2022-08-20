import java.util.Arrays;

public class singleNumberThree {
    public static void main(String[] args) {
        /*
         * Given an integer array, in which exactly two elements appear only once and all the other elements appear exactly twice.
         * Find the two elements that appear only once. You can return the answer in any order.
         * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
         */
        int[] nums = {0,1};
        int[] ans = singleNumber(nums);
        
        for(int n : ans){
            System.out.print(n + ", ");
        }
    }
    //constant extra space solution :: didnt even use bit manipulation xor ^ operator :P
    public static int[] singleNumber(int[] nums){
        //if the array only has 2 elements in it, just return those 2 elements
        if(nums.length == 2){
            return new int[]{nums[0], nums[1]};
        }
        //first sort the array to make selection process easier
        Arrays.sort(nums);
        //next, since the answer will always require an array with 2 values create new blank array with 2 index spaces
        int[] ans = new int[2];

        //here we will have variable that holds the first indice of the first unique single inside of nums
        int firstSingle = getSingleHelper(nums, -1);

        //just set ans[0] to nums[firstSingle] (which contains the indice of the first single)
        ans[0] = nums[firstSingle];
        ans[1] = nums[getSingleHelper(nums, firstSingle)]; //next we will set ans[1] to nums[getSingleHelper(nums, firstSingle)]; (we will set the second int parameter to firstSingle)
        
        return ans;
    }
    //this function basically works like this.
    //for the first single start at index 0 and keep progressing until you find the first single -> return the indice of the first single
    //for the second single begin the loop at the indice of the firstSingle + 1, as we know the previous values before the first single have all been tested
    //keep exploring until you find the next single
    private static int getSingleHelper(int[] nums, int index){
        //2 pointer
        int singleVal = nums[index + 1]; //single Val will hold nums[index + 1] parameter
        int singleIndex = index + 1; //single index will hold index + 1 parameter

        //here this variable will be used to check all the duplicate values as we know every non-single contains 2
        int count = 0;

        //start the loop at index parameter + 1(hence why we start the first ans[0] at -1...)
        for(int i = index + 1; i < nums.length; i++){
            //if count equals 2, that means the program has concluded that this is a duplicate value, so we can pdate singleVal to nums[i] and update singleIndex to i, also reset count to 0 to begin a new count cycle
            if(count == 2){
                singleVal = nums[i];
                singleIndex = i;
                count = 0;
            }

            //if the nums[i] = singleVal we know it is a duplicate, therefore increment count by 1
            if(nums[i] == singleVal){
                count++;
            }
        }

        return singleIndex;
    }
}
