
public class bestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        /*
         * You are given prices where prices[i] is the price of a given stock on the ith
         * day.
         * You want to maximize your profit by choosing a single day to buy one stock
         * and choosing a different day in the future to sell that stock
         * Return the maximum profit you can acheive from this transaction if you cannot
         * acheive any profit return 0.
         */
        int[] prices = { 2, 4, 1 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        //check if array is empty or maybe there is only 1 value inside of prices, if so return 0
        if (prices == null || prices.length <= 1)
            return 0;

        //min will begin at the first index, as such we will start the loop at index 1 instead of 0
        int min = prices[0]; // min so far

        //will hold the total after the cost from buying + selling
        int max = 0;

        //start at index 1 end at the final index
        for (int i = 1; i < prices.length; i++) {
            //max will be a ternary function Math.max -> it will first contain 0, index[1] value - min (index[0]) from there it will update with current loop data
            max = Math.max(max, prices[i] - min);
            //min will hold the first index of 0, and be updated based on if prices[i] is lower than the first index
            min = Math.min(min, prices[i]);
        }

        //just return it 
        return max;
    }
}

/*
 * if(prices==null||prices.length<=1)
 * return 0;
 * 
 * int min=prices[0]; // min so far
 * int result=0;
 * 
 * for(int i=1; i<prices.length; i++){
 * result = Math.max(result, prices[i]-min);
 * min = Math.min(min, prices[i]);
 * }
 * 
 * return result;
 */
