/**
 * minimumPathSum
 */
import java.util.*;
public class minimumPathSum {

    public static void main(String[] args) {
        /*
         * Given a m x n grid filled with non-negative numbers, find a path from top
         * left to bottom right, which minimizes the sum of all numbers along its path.
         * 
         * Note: You can only move either down or right at any point in time.
         */
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    //dyanmic programming + recursive memoization, w/ constant extra space
    public static int minPathSum(int[][]grid){
        //instead of beginning at the start of the matrix[0][0] we begin at the last row and col
        int row = grid.length;
        int col = grid[0].length;

        //call the private helper function and return the value it produces
        return helper(grid, row - 1, col - 1, new int[row + 1][col + 1]);
    }

    private static int helper(int[][]grid, int row, int col, int[][]dp){
        //if the row is 0 and the col is 0, i.e end case this means we have fully traversed the matrix so exit the recursion
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        
        //if the row and col are both greater than 0 add it to the memo array dp
        if(dp[row][col] != 0){
            return dp[row][col];
        }

        //if the row is greater than 0 but the col is 0, update the memo array with this info and traverse vertically since it is impossible to traverse horizontally anymore
        if(row != 0 && col == 0){
            return dp[row][col] = grid[row][col] + helper(grid, row - 1, col, dp);
        }

        //otherwise if the row is 0, but the col is not; update the memo and traverse horizontally as we cannot trverse vertically anymore, since we reach the final row
        if(row == 0 && col != 0){
            return dp[row][col] = grid[row][col] + helper(grid, row, col - 1, dp);
        }

        //from here we will determine which path, contains the smaller number (vertical or horizontal) and traverse accordingly, hence the Math.min
        return dp[row][col] = grid[row][col] + Math.min(helper(grid, row - 1, col, dp), helper(grid, row, col - 1, dp));
    }
}

/*
 *standard recursion, didn't work :/ timelimit exceeded
 *  public static int minPathSum(int[][]grid){
        //instead of beginning at the start of the matrix[0][0] we begin at the last row and col
        int row = grid.length;
        int col = grid[0].length;

        //call the private helper function and return the value it produces
        return helper(grid, row - 1, col - 1);
    }

    private static int helper(int[][]grid, int row, int col){
        //if the row is 0 and the col is 0, i.e end case this means we have fully traversed the matrix so exit the recursion
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        //when it is the first row, the only possible traversal is to move horizontally, as we can not traverse vertically anymore
        if(row == 0){
            return grid[row][col] + helper(grid, row, col - 1);
        }
        //if the first column then it means we can only move vertically and not horizontally otherwise we get arrayindexoutofbounds since there are no -1 index positions
        if(col == 0){
            return grid[row][col] + helper(grid, row - 1, col);
        }

        //here we will traverse the grid based on which index position (vertical, horizontal) contains the smallest value, hence the math.min :P
        return grid[row][col] + Math.min(helper(grid, row - 1, col), helper(grid, row, col - 1));
    }
 */