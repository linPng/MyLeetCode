package planning.BasicDataStructures.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @autthor LinP
 * @create 2023-08-18 11:10
 */
public class Array03_1260_Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ret = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                int x=j+k;
                int y=i;
                if(x>=n){
                    y+=x/n;
                    x=x%n;
                }
                if(y>=m){
                    y=y%m;
                }
                ret[y][x]=grid[i][j];
            }
        }
        List re = new ArrayList();
        for(int i=0;i<m;i++) {
            List re2 = new ArrayList();
            for (int j = 0; j < n; j++) {
                re2.add(ret[i][j]);
            }
            re.add(re2);
        }
        return re;
    }
}
