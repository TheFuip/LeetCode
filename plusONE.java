import java.util.*;

public class plusONE {
    public static void main(String[] args) {
        /*
         * You are given a large integer represented as an integer array digits, where
         * each digits[i] is the ith digit of the integer.
         * The digits are ordered from most significant to least significant in
         * left-to-right order.
         * The large integer does not contain any leading 0's.
         * I.E -> [1,2,3] -> 123+1 -> 124, etc
         */
        int[] nums = {9};

        nums = solution(nums);
        printArray(nums, 0);
    }

    // print array
    public static void printArray(int[] nums, int n) {
        if (n == nums.length)
            return;
        System.out.print(nums[n] + ", ");
        printArray(nums, n + 1);
    }

    // challenge
    public static int[] solution(int[] digits) {
        
        for(int i = digits.length-1; i > -1; i--){
            //if the furthest right/last digit is not 9 increment the value of the last digit by 1 and return digits
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            //if the loop manages to iterate ahead of the previous one set the digit after 9 to 0
            digits[i] = 0;
        }

        //create a new array with one added index value in order to fit a new value -> i.e, 9 -> become 1,0; etc...
        int[] updatedDigits = new int[digits.length + 1];

        //set the very first index value to 0 of the new array
        updatedDigits[0] = 1;

        return updatedDigits;
    }
}
/*
 *   boolean isNine = false;

        for(int i = digits.length-1; i > -1; i--){
            if(digits[i] == 9){
                digits[i] = 0;
                isNine = true;
            }else if(isNine){
                digits[i] += 1;
                isNine = false;
            }
        }

        return digits;
 */