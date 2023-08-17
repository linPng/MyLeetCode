package contest.weeklycontest90;

import java.util.HashSet;
import java.util.Set;

public class A {
    //859. 亲密字符串
    //不太聪明的模拟
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        Set set = new HashSet();
        Set sets = new HashSet();
        char c1=' ';
        char c2=' ';
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=goal.charAt(i);
            sets.add(a);
            if (a==b){
                continue;
            }else{
                if(c1==' '){
                    c1=a;
                }else if(c2==' '){
                    c2=a;
                }else{
                    return false;
                }
                set.add(a);
                set.add(b);
            }
            if(set.size()>2){
                return false;
            }
        }
        if(set.size()==2){
            if(c1==c2){
                return false;
            }
            if (c1!=' '&&c2!=' ') {
                return true;
            }
        }
        if(s.equals(goal)){
            if(sets.size()<s.length()){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
