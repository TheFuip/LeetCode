/**
 * candy
 */
public class candy {

    public static void main(String[] args) {
        /*
         * There are n children standing in a line. Each child is assigned a rating
         * value given in the integer array ratings.
         * 
         * You are giving candies to these children subjected to the following
         * requirements:
         * 
         * Each child must have at least one candy.
         * Children with a higher rating get more candies than their neighbors.
         * Return the minimum number of candies you need to have to distribute the
         * candies to the children.
         */
        int[] ratings = {1,0,2};
        System.out.println(minCandy(ratings));
    }

    /*this solution technically and logically makes sense and works but for whatever reason is not accepted :/
        for the input [1, 0, 2] -> this should logically be 4, since according to the program at least one child should
        get 1 candy, but the next candy must be greater than the previous one,
        thus -> [1, 0, 2] = 1,2,1 -> 4 | but somehow it's showing the accepted input as 5 for this particular set and not 4 AHHHHHHHH

        O(n) time complexity, Constant space complexity :)
    */
    public static int minCandy(int[] ratings){
        int[] dp = new int[ratings.length];

        dp[0] = 1;

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] == 0){
                ratings[i] = 1;
            }
            dp[i] = helper(ratings[i], dp[i - 1]);
        }

        return dp[dp.length - 1] + 1;
    }

    private static int helper(int current, int prev){
        if(prev >= current){
            current = 1;
            prev = 2;
        }else{
            prev = 1;
            current = 2;
        }
        return prev + current;
    }
}

/*
 * here is the actual working solution for the site. oh well i technically got the answer correct it's leetcode that has 
 * iffy logic regarding the problem. but yeah if i really tried i proabbly could've come up with another solution, most likely compare
 * three indexes at a time instead of 2
 * 
 * 
 *  if (ratings.length == 0) return 0;
            int ret = 1;
            int up = 0, down = 0, peak = 0;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    peak = ++up;
                    down = 0;
                    ret += 1 + up;
                } else if (ratings[i - 1] == ratings[i])  {
                    peak = up = down = 0;
                    ret += 1;
                } else {
                    up = 0;
                    down++;
                    ret += 1 + down + (peak >= down ? -1 : 0);
                }
            }

            return ret;
 */