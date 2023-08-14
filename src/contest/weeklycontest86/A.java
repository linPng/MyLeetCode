package contest.weeklycontest86;

public class A {
    //840. 矩阵中的幻方
    //暴力 要注意题目是说1~9的不重复数字组成的
    int[][] g;
    public int numMagicSquaresInside(int[][] grid) {
        g=grid;
        int ret=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(isRight(i,j)){
                    ret++;
                }
            }
        }
        return ret;
    }
    public boolean isRight(int i,int j){
        try {
            if(g[i][j]+g[i+1][j]+g[i+2][j]!=g[i][j+1]+g[i+1][j+1]+g[i+2][j+1]){
                return false;
            }
            if(g[i][j]+g[i+1][j]+g[i+2][j]!=g[i][j+2]+g[i+1][j+2]+g[i+2][j+2]){
                return false;
            }
            if(g[i][j]+g[i][j+1]+g[i][j+2]!=g[i+1][j]+g[i+1][j+1]+g[i+1][j+2]){
                return false;
            }
            if(g[i][j]+g[i][j+1]+g[i][j+2]!=g[i+2][j]+g[i+2][j+1]+g[i+2][j+2]){
                return false;
            }
            if(g[i][j]+g[i+1][j+1]+g[i+2][j+2]!=g[i+2][j]+g[i+1][j+1]+g[i][j+2]){
                return false;
            }
            if(g[i][j]*g[i][j+1]*g[i][j+2]*g[i+1][j]*g[i+1][j+1]*g[i+1][j+2]*g[i+2][j]*g[i+2][j+1]*g[i+2][j+2]!=(1*2*3*4*5*6*7*8*9)){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
