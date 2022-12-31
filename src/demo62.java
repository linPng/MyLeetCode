public class demo62 {
    //不同路径 Cnm
    public static int uniquePaths(int m, int n) {
        long a=m-1,b=m+n-2,r=1;
        for(int i=0;i<a;i++){
            r=r*(b-i)/(i+1);
        }
        return (int)r;
        /*
        * long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;*/
    }
    //动态规划
    public static int uniquePaths2(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
    public static void main(String[] args) {
        System.out.println(" = " + uniquePaths(59,5));
    }

}