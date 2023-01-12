import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo140 {
    //单词拆分 II
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String>[] dp= new ArrayList[s.length()+1];
        dp[0]=new ArrayList<>();
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]!=null&&set.contains(s.substring(j,i))){
                    if(dp[i]==null){
                        dp[i]=new ArrayList<>();
                    }
                    if(dp[j].size()==0){
                        dp[i].add(s.substring(j,i));
                    }else{
                        for(String e:dp[j]){
                            dp[i].add(e+" "+s.substring(j,i));
                        }
                    }

                }
            }
        }
        if(dp[s.length()]==null){
            dp[s.length()]=new ArrayList<>();
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(" = " + wordBreak("catsanddog",list));
        List<String> wordDict = new ArrayList<>();
        String s="";
        for(int i=1;i<11;i++){
            s+="a";
            wordDict.add(s);
        }
        //超时
        System.out.println(" = " + wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",wordDict));
    }

}