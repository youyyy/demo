package Test0830;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution a = new Solution();
        a.colorBorder(new int[][]{{1,1},{1,2}},0,0,3);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        colorf(grid,row,col,color,grid[row][col]);
        return grid;
    }
    public int[][] colorf(int[][] grid, int row, int col, int color,int pre) {
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length){
            if(grid[row][col] == pre){
                grid[row][col] = color;
                if(row>0 && col>0){
                    colorf(grid,row-1,col-1,color, pre);
                }
                if(col>0 && row<grid.length-1){
                    colorf(grid,row+1,col-1,color, pre);
                }
                if(col<grid[0].length-1 && row>0){
                    colorf(grid,row-1,col+1,color, pre);
                }
                if(col<grid[0].length-1 && row<grid.length-1){
                    colorf(grid,row+1,col+1,color, pre);
                }
            }

        }
        return grid;
    }


}