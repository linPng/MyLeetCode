public class demo81 {
    //搜索旋转排序数组 II
    public static boolean search(int[] nums, int target){
        int n=nums.length,l=0,r=n-1,m=(l+r)/2;
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target){
                return true;
            }else if (nums[l] == nums[m] && nums[m] == nums[r]) {
                ++l;
                --r;
            }else if(nums[l]<=nums[m]){
                if(nums[l]<=target&&target<=nums[m]){
                    r=m-1;
                }else{
                    l=m+1;
                    m=l;
                }
            }else{
                if(nums[m]<=target&&target<=nums[r]){
                    l=m+1;
                    m=l;
                }else{
                    r=m-1;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(" = " + search(new int[]{0,1,3,0,0,0,0,0,0,0,0,0,0,0,0},1));
    }

}