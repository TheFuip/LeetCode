public class convert1DArrayInto2DArray {
    public static void main(String[] args) {
        /*
         * You are given a 0-indexed 1-dimensional (1D) integer array original, and two
         * integers, m and n. You are tasked with creating a 2-dimensional (2D) array
         * with m rows and n columns using all the elements from original.
         * 
         * The elements from indices 0 to n - 1 (inclusive) of original should form the
         * first row of the constructed 2D array, the elements from indices n to 2 * n -
         * 1 (inclusive) should form the second row of the constructed 2D array, and so
         * on.
         * 
         * Return an m x n 2D array constructed according to the above procedure, or an
         * empty 2D array if it is impossible.
         * 
         * row is horizontal
         * col is vetical
         */
        int[] nums = {1,2};

        int[][] twoD = construct2DArray(nums, 1, 1);

        printMatrix(twoD);
    }

    public static int[][] construct2DArray(int[]nums, int m, int n){
        //base case just return a blank array, as the only acceptable condition to convert a 1d array to a 2d array is if m * n == nums.length
        if(m * n != nums.length){
            return new int[][]{};
        }

        //populate new array where m represents the number of rows, and n represents the number of columns
        int[][] ans = new int[m][n];

        //set the count to -1 the reason we dont set it to 0 is because the incrementation will exceed the length of the array nums
        int count = -1;

        //here we will rely on count to populate the values inside of ans matrix. 
        //it will first loop over the first iteration of row then move to col where it will increment count by 1 (in the first case count will become 0..) 
        //then the first row value of ans will be set to the current val of count (0) and the col will be the first value of count also 0.
        //and since row is set to run while it is less than m, and col is set to run until it reaches n; count will only increment from 0 to 1 on the first loop
        //than from 2 to 3 assuming the length is 4 (1,2,3,4)
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                count++;

                ans[row][col] = nums[count];
            }
        }

        return ans;
    }

    //print matrix
    public static void printMatrix(int[][]matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

