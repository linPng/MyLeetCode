//import java.util.Arrays;
//
//public class demo214 {
//    //最短回文串 困难
//    //暴力法
//    public String shortestPalindrome2(String s) {
//        String rev=new StringBuffer(s).reverse().toString();
//        String ret="";
//        for(int i=s.length();i>0;i--){
//            if(s.substring(0,i).equals(rev.substring(s.length()-i))){
//                ret=rev.substring(0,s.length()-i)+s;
//                break;
//            }
//        }
//        return ret;
//    }
//    //KMP
//    public String shortestPalindrome(String s){
//  const rev_s = s.split('').reverse().join('');
//  const str = s + "#" + rev_s;
//  const next = new Array(str.length).fill(0);
//        // 抽出来，方便学习记忆，这是我写的模板
//
//        kmp(next, str);
//  const maxLen = next[str.length - 1]; // 最长回文前缀的长度
//  const add = s.substring(maxLen).split('').reverse().join('');
//        return add + s;
//    }
//    const kmp = (next, str) => {
//        next[0] = 0;
//        let len = 0;
//        let i = 1;
//        while (i < str.length) {
//            if (str[i] == str[len]) {
//                len++;
//                next[i] = len;
//                i++;
//            } else {
//                if (len == 0) {
//                    next[i] = 0;
//                    i++;
//                } else {
//                    len = next[len - 1];
//                }
//            }
//        }
//    }
//    //KMP 官方
//    public String shortestPalindrome(String s) {
//        int n = s.length();
//        int[] fail = new int[n];
//        Arrays.fill(fail, -1);
//        for (int i = 1; i < n; ++i) {
//            int j = fail[i - 1];
//            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
//                j = fail[j];
//            }
//            if (s.charAt(j + 1) == s.charAt(i)) {
//                fail[i] = j + 1;
//            }
//        }
//        int best = -1;
//        for (int i = n - 1; i >= 0; --i) {
//            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
//                best = fail[best];
//            }
//            if (s.charAt(best + 1) == s.charAt(i)) {
//                ++best;
//            }
//        }
//        String add = (best == n - 1 ? "" : s.substring(best + 1));
//        StringBuffer ans = new StringBuffer(add).reverse();
//        ans.append(s);
//        return ans.toString();
//    }
//    public static void main(String[] args) {
//
//    }
//}
