class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int m=0;m<matrix.length ;m++){
            for(int n =0; n<matrix[m].length ;n++){
                if(matrix[m][n]==0){
                    row[m]=true;
                    column[n]=true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
