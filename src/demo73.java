import java.util.HashSet;
import java.util.Set;

public class demo73 {
    //矩阵置零 简单 标记
    public void setZeroes(int[][] matrix) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for(int i:set1){
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }
        }
        for(int j:set2){
            for(int i=0;i<m;i++){
                matrix[i][j]=0;
            }
        }
    }
    public static void main(String[] args) {

    }
}