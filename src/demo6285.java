import java.util.Comparator;
import java.util.Deque;
import java.util.TreeSet;

public class demo6285 {
    //执行 K 次操作后的最大分数
    public static long maxKelements(int[] nums, int k) {
        TreeSet<int[]> ts = new TreeSet<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        for(int i=0;i<nums.length;i++){
            ts.add(new int[]{nums[i],i});
        }
        long ret=0;
        for(int i=0;i<k;i++){
            int q=ts.last()[1];
            int t=ts.pollLast()[0];
            ret+=t;
            t=(int)Math.ceil(((double)t/3));
            ts.add(new int[]{t,q});
        }
        return ret;
    }
    public static void main(String[] args) {
        /*[672579538,806947365,854095676,815137524]
3*/
        System.out.println(" = " + maxKelements(new int[]{672579538,806947365,854095676,815137524},3));
    }

}