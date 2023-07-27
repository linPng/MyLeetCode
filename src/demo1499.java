import java.util.ArrayDeque;
import java.util.Deque;

public class demo1499 {
    //满足不等式的最大值
    //双端单调队列
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int[] point : points) {//x已经是升序的，直接小到大遍历，
            int x = point[0], y = point[1];
            while (!queue.isEmpty() && x - queue.peekFirst()[1] > k) {//延迟删除，排除x小于i-k的无效数组
                queue.pollFirst();
            }
            if (!queue.isEmpty()) {
                res = Math.max(res, x + y + queue.peekFirst()[0]);
            }
            while (!queue.isEmpty() && y - x >= queue.peekLast()[0]) {//
                queue.pollLast();
            }
            queue.offer(new int[]{y - x, x});
        }
        return res;
    }
    public static void main(String[] args) {

    }
}