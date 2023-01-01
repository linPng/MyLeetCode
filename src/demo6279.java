import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo6279 {
    //数组乘积中的不同质因数数目
    public static int distinctPrimeFactors(int[] nums) {
        Set<String> set2=new HashSet<>();
        Set<String> set=new HashSet<>();
        for(int i:nums){
            int t=2;
            while (t <= i) {
                if (t == i) {
                    set.add(String.valueOf(t));
                    break;
                } else if (i % t == 0) {
                    set.add(String.valueOf(t));
                    i = i / t;
                } else {
                    t++;
                }

            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(" = " + distinctPrimeFactors(new int[]{2,4,3,7,10,6}));
    }

}