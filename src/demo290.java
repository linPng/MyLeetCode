import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo290 {
    //单词规律
    public boolean wordPattern(String pattern, String s) {
        String[] ss=s.split(" ");
        char[] c=pattern.toCharArray();
        if(ss.length!=pattern.length()){
            return false;
        }
        Map m=new HashMap();
        Set set=new HashSet();
        for(int i=0;i<ss.length;i++){
            if(m.containsKey(c[i])){
                if(!ss[i].equals(m.get(c[i]))){
                    return false;
                }
            }else{
                if(!set.contains(ss[i])){
                    m.put(c[i],ss[i]);
                    set.add(ss[i]);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
