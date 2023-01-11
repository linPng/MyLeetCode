import java.util.Arrays;

public class demo1658 {
    //将 x 减到 0 的最小操作数   双指针 两边和都是单调加减
    public static int minOperations(int[] nums, int x) {
        int ret =Integer.MAX_VALUE;
        int l=-1,r=0,n=nums.length,lsum=0;
        int rsum= Arrays.stream(nums).sum();
        if(rsum<x){
            return -1;
        }
        for(;l<n;l++){
            if(l!=-1){
                lsum+=nums[l];
            }
            if(lsum>x){
                break;
            }
            while(r<n&&rsum+lsum>x){
                rsum-=nums[r];
                r++;
            }
            if(rsum+lsum==x){
                if(l+1+n-r<ret){
                    ret=l+1+n-r;
                }
            }

        }
        return ret > n ? -1 : ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + minOperations(new int[]{1,1,4,2,3},5));
    }

}