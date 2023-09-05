package planning.BasicDataStructures.Array;

import java.util.Arrays;

public class Array13_48_RotateImage {


    public void rotateError(int[][] matrix) {
        int t;
        int n=matrix.length;
        for(int i=0;i<n-n/2;i++){
            for(int j=0;j<n-n/2;j++){//这里的限制条件应该是j<n/2 ,不能覆盖之前旋转的,如果n是奇数就会错误
                t=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=t;
            }
        }
    }

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
        Array13_48_RotateImage dome=new Array13_48_RotateImage();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        dome.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
