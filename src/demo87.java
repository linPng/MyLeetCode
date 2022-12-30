import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo87 {
    //扰乱字符串
    //动态规划
    public static boolean isScramble_dp(String s1, String s2) {
        int n=s1.length();
        if(n!=s2.length()){
            return false;
        }
        boolean[][][] dp=new boolean[n][n][n+1];
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j][1]=c1[i]==c2[j];
            }
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                for(int j=0;j<n-len+1;j++){
                    for(int k=1;k<len;k++){
                        boolean f=false;
                        f=(dp[i][j][k]&&dp[i+k][j+k][len-k])||(dp[i][j+len-k][k]&&dp[i+k][j][len-k]);
                        if(f){
                            dp[i][j][len]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
    //递归+剪枝
    static Set<String> set=new HashSet<>();
    public static boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length()==1){
            return false;
        }
        if(set.contains(s1+"#"+s2)||set.contains(s2+"#"+s1)){
            return false;
        }
        set.add(s1+"#"+s2);
        //校验元素是否相同
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map.put(c1[i],map.getOrDefault(c1[i],0)+1);
            map.put(c2[i],map.getOrDefault(c2[i],0)-1);
        }
        for(char c:map.keySet()){
            if(map.get(c)!=0){
                return false;
            }
        }
        for(int k=1;k<s1.length();k++){
            if(isScramble(s1.substring(0,k),s2.substring(0,k))&&isScramble(s1.substring(k),s2.substring(k))){
                return true;
            }
            if(isScramble(s1.substring(0,k),s2.substring(s2.length()-k))&&isScramble(s1.substring(k),s2.substring(0,s2.length()-k))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(" = " + isScramble("great","rgeat"));
        System.out.println(" = " + isScramble("abcde","caebd"));
        System.out.println(" = " + isScramble("ccabcbabcbabbbbcbb","bbbbabccccbbbabcba"));
        System.out.println(" = " + isScramble("eebaacbcbcadaaedceaaacadccd","eadcaacabaddaceacbceaabeccd"));
        System.out.println(" = ");
        System.out.println(" = " + isScramble_dp("great","rgeat"));
        //System.out.println(" = " + isScramble_dp("abcde","caebd"));
        //System.out.println(" = " + isScramble_dp("ccabcbabcbabbbbcbb","bbbbabccccbbbabcba"));
        //System.out.println(" = " + isScramble_dp("eebaacbcbcadaaedceaaacadccd","eadcaacabaddaceacbceaabeccd"));
    }

}
