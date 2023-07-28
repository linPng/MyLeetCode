import java.util.Arrays;

public class demo918 {
    //环形子数组的最大和
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ret =nums[0];
        int max =nums[0];
        int min =nums[0];
        int sum = Arrays.stream(nums).sum();
        int p=Integer.MIN_VALUE/2;
        for(int i:nums){
            p=Math.max(i,p+i);
            max=Math.max(max,p);
        }
        p=Integer.MAX_VALUE/2;
        for(int i:nums){
            p=Math.min(i,p+i);
            min=Math.min(min,p);
        }
        if((sum-min)<=0){
            return max;
        }
        ret=Math.max(max,sum-min);
        return ret;
    }
    public static void main(String[] args) {

    }
}
