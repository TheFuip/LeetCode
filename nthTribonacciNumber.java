import java.util.HashMap;

public class nthTribonacciNumber {
    public static void main(String[] args) {
        /*
         * The tribonacci sequence T(n) is defined as follows:
         * T(0) - 0, T(1) = 1, T(2) = 1; T(3) = T(2) + (T1) + T(0) for n >= 0
         * Given n, return the value of T(n).
         * 
         * EX: n = 4
         *  . T_3 = 0 + 1 + 1 = 2
         *  . T_4 = 1 + 1 + 2 = 4
         * 
         * Constraints = 0 <= n <= 37
         * Answer is garunteed to fit within a 32 bit integer. so answer will never be greater than 2^31 - 1
         */
        System.out.println(tribonacci(37));
    }
    //solved using dynamic programming :D
    public static int tribonacci(int n){
        return tribonacciMemoization(n, new HashMap<Integer, Integer>());
    }

    public static int tribonacciMemoization(int n, HashMap<Integer, Integer> memo){
        if(n == 0){
            return n;
        }

        //we add these conditionals because we don't want the value of n dipping into a negative range.
        if(n <= 2){
            return 1;
        }

        //if the memo contains the key(n) return the value associated with n -> determined by this //tribonacciMemoization(n-1, memo) + tribonacciMemoization(n-2, memo) + tribonacciMemoization(n-3, memo
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        //populate the map, n being the key and the recursive values of n-1 + n-2 + n-3 as the value for each n'th key
        memo.put(n, tribonacciMemoization(n-1, memo) + tribonacciMemoization(n-2, memo) + tribonacciMemoization(n-3, memo));

        //continue reiteration
        return tribonacciMemoization(n-1, memo) + tribonacciMemoization(n-2, memo) + tribonacciMemoization(n-3, memo);
    }
}
