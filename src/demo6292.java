public class demo6292 {
    //子矩阵元素加 1
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ret=new int[n][n];
        for(int[] e:queries){
            int row1=e[0], col1=e[1], row2=e[2], col2=e[3];
            for(int i=row1;i<=row2;i++){
                for(int j=col1;j<=col2;j++){
                    ret[i][j]+=1;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + rangeAddQueries(3,new int[][]{{1,1,2,2},{0,0,1,1}}));
    }

}