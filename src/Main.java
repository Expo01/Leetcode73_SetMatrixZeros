import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// my solution, beats 91 and 41
class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> coordinate = new ArrayDeque<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    coordinate.add(new int[] {i,j});
                }
            }
        }

        while(!coordinate.isEmpty()){
            int[] cur = coordinate.poll();
            fill(cur[0],cur[1],matrix);
        }
    }

    private void fill(int row, int col, int[][]matrix){
        int tempRow = row;
        while(tempRow > -1){
            matrix[tempRow][col] = 0;
            tempRow--;
        }
        tempRow = row;
        while(tempRow < matrix.length){
            matrix[tempRow][col] = 0;
            tempRow++;
        }

        int tempCol = col;
        while(tempCol > -1){
            matrix[row][tempCol] = 0;
            tempCol--;
        }

        tempCol = col;
        while(tempCol < matrix[0].length){
            matrix[row][tempCol] = 0;
            tempCol++;
        }
    }
}

//option 1 double pass and store all 0 coordinates. second pass just DFS fill LRUD from 0 coord till OOB.
// could just store the 0 coordinates in a que
