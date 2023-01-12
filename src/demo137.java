import java.util.Arrays;

public class demo137 {
    //只出现一次的数字 II
    //特殊异或 只有一个出现一次，剩下的都是三次，每位都累加然后除三取余
    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    //常规排序
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]&&nums[i]!=nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }
    public static void main(String[] args) {
        System.out.println(" = " + singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(" = " + singleNumber2(new int[]{0,1,0,1,0,1,99}));
    }

}