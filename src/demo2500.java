import java.util.Arrays;

public class demo2500 {
    //删除每行中的最大值
    public int deleteGreatestValue(int[][] grid) {
        int ret=0;
        for(int[] i:grid){
            Arrays.sort(i);
        }
        for(int i=grid[0].length-1;i>=0;i--){
            int max=0;
            for(int j=0;j<grid.length;j++){
                max=Math.max(max,grid[j][i]);
            }
            ret+=max;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}