package planning.BasicDataStructures.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backtracking01_22_GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        if(n==1){
            List<String> ret = new ArrayList<>();
            ret.add("()");
            return ret;
        }
        List<String> pre=generateParenthesis(n-1);
        Set<String> set=new HashSet<>();
        for(String s:pre){
            for(int i=0;i<=s.length();i++){
                set.add(s.substring(0,i)+"()"+s.substring(i));
            }
        }
        List<String> ret = new ArrayList<>(set);
        return ret;
    }


}
