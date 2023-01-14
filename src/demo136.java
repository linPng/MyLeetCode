import java.util.Arrays;

public class demo136 {
    //只出现一次的数字
    //特殊异或 只有一个出现一次，剩下的都是两次，相同的异或为0
    public static int singleNumber2(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[0]^=nums[i];
        }
        return nums[0];
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
        System.out.println(" = " + singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(" = " + singleNumber2(new int[]{4,1,2,1,2}));
    }

}