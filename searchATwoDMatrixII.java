public class searchATwoDMatrixII {
    public static void main(String[] args) {
        /*
         * Write an efficient algorithm that searches for a value target in an m x n
         * integer matrix matrix. This matrix has the following properties:
         * 
         * Integers in each row are sorted in ascending from left to right.
         * Integers in each column are sorted in ascending from top to bottom.
         */
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 5));
    }

    public static boolean searchMatrix(int[][]matrix, int target){
        //binary approach solution: O(log n) time and O(1) constant space

        //loop through rows in matrix normally
        for(int row = 0; row < matrix.length; row++){

            //for every row iteration set start to 0 (beginning of the column), and end to the end of the row[column]
            int start = 0;
            int end = matrix[row].length - 1;   

            //stop da loop until start is equal or greater than end (matrix[row].length - 1)
            while(start <= end){
                //middle as the name suggest is the middle between start and end
                int middle = (start + end) / 2;
                
                //if the matrix[row][middle] equals the target, we know the matrix contains the target therefore return true
                if(matrix[row][middle] == target){
                    return true;
                }
                
                //if the matrix[row][middle] is less than the target we will set start to the middle + 1, since all the other previous values from the middle are less than the target (divide and conquer)
                if(matrix[row][middle] < target){
                    start = middle + 1;
                }else{ //otherwise that means the matrix[row][end] is greater than the middle so set end to the middle - 1, as there is no need to check the other values since they are higher (divide and conquer)
                    end = middle - 1;
                }
            }
        }
        //after the matrix is traversed and the target is not found just return false
        return false;
    }
}
