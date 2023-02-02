public class demo200 {
    //岛屿数量
    public int numIslands(char[][] grid) {
        int ret=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ret++;
                    f(grid,i,j);
                }
            }
        }
        return ret;
    }
    public void f(char[][] grid,int i,int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length) {
            if(grid[i][j]=='1'){
                grid[i][j]='0';
                f(grid,i+1,j);
                f(grid,i-1,j);
                f(grid,i,j+1);
                f(grid,i,j-1);
            }
        }
    }
    public static void main(String[] args) {

    }
}
