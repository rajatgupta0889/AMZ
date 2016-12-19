import java.util.Scanner;

/**
 * Created by rajat on 16/12/16.
 */

/*
* Given an n x m  matrix, find and print the number of cells in the largest region in the matrix.
* Note that there may be more than one region in the matrix.
*
*
* Consider a matrix with  rows and  columns, where each cell contains either a  or a  and any cell containing a  is called a filled cell.
* Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally;
* in other words, cell  is connected to cells , , , , , , , and , provided that the location exists in the matrix for that .
* If one or more filled cells are also connected, they form a region.
* Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells
* in the region.
*
*
* Input Format
*   1. The first line contains an integer, , denoting the number of rows in the matrix.
*   2. The  second line contains an integer, , denoting the number of columns in the matrix.
*   3. Each line  of the  subsequent lines contains  space-separated integers describing the respective values filling each row in the matrix.
*
*
*   https://www.hackerrank.com/challenges/connected-cell-in-a-grid
* */


public class ConnectedCellInGrid {

    static final int[] R_OFFSETS = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static final int[] C_OFFSETS = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];
        int maxRegion = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!visited[r][c] && matrix[r][c] == 1) {
                    maxRegion = Math.max(maxRegion, countRegion(matrix, visited, r, c));
                }
            }
        }
        System.out.println(maxRegion);

        sc.close();
    }

    static int countRegion(int[][] matrix, boolean[][] visited, int r, int c) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (!(r >= 0 && r < row && c >= 0 && c < col) || !(matrix[r][c] == 1 && !visited[r][c])) {
            return 0;
        }

        visited[r][c] = true;

        int region = 1;
        for (int i = 0; i < R_OFFSETS.length; i++) {
            region += countRegion(matrix, visited, r + R_OFFSETS[i], c + C_OFFSETS[i]);
        }
        return region;
    }
}
