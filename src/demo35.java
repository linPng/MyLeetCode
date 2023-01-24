public class demo35 {
    //搜索插入位置 简单
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int m=(l+r)/2;
        while(l<=r){
            m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                r=m-1;
            }else{
                l=m+1;
                m=l;
            }
        }
        return m;
    }
    public static void main(String[] args) {

    }
}