public class integerReplacement {
    public static void main(String[] args) {
        /*
         * Given a positive integer n, you can apply one of the following operations:
         * 
         * If n is even, replace n with n / 2.
         * If n is odd, replace n with either n + 1 or n - 1.
         * Return the minimum number of operations needed for n to become 1.
         */
        System.out.println(intReplacement(655535));
    }

    public static int intReplacement(int n){
        if(n == Integer.MAX_VALUE){
            return 32;
        }

        int count = 0;

        while(n > 1){
            if(n % 2 == 0){
                n /= 2;
            }else if(n == 3){
                count += 2;
                break;
            }else if((n & 2) == 2){
                n++;
            }else{
                n--;
            }
            count++;
        }

        return count;
    }
}

/*
 * If n is even then the operation is fixed. If n is odd then we have two operations +1 or -1, so for this let's check the binary of the number. We need to check only the second bit of the number. (from right side)

Case 1. If the second bit is 1, then n+1 will remove the minimum of two 1 bits or more and n-1 will remove only one 1.

for example:

n = 1011 + 1 = 1100
n = 1011 - 1 = 1010
Case 2. If the second bit is 0 then n+1 will remove 1 bit and add one bit at the second position bit n-1 will remove 1 bit.

for example 

n = 1001 + 1 = 1010
n= 1001 - 1 = 1001
so base on the second bit we can decide if we have to do +1 or -1.

Special case: for n = 3 there are only 2 steps.
 */