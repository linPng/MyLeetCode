public class demo152 {
    //乘积最大子数组
    public static int maxProduct(int[] nums) {
        int ret=nums[0],max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            int t=nums[i];
            int maxt=Math.max(t,Math.max(min*t,max*t));
            int mint=Math.min(t,Math.min(min*t,max*t));
            max=maxt;
            min=mint;
            ret=Math.max(max,ret);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("maxProduct(new int[]{-4,-3,-2}) = " + maxProduct(new int[]{-4,-3,-2}));
    }
}
