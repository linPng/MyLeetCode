import java.util.ArrayDeque;
import java.util.Deque;

public class demo1210 {
    //穿过迷宫的最少移动次数
    //bfs+动态规划
    public static int minimumMoves(int[][] grid) {
        int n=grid.length;
        int[][][] dp=new int[n][n][2];
        dp[0][0][0]=1;//所有结果都加一
        //层序遍历 bfs
        Deque<int[]> deque = new ArrayDeque<int[]>();
        deque.add(new int[]{0,0,0});
        while (!deque.isEmpty()) {
            for (int i = 1; i <= deque.size(); ++i) {
                int[] d = deque.poll();
                int x=d[0],y=d[1],t=d[2];
                if(t==0){
                    if(x+1<n&&grid[x+1][y]==0&&grid[x+1][y+1]==0&dp[x+1][y][0]==0){
                        deque.add(new int[]{x+1,y,0});
                        dp[x+1][y][0]=dp[x][y][t]+1;
                    }
                    if(y+2<n&&grid[x][y+2]==0&dp[x][y+1][0]==0){
                        deque.add(new int[]{x,y+1,0});
                        dp[x][y+1][0]=dp[x][y][t]+1;
                    }
                    if(x+1<n&&grid[x+1][y]==0&&grid[x+1][y+1]==0&dp[x][y][1]==0){
                        deque.add(new int[]{x,y,1});
                        dp[x][y][1]=dp[x][y][t]+1;
                    }
                }else{
                    if(x+2<n&&grid[x+2][y]==0&dp[x+1][y][1]==0){
                        deque.add(new int[]{x+1,y,1});
                        dp[x+1][y][1]=dp[x][y][t]+1;
                    }
                    if(y+1<n&&grid[x][y+1]==0&&grid[x+1][y+1]==0&dp[x][y+1][1]==0){
                        deque.add(new int[]{x,y+1,1});
                        dp[x][y+1][1]=dp[x][y][t]+1;
                    }
                    if(y+1<n&&grid[x][y+1]==0&&grid[x+1][y+1]==0&dp[x][y][0]==0){
                        deque.add(new int[]{x,y,0});
                        dp[x][y][0]=dp[x][y][t]+1;
                    }
                }
            }
        }
        return dp[n-1][n-2][0]>0?dp[n-1][n-2][0]-1:-1;
    }
    public static void main(String[] args) {
//        System.out.println("minimumMoves = " + minimumMoves(new int[][]{{0,0,0,0,0,1},{1,1,0,0,1,0},{0,0,0,0,1,1},{0,0,1,0,1,0},{0,1,1,0,0,0},{0,1,1,0,0,0}}));
        System.out.println("minimumMoves = " + minimumMoves(new int[][]{{0,0,0,0,1,1},{1,1,0,0,0,1},{1,1,1,0,0,1},{1,1,1,0,1,1},{1,1,1,0,0,1},{1,1,1,0,0,0}}));
    }
}