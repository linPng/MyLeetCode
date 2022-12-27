import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class demo42 {
    //接雨水
    public static int trap(int[] nums){
        if(nums.length<3){
            return 0;
        }
        int ret=0,l=0,r=nums.length-1,h=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){

            }
        }
        int[] lnums = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).subList(0,l+1)
                .stream().mapToInt(Integer::intValue).toArray();
        int[] rnums = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).subList(r,nums.length)
                .stream().mapToInt(Integer::intValue).toArray();
        return ret+trap(lnums)+trap(rnums);
    }
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap(nums);
    }

}
