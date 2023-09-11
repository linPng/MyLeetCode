package planning.BasicDataStructures.Array;

import java.util.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

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
    public void nextPermutation2(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){//找到可以小换大的点i-1
                Arrays.sort(nums,i,n);
                for(int j=i;j<n;j++){
                    if(nums[i-1]<nums[j]){//找到比i-1大一级的数
                        int t=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=t;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);//分类讨论
    }


}
