import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo132 {
    //分割回文串 II  动态规划预处理+动态规划
    public static int minCut(String s) {
        List<String> l=new ArrayList<>();
        int n=s.length();
        boolean[][] b=new boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(b[i],true);
        }
        for(int j=1;j<n;j++){
            for(int i=j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j)){
                    b[i][j]=b[i+1][j-1];
                }else{
                    b[i][j]=false;
                }
            }
        }
        int[] f=new int[n];
        Arrays.fill(f,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            if(b[0][i]){
                f[i]=0;
            }else{

                for(int j=i;j>0;j--){
                    if(b[j][i]){
                        f[i]=Math.min(f[i],f[j-1]+1);
                    }
                }
            }

        }
        return f[n-1];
    }
    public static void main(String[] args) {
        System.out.println(" = " + minCut("aab"));
    }

}