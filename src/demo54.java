import java.util.ArrayList;
import java.util.List;

public class demo54 {
    //螺旋矩阵   控制边界
    public static List<Integer> spiralOrder(int[][] r) {
        List<Integer> ret=new ArrayList<>();
        int m = r.length;
        int n = r[0].length;
        int top=0,right=n-1,bottom=m-1,left=0;
        for(int i=1;i<=m*n;){
            for(int t=left;t<=right&&i<=m*n;t++){
                ret.add(r[top][t]);i++;
            }top++;
            for(int t=top;t<=bottom&&i<=m*n;t++){
                ret.add(r[t][right]);i++;
            }right--;
            for(int t=right;t>=left&&i<=m*n;t--){
                ret.add(r[bottom][t]);i++;
            }bottom--;
            for(int t=bottom;t>=top&&i<=m*n;t--){
                ret.add(r[t][left]);i++;
            }left++;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

}