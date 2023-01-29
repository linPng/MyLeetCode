import java.util.Arrays;

public class demo164 {
    //最大间距 基数排序
    public int maximumGap2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;//位数
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {//按位分组
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {//按位排序0<1<2... 所以序号累加
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {//大到小放入buf缓存
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);//buf缓存写入num完成一轮排序
            exp *= 10;//进位
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
    //sort 不合题意 题目要求线性时间复杂度 sort是logn*n;
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);  //https://zhuanlan.zhihu.com/p/37510564 插入排序》快速排序》归并排序
        int ret=0;
        for(int i=1;i<nums.length;i++){
            ret=Math.max(ret,nums[i]-nums[i-1]);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
