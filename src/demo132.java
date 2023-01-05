import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo132 {
    //分割回文串 II  动态规划预处理+回溯
    static int min=Integer.MAX_VALUE;
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
        f(s,0,l,b);
        return min;
    }
    public static void f(String s, int i,List<String> l,boolean[][] b){
        int n=s.length();
        if(i==n){
            min=Math.min(min,l.size()-1);
            return;
        }
        for(int y=i;y<n;y++){
            if(b[i][y]){
                l.add(s.substring(i,y+1));
                f(s,y+1,l,b);
                l.remove(l.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(" = " + minCut("aab"));
    }

}