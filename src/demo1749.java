public class demo1749 {
    //任意子数组和的绝对值的最大值
    //经典
    public int maxAbsoluteSum(int[] nums) {
        int positiveMax = 0, negativeMin = 0;
        int positiveSum = 0, negativeSum = 0;
        for (int num : nums) {
            positiveSum += num;
            positiveMax = Math.max(positiveMax, positiveSum);
            positiveSum = Math.max(0, positiveSum);//不考虑之前的负数，如果和小于0，就清零
            negativeSum += num;
            negativeMin = Math.min(negativeMin, negativeSum);
            negativeSum = Math.min(0, negativeSum);//不考虑之前的正数
        }
        return Math.max(positiveMax, -negativeMin);
    }
    public static void main(String[] args) {

    }
}
