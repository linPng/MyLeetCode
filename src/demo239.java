import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class demo239 {
    //滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //大顶堆  value key
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {//只操作k次
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {//弹出窗口左边的无效数，如果无效数不在堆顶就不管
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    //更优解  单调队列 大到小
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {//把小的队尾去掉，保证单调
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {//校验是否已经离开窗口
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    //大顶堆 超时 remove效率低
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n=nums.length-k+1;
        int[] ret=new int[n];
        //优先队列 大顶堆
        PriorityQueue<Integer> big = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int i=0;i<nums.length;i++){
            big.offer(nums[i]);
            if(big.size()>k){
                big.remove(nums[i-k]);
            }
            if(big.size()==k){
                ret[i-k+1]=big.peek();
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}