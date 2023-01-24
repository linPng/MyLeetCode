public class demo74 {
    //搜索二维矩阵 二分
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0,r=m*n-1;
        while(l<=r){
            int mid=(r+l)/2;
            int a=mid/n,b=mid%n;
            int t=matrix[a][b];
            if(t==target){
                return true;
            }else if(t>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}