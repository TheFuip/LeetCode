public class arrangingCoins {
    public static void main(String[] args) {
        /*
         * You have n coins and you want to build a staircase with these coins. The
         * staircase consists of k rows where the ith row has exactly i coins. The last
         * row of the staircase may be incomplete.
         * 
         * Given the integer n, return the number of complete rows of the staircase you
         * will build.
         */
        System.out.println(arrangeCoins(5));
    }
    public static int arrangeCoins(int n){
        int target = 1;

        //until n is 0 or less than 0
        while(n >= 0){
            //if the target(staircase) requires more counters currently present in n, return the previous counter/staircase value (hence the -1)
            if(target > n){
                return target - 1;
            }

            //subtract target from n & increment target by 1
            n -= target;
            target++;
        }

        return target;
    }
}
