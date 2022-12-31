public class demo80 {
    //删除有序数组中的重复项 II
    public static int removeDuplicates(int[] nums) {
        int remove=0,count=0,t=Integer.MIN_VALUE,c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>t){
                c=1;t=nums[i];
                count++;
            }else if(c<2){
                c++;
                count++;
            }else{
                remove++;
            }
            nums[i-remove]=nums[i];
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(" = " + removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

}