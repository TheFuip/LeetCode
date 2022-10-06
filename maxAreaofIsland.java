public class maxAreaofIsland {
    public static void main(String[] args) {
        /*
         * You are given an m x n binary matrix grid. An island is a group of 1's
         * (representing land) connected 4-directionally (horizontal or vertical.) You
         * may assume all four edges of the grid are surrounded by water.
         * 
         * The area of an island is the number of cells with a value 1 in the island.
         * 
         * Return the maximum area of an island in grid. If there is no island, return
         * 0.
         */
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxArea(grid));
    }

    public static int maxArea(int[][] grid){
        int max = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                //for each index in the matrix determine the max value of the private helper function max, and the current value of max
                max = Math.max(dfs(grid, row, col), max);
            }
        }

        return max;
    }

    private static int dfs(int[][]grid, int row, int col){
        //check if the row and col are greater than 0 in addition to the row and col not being greater than the max length (so we not get any arrayindexoutofboundsexception) also check if the matrix current value of [row]and [col] are not 0
        //if any of these conditionals are met by this if statement just return 0, as this is not an island space and is just water
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0){
            return 0;
        }

        //set each piece of land to 0, to indicate it has been traversed so to not count it again
        grid[row][col] = 0;

        //from here add 1 to the callstack and traverse the matrix vertically (up and down) by incrementing and decrementing the row, in addition to traversing the matrix horizontally (side to side) by incrementing and decrementing the col value
        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}