import java.util.*;

public class demo22 {
    //括号生成 中等 插空
    public List<String> generateParenthesis(int n) {
        if(n==1){
            return Arrays.asList("()");
        }
        if(n==2){
            return Arrays.asList("(())","()()");
        }
        if(n==3){
            return Arrays.asList("((()))","(()())","(())()","()(())","()()()");
        }
        List<String> ls = generateParenthesis(n-1);
        Set<String> set=new HashSet<String>();
        for(String s:ls){
            for(int i=0;i<=s.length();i++){
                set.add(s.substring(0,i)+"()"+s.substring(i,s.length()));
            }
        }
        return new ArrayList<String>(set);
    }
    public static void main(String[] args) {

    }
}