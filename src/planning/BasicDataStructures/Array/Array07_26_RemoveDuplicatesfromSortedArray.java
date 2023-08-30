package planning.BasicDataStructures.Array;

/**
 * @autthor LinP
 * @create 2023-08-25 11:10
 */
public class Array07_26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int j=0;
        int t1=Integer.MIN_VALUE;
        int t2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(t1<nums[i]||t2<nums[i]){
                nums[j]=nums[i];
                t2=t1;
                t1=nums[j];
                j++;
            }
        }
        return j;
    }
}
