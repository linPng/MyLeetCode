package contest.weeklycontest83;

public class C {
    //连续整数求和
    /*
    * 等差求和 x为最小项
    * x=n/k-(k-1)/2 如果后项是整数（k是奇数）则前项也要是整数，如果后项余1（k是偶数）则前项要余0.5((2n+k)%2k==0)
    * */
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        int bound = 2 * n;//为什么是2n?n>k(k+1)/2
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isKConsecutive(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isKConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            //return (2*n+k)%(2*k)==0;
            return n % k != 0 && 2 * n % k == 0;
        }
    }
    public static void main(String[] args) {

    }
}
