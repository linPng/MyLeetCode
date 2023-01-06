import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo1803 {
    //统计异或值在范围内的数对有多少 困难 字典树
    static Trie root = null;
    static final int HIGH_BIT = 14;
    public static int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }
    public static int f(int[] nums, int x) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);//数对的前一位
            res += get(nums[i], x);//数对的后一位 避免重复计算
        }
        return res;
    }
    public static void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (cur.son[bit] == null) {
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum++;
        }
    }
    public static int get(int num, int x) {
        Trie cur = root;
        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int r = (num >> k) & 1;
            if (((x >> k) & 1) != 0) {//x为1表示异或的两个不一样
                if (cur.son[r] != null) {
                    sum += cur.son[r].sum;//如果存在一样的，异或为0，小于x
                }
                if (cur.son[r ^ 1] == null) {//如果没有不一样的就不需要继续判断
                    return sum;
                }
                cur = cur.son[r ^ 1];//有不一样的还要看下一位
            } else {//x为零表示异或的两个数一样，如果不一样就会大于x，
                if (cur.son[r] == null) {//如果没有一样的就没有小于x的，应该返回之前有效的分支+0;
                    return sum;
                }
                cur = cur.son[r];//如果有一样的，需要看下一位
            }
        }
        sum += cur.sum;//每一位都没有被return就是不大于就是等于x，也要加上；
        return sum;
    }
    static class Trie {
        // son[0] 表示左子树，son[1] 表示右子树
        Trie[] son = new Trie[2];
        int sum;

        public Trie() {
            sum = 0;
        }
    }


    //哈希表
    public int countPairs2(int[] nums, int low, int high) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);//添加hash表并计数
        }
        for (++high; high > 0; high >>= 1, low >>= 1) {
            Map<Integer, Integer> nxt = new HashMap<>();
            for (int e : cnt.keySet()) {
                int x = e, c = cnt.get(e);
                ans += c * (high % 2 * cnt.getOrDefault((high - 1) ^ x, 0) -
                        low % 2 * cnt.getOrDefault((low - 1) ^ x, 0));
                nxt.put(x >> 1, nxt.getOrDefault(x >> 1, 0) + c);
            }
            cnt = nxt;
        }
        return ans / 2;
    }
    public static void main(String[] args) {
        System.out.println(" = " + countPairs(new int[]{1,4,2,7},2,6));
    }

}
