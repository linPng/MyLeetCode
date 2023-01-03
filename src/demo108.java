import java.util.*;

public class demo108 {
    //将有序数组转换为二叉搜索树
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        int n=nums.length;
        int m=n/2;
        int[] lnum=new int[m],rnum=new int[n-m-1];
        for(int i=0;i<m;i++){
            lnum[i]=nums[i];
        }
        for(int i=n-1;i>m;i--){
            rnum[i-m-1]=nums[i];
        }
        return new TreeNode(nums[m],sortedArrayToBST(lnum),sortedArrayToBST(rnum));
    }
    public static void main(String[] args) {

    }

}