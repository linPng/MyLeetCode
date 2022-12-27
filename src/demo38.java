import java.util.*;

public class demo38 {
    //外观数列
    public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = countAndSay(n-1);
        char[] c=s.toCharArray();
        char ch=' ';
        int t=0;
        String r="";
        for(char e:c){
            if(e==ch){
                t++;
            }else{
                if(ch!=' '){
                    r+=String.valueOf(t)+String.valueOf(ch);
                }
                t=1;
            }
            ch=e;
        }
        r+=String.valueOf(t)+String.valueOf(ch);
        return r;
    }
    public static void main(String[] args) {
        System.out.println("countAndSay(4) = " + countAndSay(4));
    }

}