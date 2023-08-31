import java.util.HashMap;
import java.util.Map;

public class demo1782 {
    //1782. 统计点对的数目
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] deg = new int[n + 1];
        HashMap<Integer, Integer> cntE = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            deg[x]++;
            deg[y]++;
            cntE.merge((x << 16) | y, 1, (a, b) -> a + b);
        }
        HashMap<Integer, Integer> cntDeg = new HashMap<>();
        int maxDeg = 0;
        for (int i = 1; i <= n; i++) {
            cntDeg.merge(deg[i], 1, (a, b) -> a + b);
            maxDeg = Math.max(maxDeg, deg[i]);
        }
        int[] cnts = new int[maxDeg * 2 + 2];
        for (HashMap.Entry<Integer, Integer> e1 : cntDeg.entrySet()) {
            int deg1 = e1.getKey(), c1 = e1.getValue();

            for (HashMap.Entry<Integer, Integer> e2 : cntDeg.entrySet()) {
                int deg2 = e2.getKey(), c2 = e2.getValue();

                if (deg1 < deg2)
                    cnts[deg1 + deg2] += c1 * c2;
                else if (deg1 == deg2)
                    cnts[deg1 + deg2] += c1 * (c1 - 1) / 2;
            }
        }
        for (HashMap.Entry<Integer, Integer> e : cntE.entrySet()) {
            int k = e.getKey(), c = e.getValue();
            int s = deg[k >> 16] + deg[k & 0xffff];
            cnts[s]--;
            cnts[s - c]++;
        }
        for (int i = cnts.length - 1; i > 0; i--)
            cnts[i - 1] += cnts[i];
        for (int i = 0; i < queries.length; i++)
            queries[i] = cnts[Math.min(queries[i] + 1, cnts.length - 1)];
        return queries;
    }

    public static void main(String[] args) {

    }
}
