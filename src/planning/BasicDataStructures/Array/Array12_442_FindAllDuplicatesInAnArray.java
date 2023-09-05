package planning.BasicDataStructures.Array;

import java.util.ArrayList;
import java.util.List;

public class Array12_442_FindAllDuplicatesInAnArray {


    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n=nums.length;
        int[] set= new int[n+1];
        for(int i:nums){
            if(set[i]<1){
                set[i]=1;
            }else if(set[i]==1){
                ret.add(i);
            }
        }
        return ret;
    }



}
