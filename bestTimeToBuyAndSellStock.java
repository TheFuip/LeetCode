public class bestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        /*
         * You are given an integer array prices where prices[i] is the price of a given
         * stock on the ith day.
         * 
         * On each day, you may decide to buy and/or sell the stock. You can only hold
         * at most one share of the stock at any time. However, you can buy it then
         * immediately sell it on the same day.
         * 
         * Find and return the maximum profit you can achieve.
         * 
         * Input: prices = [7,1,5,3,6,4]
         * Output: 7
         * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit =
         * 5-1 = 4.
         * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
         * 3.
         * Total profit is 4 + 3 = 7.
         */
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    //greedy solution
    public static int maxProfit(int[] prices){
        int sell = 0;

        //since we are constantly checking between 2 indexes we set the closing statement of the loop to i < array.length - 1;
        for(int i = 0; i < prices.length - 1; i++){
            //here if the i'th value is less than the i + 1'th value, we take sell and add up the profit that can be made by instantly selling in one day
            //so we start with i + 1 value first since it's greater subtracted by the i'th value since it's less
            if(prices[i] < prices[i + 1]){
                sell += prices[i + 1] - prices[i];
            }
        }

        return sell;
    }
}

/*
 *  int buy = 0;
        int sell = 0;

        for(int i = 0; i < prices.length - 1; i++){
            buy = prices[i];

            if(buy > prices[i + 1]){
                buy = prices[i + 1];
            }else{
                sell += prices[i + 1] - buy;
            }
        }

        return sell;
 */