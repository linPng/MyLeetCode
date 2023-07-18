import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo282 {
    //给表达式添加运算符
    //回溯
    List<String> ans = new ArrayList<>();
    String s;
    int n, t;
    public List<String> addOperators(String num, int target) {
        s = num;
        n = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return ans;
    }
    //u字符串索引  prev前一个数  cur当前和 ss前缀
    void dfs(int u, long prev, long cur, String ss) {
        if (u == n) {//结束
            if (cur == t){//满足条件
                ans.add(ss);
            }
            return ;
        }
        for (int i = u; i < n; i++) {
            if (i != u && s.charAt(u) == '0'){//避免0开头的数字
                break;
            }
            long next = Long.parseLong(s.substring(u, i + 1));
            if (u == 0) {
                dfs(i + 1, next, next, "" + next);
            } else {
                dfs(i + 1,  next, cur + next, ss + "+" + next);
                dfs(i + 1, -next, cur - next, ss + "-" + next);
                long x = prev * next;
                dfs(i + 1, x, cur - prev + x, ss + "*" + next);
            }
        }
    }
    public static void main(String[] args) {

    }
}
