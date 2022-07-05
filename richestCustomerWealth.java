/**
 * richestCustomerWealth
 */
public class richestCustomerWealth {

    public static void main(String[] args) {
        /*
         * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank. 
         * Return the wealth that the richest customer has.
         * The richest customer is the customer that has the maximum wealth.
         */
        int[][] accounts = {{2,8,7}, {7,1,3}, {1,9,5}};

       System.out.println(maximumWealth(accounts));
    }
    public static int maximumWealth(int[][] accounts){
        int max = 0;
        int tempMax = 0;

        for(int i = 0; i<accounts.length; i++){
            for(int j = 0; j<accounts[i].length; j++){
                //set tempMax to the sum of all elements within [i][j]
                tempMax += accounts[i][j];

                //if tempMax is greater than max (the first index it will be since max is set to 0), then set max to tempMax
                if(tempMax > max){
                    max = tempMax;
                }
            }
            //reset tempMax to 0 after each i'th iteration. Otherwise it will return the complete sum of all elements + the complete sum of all j elements
            tempMax = 0;
        }

      return max;
    }
}
/*
 *  for(int i = 0; i<accounts.length; i++){
           for(int j = 0; j < accounts[i].length; j++){
            System.out.print(accounts[i][j] + "\t");
           }
           System.out.println();
        }
 */