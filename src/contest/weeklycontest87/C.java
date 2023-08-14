package contest.weeklycontest87;

import java.util.*;

public class C {
    //846. 一手顺子
    //暴力哈希
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        // 哈希表计数 （优化 ：排序，遍历排序后的 数组比遍历key寻找最小值要快）
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : hand) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        while (!freqMap.isEmpty()) {
            // 寻找最小值
            int min = Integer.MAX_VALUE;
            for (int num : freqMap.keySet()) {
                min = Math.min(min, num);
            }

            // 移除顺子
            for (int i = min; i < min + groupSize; i++) {
                if (!freqMap.containsKey(i)) {
                    return false; // 缺少顺子
                }

                int count = freqMap.get(i);
                if (count == 1) {
                    freqMap.remove(i);
                } else {
                    freqMap.put(i, count - 1);
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
