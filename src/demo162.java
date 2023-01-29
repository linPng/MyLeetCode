public class demo162 {
    //寻找峰值    二分法    或者找最大值     你可以假设 nums[-1] = nums[n] = -∞
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int m=(l+r)/2;
            if(nums[m]<nums[m+1]){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }
    public static void main(String[] args) {

    }
}
