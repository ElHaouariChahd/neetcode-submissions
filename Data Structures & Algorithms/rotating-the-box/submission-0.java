class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                int pos = j;

                while (pos + 1 < n
                        && boxGrid[i][pos] == '#'
                        && boxGrid[i][pos + 1] == '.') {

                    char temp = boxGrid[i][pos];
                    boxGrid[i][pos] = boxGrid[i][pos + 1];
                    boxGrid[i][pos + 1] = temp;

                    pos++;
                }
            }
        }

        // Il reste à effectuer la rotation de 90°.
        char[][] result = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return result;
    }
}