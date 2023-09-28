import java.util.*;
import java.util.stream.IntStream;

public class demo2251 {
    //2251. 花期内花的数目
    //差分+离线
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();//有序
        for (int[] flower : flowers) {
            cnt.put(flower[0], cnt.getOrDefault(flower[0], 0) + 1);
            cnt.put(flower[1] + 1, cnt.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int m = persons.length;
        Integer[] indices = IntStream.range(0, m).boxed().toArray(Integer[]::new);//persons的索引
        Arrays.sort(indices, (i, j) -> persons[i] - persons[j]);//persons的索引按小到大排序
        int[] ans = new int[m];
        int curr = 0;
        for (int x : indices) {
            while (!cnt.isEmpty() && cnt.firstKey() <= persons[x]) {
                curr += cnt.pollFirstEntry().getValue();
            }
            ans[x] = curr;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
