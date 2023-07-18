public class demo283 {
    //移动零
    public void moveZeroes(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++;
            }else{
                nums[i-c]=nums[i];
            }
        }
        for(int i=nums.length-c;i<nums.length;i++){
            nums[i]=0;
        }
    }
    public static void main(String[] args) {

    }
}
