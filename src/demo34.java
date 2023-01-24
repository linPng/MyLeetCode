public class demo34 {
    //在排序数组中查找元素的第一个和最后一个位置 二分
    public int[] searchRange(int[] nums, int target) {
        int[] ret=new int[2];
        ret[0]=-1;
        ret[1]=-1;
        int n=nums.length,l=0,r=n-1,m=(l+r)/2;
        while(r>=l){
            m=(l+r)/2;
            if(nums[m]==target){
                int a=m,b=m;
                while(a-1>=0&&nums[a-1]==target){
                    a--;
                }
                while(b+1<n&&nums[b+1]==target){
                    b++;
                }
                ret[0]=a;
                ret[1]=b;
                break;
            }else if(nums[m]>target){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}