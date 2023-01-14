import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo139 {
    //单词拆分 动态规划 n*n

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp= new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //暴力回溯超时 n的n次方
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if(dfs(s,set)){
            return true;
        }
        return false;
    }
    public static boolean dfs(String s,Set set){
        if(s.length()==0){
            return true;
        }
        for(int i=0;i<=s.length();i++){
            if(set.contains(s.substring(0,i))){
                if(dfs(s.substring(i),set)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(" = " + wordBreak("leetcode",list));
        List<String> wordDict = new ArrayList<>();
        String s="";
        for(int i=1;i<11;i++){
            s+="a";
            wordDict.add(s);
        }
        System.out.println(" = " + wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",wordDict));
    }

}