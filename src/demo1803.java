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
            if (((x >> k) & 1) != 0) {//x为1表示，这以为的两个数必须不一样
                if (cur.son[r] != null) {//
                    sum += cur.son[r].sum;
                }
                if (cur.son[r ^ 1] == null) {
                    return sum;
                }
                cur = cur.son[r ^ 1];
            } else {//x为零表示，
                if (cur.son[r] == null) {
                    return sum;
                }
                cur = cur.son[r];
            }
        }
        sum += cur.sum;//?
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
    public static void main(String[] args) {
        System.out.println(" = " + countPairs(new int[]{1,4,2,7},2,6));
    }

}