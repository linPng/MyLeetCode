import java.util.HashSet;
import java.util.Set;

public class demo260 {
    //只出现一次的数字 III
    public int[] singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {

    }
}