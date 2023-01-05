import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo131 {
    //分割回文串  动态规划预处理+回溯
    public static List<List<String>> partition(String s) {
        List<List<String>> ret=new ArrayList<>();
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
        f(s,0,ret,l,b);
        return ret;
    }
    public static void f(String s, int i,List<List<String>> ret,List<String> l,boolean[][] b){
        int n=s.length();
        if(i==n){
            ret.add(new ArrayList<>(l));
            return;
        }
        for(int y=i;y<n;y++){
            if(b[i][y]){
                l.add(s.substring(i,y+1));
                f(s,y+1,ret,l,b);
                l.remove(l.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(" = " + partition("aab"));
    }

}