import java.util.HashMap;

public class uniquePaths {
    public static void main(String[] args) {
        /*
         * There is a robot on an m x n grid. The robot initially is located at the top-left corner (i.e, grid[0][0]). 
         * The robot tries to move to the bottom-right corner (i.e, grid[m-1][n-1]). The robot can only move either down or right
         * at any point in time.
         * 
         * Given the 2 integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
         * 
         * The test cases, are generated so that the answer will be less than or equal to 2 * 10^9.
         * 
         * I.E: m = 3, n = 7 -> 28
         */
        System.out.println(solution(3, 7));
    }

    public static int solution(int m, int n){
        return gridMemoization(m, n, new HashMap<String, Integer>());
    }

    public static int gridMemoization(int m, int n, HashMap<String, Integer> memo){
        String key = m + n + "m" + n;
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        if(m == 1 || n == 1){
            return 1;
        }
        
        if(m <= 0 || n<= 0){
            return 0;
        }
        
        memo.put(key, gridMemoization(m-1, n, memo) + gridMemoization(m, n-1, memo));
        
        return gridMemoization(m-1, n, memo) + gridMemoization(m, n-1, memo);
    }
}
