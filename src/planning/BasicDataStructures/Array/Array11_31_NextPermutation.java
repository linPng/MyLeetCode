package planning.BasicDataStructures.Array;

import java.util.Arrays;

public class Array11_31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        int n=nums.length;
        while(i>0){
            if(nums[i]>nums[i-1]){
                int t=i-1;
                Arrays.sort(nums,i,n);
                while(i<n){
                    if(nums[i]>nums[t]){
                        break;
                    }
                    i++;
                }
                int temp=nums[i];
                nums[i]=nums[t];
                nums[t]=temp;
                return;
            }
            i--;
        }
        Arrays.sort(nums);
    }



}
