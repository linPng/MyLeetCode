public class demo240 {
    //搜索二维矩阵 II
    //Z搜索 特殊
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
    //二分
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int maxi=n-1;
        for(int l=0,r=n-1;l<=r;){
            if(matrix[0][l]==target||matrix[0][r]==target||matrix[0][(l+r)/2]==target){
                return true;
            }else if (matrix[0][(l+r)/2]>target){
                r=(l+r)/2-1;
                maxi=Math.min(maxi,r);
            }else {
                l=(l+r)/2+1;
            }
        }
        //遍历更小的数组
        for(int i=maxi;i>=0;i--){
            for(int l=0,r=m-1;l<=r;){
                if(matrix[l][i]==target||matrix[r][i]==target||matrix[(l+r)/2][i]==target){
                    return true;
                }else if (matrix[(l+r)/2][i]>target){
                    r=(l+r)/2-1;
                }else {
                    l=(l+r)/2+1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        demo240 demo240=new demo240();
        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println("demo240.searchMatrix(array,5) = " + demo240.searchMatrix(array,5));
    }
}