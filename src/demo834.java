import java.util.ArrayList;
import java.util.List;

public class demo834 {
    //树中距离之和
    //不会
    int[] ans;
    int[] sz;
    int[] dp;
    List<List<Integer>> graph;//双向联通图

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        sz = new int[n];//自己加上子节点的数量
        dp = new int[n];//以根节点向下求和，排除父节点，所以只有父节点的最终的和
        graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {//初始化
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {//建图
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //入参是root和preroot
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    //以0为根，dfs求和
    public void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v: graph.get(u)) {
            if (v == f) {//避免回头
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    //调整根节点
    public void dfs2(int u, int f) {
        ans[u] = dp[u];//调整后的就是最终的和
        for (int v: graph.get(u)) {
            if (v == f) {//避免回头
                continue;
            }
            //保存参数用来还原
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];//父节点变成子节点，减去这一侧的步数和（原步数+子节点数）
            sz[u] -= sz[v];//父节点的节点数要减去这一侧的节点数
            dp[v] += dp[u] + sz[u];//该节点的步数要再加上原来的父节点
            sz[v] += sz[u];

            dfs2(v, u);

            //还原
            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
    public static void main(String[] args) {

    }
}