public class searchTwoDMatrix {
    public static void main(String[] args) {
        /*
         * Write an efficient algorithm that searches for a value target in an m x n
         * integer matrix matrix. This matrix has the following properties:
         * 
         * Integers in each row are sorted from left to right.
         * The first integer of each row is greater than the last integer of the
         * previous row.
         * 
         * m = row
         * n = col
         * 
         * parameters:
         * 1 <= m, n <= 100
         * 
         */
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 13));
    }

    // try 2 pointer binary search?
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] < target){
                col++;
            }
            else if (matrix[row][col] > target){
                row--;
            }
        }
        return false;
    }
}
