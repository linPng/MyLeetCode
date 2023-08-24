public class demo1267 {
    //1267. 统计参与通信的服务器
    //模拟
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] cm=new int[m];
        int[] cn=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    cm[i]++;
                    cn[j]++;
                }
            }
        }
        int ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(cm[i]>1||cn[j]>1){
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
