import java.util.*;

public class maximumSwap {
    public static void main(String[] args) {
        /*
         * You are given an integer num. You can swap two digits at most once to get the
         * maximum valued number.
         * 
         * Return the maximum valued number you can get.
         */
        System.out.println(maxSwap(2736));
    }
    public static int maxSwap(int num){
        if (num < 10) {
            return num;
        }

        StringBuffer sb = new StringBuffer(String.valueOf(num));

        int[] rightMax = new int[sb.length()];
        int[] maxIndex = new int[sb.length()];

        int max = -1;
        int index = 0;

        //find the array of maximums from right
        for(int i = sb.length() - 1; i > -1; i--){
            int current = Character.getNumericValue(sb.charAt(i));

            if(current > max){
                max = current;
                index = i;
            }

            rightMax[i] = max;
            maxIndex[i] = index;
        }

        //now we must find the numbers to swap
        for(int i = 0; i < sb.length(); i++){
            int current = Character.getNumericValue(sb.charAt(i));

            if(current < rightMax[i]){
                sb.setCharAt(maxIndex[i], String.valueOf(current).charAt(0));
                sb.setCharAt(i, String.valueOf(rightMax[i]).charAt(0));

                //kill the loop since we can only perform a max one one swap
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }

    //O(log n) time complexity using binary search w/ O(n) space
    //return the index that contains a certain int value within an array
    //also this is kind of pointless tbh, since the array is not a sorted/rotated one :P
    private static int findKthIndex(int[] digits, int n){
        int start = 0;
        int end = digits.length - 1;

        while(start <= end){
            int middle = start + (start + end) / 2;

            if(digits[middle] == n){
                return middle;
            }

            if(digits[middle] < n){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }

        return start;
    }

    private static int kthLargestElement(int[] digits, int k){
        Arrays.sort(digits);

        return digits[digits.length - k];
    }

    private static int countDigits(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }
}

/*
 * if (num < 10) {
            return num;
        }

        int index = countDigits(num);
        int[] digits = new int[index];
        index--;

        while (num > 0) {
            digits[index] = num % 10;
            num /= 10;
            index--;
        }

        for(int i = 0; i < digits.length-1; i+=2){
            if(digits[i] < digits[i + 1]){
                int temp1 = digits[i];
                int temp2 = digits[i + 1];
                digits[i] = temp2;
                digits[i + 1] = temp1;
            }
        }

        for(int n : digits){
            System.out.print(n + ", ");
        }
        // System.out.println(max);

        return -1;
 */