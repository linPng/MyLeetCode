package planning.BasicDataStructures.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class Backtracking13_753_CrackingTheSafe {

    StringBuilder sb = new StringBuilder();
    Set<Integer> seen = new HashSet<Integer>();
    int highest;
    int m;
    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        m=k;
        dfs(0);
        for(int i=1;i<n;i++){
            sb.append('0');
        }
        return sb.toString();
    }
    public void dfs(int i){
        System.out.println("i = " + i);
        System.out.println("seen = " + seen);
        for(int a=0;a<m;a++){
            int b=i*10+a;
            if(!seen.contains(b)){
                seen.add(b);
                dfs(b%highest);
                sb.append(a);
            }
            System.out.println("a = " + a);
        }
    }

    public static void main(String[] args) {
        Backtracking13_753_CrackingTheSafe b = new Backtracking13_753_CrackingTheSafe();
        System.out.println("b.crackSafe(1,2) = " + b.crackSafe(1,2));
    }
}
