import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo217 {
    //存在重复元素

    public boolean containsDuplicate(int[] nums) {
        boolean ret = false;
        Set s = new HashSet<>();
        for(int i:nums){
            if(s.contains(i)){
                return true;
            }else{
                s.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}