import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

public class demo300 {
    //最长递增子序列
    //经典动态规划
    public int lengthOfLIS(int[] nums) {
        int ret=1,n=nums.length;
        int[] dp=new int[n];//表示以第n个数为结尾的子序列长度
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if (nums[j]<nums[i]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
