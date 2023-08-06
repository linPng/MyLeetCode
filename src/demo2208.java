import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class demo2208 {
    //将数组和减半的最少操作次数
    public int halveArray(int[] nums) {
        double sum=0;//Arrays.stream(nums).sum()/2;
        double t=0l;
        /*PriorityQueue<Float> pq = Arrays.stream(nums)
                //.boxed() // 将int转换为Integer
                .mapToObj(Float::valueOf) // 将int转换为Float对象
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.reverseOrder())));
                //.collect(Collectors.toCollection(PriorityQueue::new));*/

        // 使用Comparator.reverseOrder()创建降序比较器
        // 创建Float类型的优先队列，并传入降序比较器
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 将int数组中的元素转换为Float并添加到队列中
        for (int num : nums) {
            // 使用自动装箱将int转换为Float
            pq.add((double)num);
            sum+=num;
        }
        int ret=0;
        while(t<sum/2){
            double i=pq.poll()/2;
            t+=i;
            pq.offer(i);
            ret++;
        }
        return ret;
    }
    public static void main(String[] args) {
        demo2208 d = new demo2208();
        System.out.println("d.halveArray(new int[]{1,2,3}) = " + d.halveArray(new int[]{5814172,4555668,9013971,8013658,5830886}));
    }
}
