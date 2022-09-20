import java.util.*;

public class setMatrixZeroes {
    public static void main(String[] args) {
        /*
         * Given an m x n integer matrix matrix, if an element is 0, set its entire row
         * and column to 0's.
         * 
         * You must do it in place.
         */
        int[][] matrix = {{0,1,2,0}, 
                          {3,4,5,2},    
                          {1,3,1,5}};
        
        setZeroes(matrix);
    }
    public static void setZeroes(int[][]matrix){
        boolean bRow = false;
        boolean bCol = false;

        //check if each column and the first row has any 0's
        for(int col = 0; col < matrix.length; col++){
            if(matrix[col][0] == 0){
                bCol = true;
            }
        }

        //check if first row has any zeroes
        for(int row = 0; row < matrix[0].length; row++){
            if(matrix[0][row] == 0){
                bRow = true;
            }
        }

        //now we will scan the rest of the matrix for any zeros and mark the row and column using row and col
        for(int col = 1; col < matrix.length; col++){
            for(int row = 1; row < matrix[0].length; row++){
                if(matrix[col][row] == 0){
                    matrix[0][row] = 0;
                    matrix[col][0] = 0;
                }
            }
        }

        //now add 0 to the marked columns and rows
        //columns are looped through first to see if 0 is contained, then each row is updated to add a 0
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //rows are sorted first for any zeros, followed by columns then updated with 0's
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(bRow){
            for(int row = 0; row < matrix[0].length; row++){
                matrix[0][row] = 0;
            }
        }

        if(bCol){
            for(int col = 0; col < matrix.length; col++){
                matrix[col][0] = 0;
            }
        }

        //for(int j = 0; j < matrix.length; j++){
           // matrix[j][x] = 0;
      //  }

        //print matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static int[] setZero(int[]col){
        for(int n : col){
            n = 0;
        }
        return col;
    }
}

/*
 * Arrays.sort(matrix[row]);
            int start = 0;
            int end = matrix[row].length - 1;

            while(start <= end){
                int middle = (start + end) / 2;

                if(matrix[row][middle] == 0){
                    for(int i = 0; i < matrix[row].length; i++){
                        matrix[row][i] = 0;
                    }
                    
                }

                if(matrix[row][middle] < 0){
                    start = middle + 1;
                }else{
                    end = middle - 1;
                }
            }
 */