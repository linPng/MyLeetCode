public class demo55 {
    //跳跃游戏
    public static boolean canJump(int[] nums) {
        int max=0,n=nums.length-1;
        for(int i=0;i<=n;i++){
            if(i>max){
                return false;
            }
            max=Math.max(max,i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(" = " + canJump(new int[]{3,2,1,0,4}));
        System.out.println(" = " + canJump(new int[]{2,3,1,1,4}));
    }

}