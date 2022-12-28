import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class demo42 {
    //接雨水
    public static int trap(int[] nums){
        if(nums.length<3){
            return 0;
        }
        int ret=0,l=0,r=nums.length-1,h1=0,max1=0,h2=0,max2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max2=max1;
                h2=h1;
                max1=nums[i];
                h1=i;
            }else{
                if(nums[i]>max2){
                    max2=nums[i];
                    h2=i;
                }
            }
        }
        if(max2==0){
            return 0;
        }
        if(h1>h2){
            l=h2;r=h1;
        }else{
            l=h1;r=h2;
        }
        ret=(r-l-1)*Math.min(max1,max2);
        for(int j=l+1;j<r;j++){
            ret-=nums[j];
        }
        System.out.println(";ret = " + ret+";l = " + l+";r = " + r);
        int[] lnums = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).subList(0,l+1)
                .stream().mapToInt(Integer::intValue).toArray();
        int[] rnums = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).subList(r,nums.length)
                .stream().mapToInt(Integer::intValue).toArray();
        return ret+trap(lnums)+trap(rnums);
    }
    public static void main(String[] args) {
        int[] nums=new int[]{8,5,4,1,8,9,3,0,0};
        int i=trap(nums);
        System.out.println("i = " + i);
    }

}
