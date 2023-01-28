import java.util.Arrays;

public class demo1663 {
    //具有给定数值的最小字符串
    public String getSmallestString(int n, int k) {
        char[] c=new char[n];
        Arrays.fill(c,'a');//数组填充
        int i=n-1,t=n;
        while(k>t){
            int e=k-t>25?25:k-t;
            c[i]+=e;
            t+=e;
            i--;
        }
        return String.valueOf(c);
    }
    public static void main(String[] args) {

    }
}