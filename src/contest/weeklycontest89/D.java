package contest.weeklycontest89;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class D {
    //854. 相似度为 K 的字符串
    //bfs
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        //键值对队列 键：新的str 值：步数
        Queue<Pair<String, Integer>> queue = new ArrayDeque<Pair<String, Integer>>();
        Set<String> visit = new HashSet<String>();
        queue.offer(new Pair<String, Integer>(s1, 0));
        visit.add(s1);
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Pair<String, Integer> pair = queue.poll();
                String cur = pair.getKey();
                int pos = pair.getValue();
                if (cur.equals(s2)) {
                    return step;
                }
                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {//跳过已经匹配的
                    pos++;
                }
                for (int j = pos + 1; j < n; j++) {
                    if (s2.charAt(j) == cur.charAt(j)) {//跳过已经匹配的
                        continue;
                    }
                    if (s2.charAt(pos) == cur.charAt(j)) {//找到匹配字符才替换
                        String next = swap(cur, pos, j);
                        if (!visit.contains(next)) {//去重剪枝
                            visit.add(next);
                            queue.offer(new Pair<String, Integer>(next, pos + 1));
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
    public static void main(String[] args) {

    }
}
