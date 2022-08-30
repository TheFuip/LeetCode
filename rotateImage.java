public class rotateImage {
    public static void main(String[] args) {
        /*
         * You are given an n x n 2D matrix representing an image, rotate the image by
         * 90 degrees (clockwise).
         * 
         * You have to rotate the image in-place, which means you have to modify the
         * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
         * rotation.
         * [1,2,3]    [7,4,1]
         * [4,5,6] -> [8,5,2]
         * [7,8,9]    [9,6,3]
         */
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}}; 

        rotate(matrix);
    }

    public static void rotate(int[][] matrix){
        //int horizontal = matrix.length - 1;
        //int vertical = 0;

        int n = matrix.length;

        for(int i = 0; i < (n + 1) / 2; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[n - 1 - j][i];

                matrix[n - 1 - j][i] = matrix[ n - 1 -i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 -i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //print array
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + ", ");
            }
            System.out.println();
        }
    }
}

/*
 * i actually hate this question tbh the logic is so weird
 * for(int i = 0; i < matrix.length; i++){
            int horizontal = matrix.length-1;
            //int vertical = i == 0 ? i : 0 + i;
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = matrix[horizontal][i];
                System.out.println("v = " + i + " : h = "+ horizontal);
                horizontal--;
                //vertical++;;
            }
        }
 * 
 */