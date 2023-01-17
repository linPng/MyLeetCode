import java.util.*;

public class demo3 {
    //无重复字符的最长子串
    //双队列滑窗
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> d = new ArrayDeque();
        int ret=0;
        for(char c:s.toCharArray()){
            if(d.contains(c)){
                while(d.pollFirst()!=c){}
            }
            d.addLast(c);
            ret=Math.max(ret,d.size());
        }
        return ret;
    }
    //暴力哈希表
    public int lengthOfLongestSubstringFixme(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int ret=0,t=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                t=0;
                i=map.get(c);
                map=new HashMap<>();
            }else{
                t++;
                map.put(c,i);
                ret=Math.max(ret,t);
            }
        }
        return ret;
    }
    //错误的解法   "dvdf"  return 3   如果遇到重复字符要回退到上一个重复点后重新遍历
    public int lengthOfLongestSubstringError(String s) {
        Set<Character> set = new HashSet<>();
        int ret=0,t=0;
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                t=0;
                set=new HashSet<>();
            }
            t++;
            set.add(c);
            ret=Math.max(ret,t);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
