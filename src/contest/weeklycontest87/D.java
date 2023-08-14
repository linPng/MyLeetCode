package contest.weeklycontest87;

import java.util.LinkedList;
import java.util.Queue;

public class D {
    //847. 访问所有节点的最短路径
    //经典bfs 使用位来表示已经走过的路
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});//表示第i位开始，第i位是自己，已经走过了
            seen[i][1 << i] = true;//标记已经走过，因为可以走回头，需要记下已经走过的路，如果走过的路没有增加，走回头路就是没有意义的
        }

        int ans = 0;
        while (!queue.isEmpty()) {//bfs
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {//全是1，就是都走过了，返回ans，bfs最先到的答案就是最短的
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {//避免无意义的回头路
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
