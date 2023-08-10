package contest.weeklycontest84;

public class C {
    //835. 图像重叠

    //暴力解 如果有trycatch就会超时
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int N=2*n-1;
        int[][] count = new int[2*n-1][2*n-1];
        int ret=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int x=i-n+1;
                int y=j-n+1;
                for(int a=0;a<n;a++){
                    for(int b=0;b<n;b++){
                        if(a+x>=0&&a+x<n&&b+y>=0&&b+y<n) {//比try catch快
                            if(img1[a+x][b+y]==1&&img2[a][b]==1){
                                count[i][j]++;
                            }
                        }
                    }
                }
                ret=Math.max(ret,count[i][j]);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
