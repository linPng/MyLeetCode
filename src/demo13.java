import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class demo13 {
    //罗马数字转整数
    public int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
    //模拟 暴力
    public int romanToInt2(String s) {
        int r=0;
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='M'){
                if((i-1)>=0&&c[i-1]=='C'){
                    r+=900;
                }else{
                    r+=1000;
                }
            }
            else if(c[i]=='D'){
                if((i-1)>=0&&c[i-1]=='C'){
                    r+=400;
                }else{
                    r+=500;
                }
            }
            else if(c[i]=='C'){
                if((i-1)>=0&&c[i-1]=='X'){
                    r+=90;
                }else if((i+1)<c.length&&(c[i+1]=='D'||c[i+1]=='M')){
                }else{
                    r+=100;
                }
            }
            else if(c[i]=='L'){
                if((i-1)>=0&&c[i-1]=='X'){
                    r+=40;
                }else{
                    r+=50;
                }
            }
            else if(c[i]=='X'){
                if((i-1)>=0&&c[i-1]=='I'){
                    r+=9;
                }else if((i+1)<c.length&&(c[i+1]=='C'||c[i+1]=='L')){
                }else{
                    r+=10;
                }
            }
            else if(c[i]=='V'){
                if((i-1)>=0&&c[i-1]=='I'){
                    r+=4;
                }else{
                    r+=5;
                }
            }
            else if(c[i]=='I'){
                if((i+1)<c.length&&(c[i+1]=='X'||c[i+1]=='V')){
                }else{
                    r+=1;
                }
            }
        }
        return r;
    }
    public static void main(String[] args) {

    }
}