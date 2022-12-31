public class demo33 {
    //搜索旋转排序数组
    public static int search(int[] nums, int target){
        int n=nums.length,l=0,r=n-1,m=(l+r)/2;
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target){
                return m;
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
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(" = " + search(new int[]{4,5,6,7,0,1,2},0));
    }

}