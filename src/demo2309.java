import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class demo2309 {
    //兼具大小写的最好英文字母 简单
    public static String greatestLetter(String s) {
        String ret="";
        Set<Character> set = new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
            if(set.contains((char)(c+32))){
                if(ret.length()==0||ret.charAt(0)<(char)(c)){
                    ret=String.valueOf((char)(c));
                }
            }else if(set.contains((char)(c-32))){
                if(ret.length()==0||ret.charAt(0)<(char)(c-32)){
                    ret=String.valueOf((char)(c-32));
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
    }
}