public class demo209 {
    //长度最小的子数组
    //双指针 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int l=-1,r=-1,sum=0,ret=Integer.MAX_VALUE;
        while(true){
            if(sum<target){
                r++;
                if(r==nums.length){
                    break;
                }
                sum+=nums[r];
            }else{
                ret=Math.min(ret,r-l);
                l++;
                sum-=nums[l];
            }
        }
        if(ret==Integer.MAX_VALUE){
            ret=0;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
