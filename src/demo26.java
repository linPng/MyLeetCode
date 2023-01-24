public class demo26 {
    //删除有序数组中的重复项 简单
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int r=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){

            }else{
                nums[r]=nums[i];
                r++;
            }
        }
        return r;
    }
    public static void main(String[] args) {

    }
}