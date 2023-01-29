public class demo154 {
    //寻找旋转排序数组中的最小值 II
    public int findMin(int[] nums) {
        int ret=nums[0],l=0,r=nums.length-1;
        while (l<r){
            int m=(l+r)/2;
            ret=Math.min(ret,Math.min(nums[m],Math.min(nums[l],nums[r])));
            if(nums[m]==nums[l]){
                l=l+1;
            }else if(nums[m]>nums[l]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ret;
    }
    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m=(l+r)/2;
            if (nums[m] == nums[r]) {
                l = l + 1;
            }else if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
    public static void main(String[] args) {

    }
}
