public class demo2319 {
    //判断矩阵是否是一个 X 矩阵 简单 枚举
    public boolean checkXMatrix(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(0==grid[i][j]){
                    if(i==j||i+j==grid.length-1){
                        return false;
                    }
                }else{
                    if(i!=j&&i+j!=grid.length-1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
