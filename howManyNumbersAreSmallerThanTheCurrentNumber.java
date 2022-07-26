/**
 * howManyNumbersAreSmallerThanTheCurrentNumber
 */
public class howManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        /*
         * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
         * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

            Return the answer in an array.

            EX: 
            Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
         */

         int[] nums = {7,7,7,7};
         int[] ans = smallerNumbersThanCurrent(nums);

         for(int n : ans){
            System.out.print(n + ", ");
         }
    }

    //log O(n)
    public static int[] smallerNumbersThanCurrent(int[] nums){
        //set a new array proportionate to the length of nums[]
        int[] ans = new int[nums.length];

        //for each number inside of nums set the current index of ans to the return value of getSmallerNumbers method
        for(int i = 0; i < nums.length; i++){
            ans[i] = getSmallerNumbers(nums, nums[i]);
        }

        //return the array ans
        return ans;
    }

    public static int getSmallerNumbers(int[] nums, int n){
        //set count to 0
        int count = 0;

        //n will be passed as the current iteration of nums[i] from smallerNumbersThanCurrent parent function
        for(int i = 0; i < nums.length; i++){
            //every time n(which is the parent nums[i] is greater than nums[i](child method -> getSmallerNumbers) increment count)
            if(n > nums[i]){
                count++;
            }
        }

        return count;
    }
}