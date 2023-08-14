package contest.weeklycontest87;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class A {
    //844. 比较含退格的字符串
    public boolean backspaceCompare(String s, String t) {
        if(getRow(s).equals(getRow(t))){
            return true;
        }
        return false;
    }
    public String getRow(String s){
        Deque<Character> d1=new ArrayDeque();
        for(char c:s.toCharArray()){
            if(c!='#'){
                d1.addLast(c);
            }else if(d1.size()>0){
                d1.removeLast();
            }
        }
        return d1.stream().map(Object::toString).collect(Collectors.joining());
    }
    public static void main(String[] args) {

    }
}
