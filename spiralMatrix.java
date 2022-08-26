import java.util.*;

public class spiralMatrix {
    public static void main(String[] args) {
        /*
         * Given an m x n matrix, return all elements of the matrix in spiral order
         */
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(spiralOrder(matrix));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            //go right
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;

            if(top > bottom){
                break;
            }

            //go down
            for(int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;

            if(right < left){
                break;
            }

            //go left
            for(int i = right; i >= left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;

            if(top > bottom){
                break;
            }

            //go up
            for(int i = bottom; i >= top; i--){
                list.add(matrix[i][left]);
            }
            left++;

            if(right < left){
                break;
            }
        }

        return list;
    }
}

/*
 * for(int row = 0; row < matrix.length; row++){
 * for(int col = 0; col < matrix[row].length; col++){
 * System.out.print(matrix[row][col] + ", ");
 * }
 * System.out.println();
 * }
 */