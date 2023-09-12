package planning.BasicDataStructures.Array;

public class Array16_42_TrappingRainWater {

    public int trap(int[] height) {
        int ret=0;
        int n=height.length;
        int[] dp=new int[n];
        int m=0;
        for(int i=0;i<n;i++){
            dp[i]=m;
            m=Math.max(m,height[i]);
        }
        m=0;
        for(int i=n-1;i>=0;i--){
            ret+=Math.max(Math.min(dp[i],m)-height[i],0);
            m=Math.max(m,height[i]);
        }
        return ret;
    }



}
