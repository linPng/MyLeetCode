import java.util.Arrays;

public class demo31 {
    //下一个排列
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                Arrays.sort(nums,i,n);
                for(int j=i;j<n;j++){
                    if(nums[i-1]<nums[j]){
                        int t=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=t;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
    public static void main(String[] args) {

    }
}