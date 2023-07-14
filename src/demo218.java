import java.util.*;

public class demo218 {
    //天际线问题

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret=new ArrayList<>();
        List<int[]> scan=new ArrayList<>();
        for(int[] i:buildings){
            int[] t1={i[0],i[2]};
            int[] t2={i[1],-i[2]};
            scan.add(t1);
            scan.add(t2);
        }
        // 使用Comparator接口实现自定义排序规则
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                // 按照第一个元素进行升序排序
                if(arr1[0]==arr2[0]){//如果横坐标一样，优先计算高的左边界（右边界为负数，从大到小排序）
                    return Integer.compare(arr2[1], arr1[1]);
                }
                return Integer.compare(arr1[0], arr2[0]);
            }
        };
        scan.sort(comparator);
        //高度优先队列
        PriorityQueue<Integer> high = new PriorityQueue<Integer>((a, b) -> b - a);
        high.offer(0);
        for(int[] i:scan){
            int h=high.peek();
            if(i[1]>0){
                high.offer(i[1]);
            }else{
                high.remove(-i[1]);
            }
            if(h!=high.peek()){
                Integer[] array = {i[0], high.peek()};
                ret.add(Arrays.asList(array));
            }
        }

        return ret;
    }
    public static void main(String[] args) {

    }
}