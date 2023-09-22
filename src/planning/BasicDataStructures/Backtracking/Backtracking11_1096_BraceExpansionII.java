package planning.BasicDataStructures.Backtracking;

import java.util.*;

public class Backtracking11_1096_BraceExpansionII {
    Set<String> set = new TreeSet<>();
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }
    public void dfs(String s){
        int j=s.indexOf("}");
        if(j==-1){
            for(String a:s.split(",")){
                set.add(a);
            }
            return;
        }
        int i=j;
        while(!(s.charAt(i)=='{')){
            i--;
        }
        String a=s.substring(0,i);
        String c=s.substring(j+1);
        String d=s.substring(i+1,j);
        for(String b:d.split(",")){
            dfs(a+b+c);
        }
    }
}
