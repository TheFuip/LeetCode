/**
 * powerOfFour
 */
public class powerOfFour {

    public static void main(String[] args) {
        /*
         * Given an integer, return true if it is a power of four.
         * Otherwise return false.
         * An integer is a power of four, if there exists an integer 'x' such that n == 4^x
         */
        System.out.println(isPowerFour(2));
    }

    public static boolean isPowerFour(int n){
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }

        if(n % 4 != 0){
            return false;
        }

        return isPowerFour(n / 4);
    }
}