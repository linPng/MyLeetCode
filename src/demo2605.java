import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class demo2605 {
    //2605. 从两个数字数组里生成最小数字
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set s1=new HashSet();
        for(int i:nums1){
            s1.add(i);
        }
        for(int i :nums2){
            if(s1.contains(i)){
                return i;
            }
        }
        int ret=0;
        if(nums1[0]>nums2[0]){
            ret+=nums2[0]*10+nums1[0];
        }else{
            ret+=nums1[0]*10+nums2[0];
        }
        return ret;
    }
    public static void main(String[] args) {


    }
}
