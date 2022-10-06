public class islandPerimeter {
    public static void main(String[] args) {
        /*
         * You are given row x col grid representing a map where grid[i][j] = 1
         * represents land and grid[i][j] = 0 represents water.
         * 
         * Grid cells are connected horizontally/vertically (not diagonally). The grid
         * is completely surrounded by water, and there is exactly one island (i.e., one
         * or more connected land cells).
         * 
         * The island doesn't have "lakes", meaning the water inside isn't connected to
         * the water around the island. One cell is a square with side length 1. The
         * grid is rectangular, width and height don't exceed 100. Determine the
         * perimeter of the island.
         * 
         * dfs
         */
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(perimeter(grid));
    }
    public static int perimeter(int[][]grid){
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                //if a 1 is encountered immediately add 4 to the result
                if(grid[row][col] == 1){
                    res += 4;

                    //now check if the row value is greater than 0 and if there are any additional vertical intersections (we add greater than 0, to avoid the program checking for index -1) if there are add -2 to the result
                    if(row > 0 && grid[row - 1][col] == 1){
                        res -=2;
                    }

                    //check if col is greater than 0 and there are no horizontal 1 intersections, if there are add -2 to the result (once again we check to see its greater so we avoid program checking -1)
                    if(col > 0 && grid[row][col - 1] == 1){
                        res -=2;
                    }
                }
            }
        }

        return res;
    }

}
