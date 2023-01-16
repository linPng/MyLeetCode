public class demo2293 {
    //极大极小游戏
    public static int minMaxGame(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] newnums=new int[nums.length/2];
        for(int i=0;i<newnums.length;i++){
            if(i%2==0){
                newnums[i]=Math.min(nums[2*i],nums[2*i+1]);
            }else{
                newnums[i]=Math.max(nums[2*i],nums[2*i+1]);
            }
        }
        return minMaxGame(newnums);
    }
    public static void main(String[] args) {
        System.out.println(" = " + minMaxGame(new int[]{1,3,5,2,4,8,2,2}));
    }

}