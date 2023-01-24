public class demo45 {
    //跳跃游戏 II 中等 贪心
    public int jump(int[] nums) {
        int e=0,r=0,m=0;
        for(int i=0;i<nums.length-1;i++){
            m=Math.max(m,i+nums[i]);
            if(i==e){
                e=m;
                m=0;
                r++;
            }
        }
        return r;
    }
    public static void main(String[] args) {

    }
}