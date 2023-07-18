import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class demo299 {
    //猜数字游戏
    public String getHint(String secret, String guess) {
        int a=0,b=0;
        char[] s=secret.toCharArray();
        char[] g=guess.toCharArray();
        for(int i=0;i<secret.length();i++){
            if(s[i]==g[i]){
                a++;
            }
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int ia=s.length-1,ib=s.length-1;
        while(ia>0&&ib>0){
            if(s[ia]==g[ib]){
                ia--;ib--;b++;
            }else if(s[ia]>g[ib]){
                ia--;
            }else{
                ib--;
            }
        }
        b=b-a;
        return a+"A"+b+"B";
    }
    public static void main(String[] args) {

    }
}
