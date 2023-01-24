public class demo48 {
    //旋转图像 中等
    public void rotate(int[][] m) {
        int n=m.length;
        int t;
        for(int i=0;i<n-n/2;i++){
            for(int j=0;j<n/2;j++){
                t=m[i][j];
                m[i][j]=m[n-1-j][i];
                m[n-1-j][i]=m[n-1-i][n-1-j];
                m[n-1-i][n-1-j]=m[j][n-1-i];
                m[j][n-1-i]=t;
            }
        }
    }
    public static void main(String[] args) {

    }
}