package planning.BasicDataStructures.Array;

/**
 * @autthor LinP
 * @create 2023-08-25 11:10
 */
public class Array08_80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int j=0;
        int t=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(t<nums[i]){
                nums[j]=nums[i];
                t=nums[j];
                j++;
            }
        }
        return j;
    }
}
