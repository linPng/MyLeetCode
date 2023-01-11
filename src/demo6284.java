import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo6284 {
    //使字符串总不同字符的数目相等
    public static boolean isItPossible(String word1, String word2) {
        Map<Character,Integer> m1=new HashMap<>();
        Map<Character,Integer> m2=new HashMap<>();
        for(char e:word1.toCharArray()){
            m1.put(e,m1.getOrDefault(e,0)+1);
        }
        for(char e:word2.toCharArray()){
            m2.put(e,m2.getOrDefault(e,0)+1);
        }
        if(m1.size()==m2.size()){
            Set<Character> b = new HashSet<>(m1.keySet());
            b.removeAll(m2.keySet());
            Set<Character> a = new HashSet<>(m2.keySet());
            a.removeAll(m1.keySet());
            if(a.size()>0&&b.size()>0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(" = " + isItPossible("abcde","fghij"));
    }

}