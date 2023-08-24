package planning.BasicDataStructures.Array;

/**
 * @autthor LinP
 * @create 2023-08-18 11:10
 */
public class Array01_189_RotateArray {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] ret=new int[n];
        for(int i=0;i<n;i++){
            ret[(i+k)%n]=nums[i];
        }
        System.arraycopy(ret,0,nums,0,n);
    }
}
