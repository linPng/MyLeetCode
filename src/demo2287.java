import java.util.HashMap;
import java.util.Map;

public class demo2287 {
    //重排字符形成目标字符串 简单 哈希表
    public static int rearrangeCharacters(String s, String target) {
        int ret = Integer.MAX_VALUE;
        Map<Character,Integer> mapt=new HashMap<>();
        Map<Character,Integer> mapk=new HashMap<>();
        int n=target.length(),j=0;
        for(int i=0;i<target.length();i++){
            mapt.put(target.charAt(i),mapt.getOrDefault(target.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(mapt.keySet().contains(s.charAt(i))){
                mapk.put(s.charAt(i),mapk.getOrDefault(s.charAt(i),0)+1);
            }
        }
        for(char c:mapt.keySet()){
            int i=mapk.getOrDefault(c,0);
            if(i==0){
                return 0;
            }
            int m=i/mapt.getOrDefault(c,0);
            if(m<ret){
                ret=m;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + rearrangeCharacters("abbaccaddaeea","aaaaa"));
    }

}