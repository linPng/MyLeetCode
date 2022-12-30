import java.util.HashMap;
import java.util.Map;

public class demo76 {
    //最小覆盖子串 滑动窗口下·
    public static String minWindow(String s, String t) {
        String ret="";
        int n=s.length(),r=0,l=0,min=Integer.MAX_VALUE,min_r=0,min_l=0;
        boolean f=false;
        Map mt=new HashMap<>();
        Map ms=new HashMap<>();
        for(char c:t.toCharArray()){
            mt.put(c,(int)mt.getOrDefault(c,0)+1);
        }
        while(r<n){
            char cr=s.charAt(r);
            ms.put(cr,(int)ms.getOrDefault(cr,0)+1);
            f=isEnough(ms,mt);
            while(f){
                if(r-l<min){
                    min=r-l;
                    min_r=r;
                    min_l=l;
                }
                cr=s.charAt(l);
                ms.put(cr,(int)ms.getOrDefault(cr,0)-1);
                l++;
                f=isEnough(ms,mt);
            }
            r++;
        }
        if(min!=Integer.MAX_VALUE){
            ret=s.substring(min_l,min_r+1);
        }
        return ret;
    }
    public static boolean isEnough(Map<Character,Integer> ms,Map<Character,Integer> mt){
        for(Character c:mt.keySet()){
            if(mt.get(c)>ms.getOrDefault(c,0)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(" = " + minWindow("ADOBECODEBANC", "ABC"));
    }

}
