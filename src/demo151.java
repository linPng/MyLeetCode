import java.util.ArrayDeque;
import java.util.Deque;

public class demo151 {
    //反转字符串中的单词
    public static String reverseWords(String s) {
        StringBuilder ret=new StringBuilder();
        Deque<String> d= new ArrayDeque<>();
        for(String e:s.split(" ")){
            d.addLast(e);
        }
        while (d.size()>0){
            String t=d.pollLast();
            if(t.equals("")){
                continue;
            }
            if(ret.length()>0){
                ret.append(" ");
            }
            ret.append(t);
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        System.out.println("reverseWords = " + reverseWords("  hello world  "));
    }
}
