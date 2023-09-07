public class demo2594 {
    //2594. �޳�������ʱ��
    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = 1L * ranks[0] * cars * cars;
        while (l < r) {
            long m = l + r >> 1;
            if (check(ranks, cars, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public boolean check(int[] ranks, int cars, long m) {
        long cnt = 0;
        for (int x : ranks) {
            cnt += (long) Math.sqrt(m / x);
        }
        return cnt >= cars;
    }
    public static void main(String[] args) {

    }
}
