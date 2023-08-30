package planning.BasicDataStructures.Array;

/**
 * @autthor LinP
 * @create 2023-08-24 11:10
 */
public class Array05_283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int t=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[t]=nums[i];
                t++;
            }
        }
        while(t<n){
            nums[t]=0;
            t++;
        }
    }
}
