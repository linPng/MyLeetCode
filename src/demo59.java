public class demo59 {
    //螺旋矩阵 II
    public static int[][] generateMatrix(int n) {
        int[][] r=new int[n][n];
        int top=0,right=n-1,bottom=n-1,left=0;
        for(int i=1;i<=n*n;){
            for(int t=left;t<=right;t++){
                r[top][t]=i++;
            }top++;
            for(int t=top;t<=bottom;t++){
                r[t][right]=i++;
            }right--;
            for(int t=right;t>=left;t--){
                r[bottom][t]=i++;
            }bottom--;
            for(int t=bottom;t>=top;t--){
                r[t][left]=i++;
            }left++;
        }
        return r;
    }
    public static void main(String[] args) {
        generateMatrix(3);
    }

}