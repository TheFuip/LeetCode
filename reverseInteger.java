import java.util.ArrayList;
import java.util.List;

public class reverseInteger {
    public static void main(String[] args) {
        /*
         * Given a 32-bit integer, x return x with it's digit's reversed
         * if the int contains 10 or more digits, parseInt will fail and produce a
         * NumberFormatException
         * EX: 1234567890 -> NumberFormatException, eceeds the range of target data type
         * constrains 2^31-1
         */
        // reverse(-123);
        System.out.println(reverse(-120));
    }

    // TODO
    public static int reverse(int x) {
        boolean neg = false;

        //if x is initially negative make it positive by multiplying -1 which results in positive value of x without changing the initial content
        if (x < 0) {
            neg = true;
            x *= -1;
        }

        //an int will result in NumberFormatException so we must use a long to bypass this
        long reverse = 0;


        while (x > 0) {
            //we will continuously append a single digit at a time near the end of x to the beginning of reverse by using the mod operator for x
            reverse = reverse * 10 + x % 10;
            
            //keep dividing by 10 aka eleminating one digit until x has no more digits, effectively killing the loop
            x /= 10;
        }
        
        //if x is greater than the constraint, 2 ^ (31)-1 return 0
        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }

        //conditional return if it is negative just make it positive by multiplying a negative with another negative, otherwise just return the standard reverse value
        return (int) (neg ? -1 * reverse : reverse);
    }
}

/*
 * //sNum holds the string value of x
 * String sNum = "";
 * //num is the string that builds up from scratch
 * String num = "";
 * //tempNum holds the original value of x unaltered. This is used near the end
 * of the program to check if the original number being reversed is a negative,
 * to avoid NumberFormatException
 * int tempNum = x;
 * 
 * //if the value is indeed negative, convert it to a positive value to make
 * reversing easier. This is done by just multiplying -1 to x, as 2 negatives
 * make a positive
 * if (x < 0) {
 * x *= -1;
 * }
 * 
 * //System.out.println("tN : "+tempNum);
 * 
 * //convert the int value to a string
 * sNum = Integer.toString(x);
 * 
 * //begin on the right side aka(the end of the string), and continuously add
 * each char to num one char at a time
 * for (int i = sNum.length() - 1; i >= 0; i--) {
 * num += sNum.charAt(i) + "";
 * }
 * 
 * //now check if tempNum aka original unaltered value was negative. If it was
 * we take the current positive num and multiply by a negative -1 which makes
 * the positive into a negative avoiding NumberFormatException, otherwise parse
 * the string num to an int and return it
 * return tempNum < 0 ? (Integer.parseInt(num) * -1) : (Integer.parseInt(num));
 * }
 */