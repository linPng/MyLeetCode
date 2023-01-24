public class demo27 {
    //移除元素 简单 枚举
    public int removeElement(int[] nums, int val) {
        int r=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){

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