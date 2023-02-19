import java.util.Arrays;

public class demo213 {
    //打家劫舍 II 中等
    //动态规划 边界判断
    //动态规划 滚动数组 边界判断:开始和结束不能同时选择
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] copy = new int[nums.length-1];
        System.arraycopy(nums, 1, copy, 0,nums.length-1);
        return Math.max(rob1(Arrays.copyOf(nums,nums.length-1)),rob1(copy));
    }
    public int rob1(int[] nums) {
        int dp0=0;
        int dp1=nums[0];
        for(int i=1;i<nums.length;i++){
            int dp2=Math.max(dp0+nums[i],dp1);
            dp0=dp1;
            dp1=dp2;
        }
        return dp1;
    }
    public static void main(String[] args) {

    }
}
