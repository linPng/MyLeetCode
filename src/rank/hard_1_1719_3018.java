package rank;

import java.util.*;

public class hard_1_1719_3018 {
    //重构一棵树的方案数
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();//建立无向图
        for (int[] p : pairs) {
            map.putIfAbsent(p[0], new HashSet<Integer>());
            map.putIfAbsent(p[1], new HashSet<Integer>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        /* 检测是否存在根节点*/
        int root = -1;
        //遍历map
        Set<Map.Entry<Integer, Set<Integer>>> entries = map.entrySet();//要遍历两次使用把mapentryset写在外面
        for (Map.Entry<Integer, Set<Integer>> entry : entries) {
            int node = entry.getKey();
            Set<Integer> neighbours = entry.getValue();
            if (neighbours.size() == map.size() - 1) {//如果出入度等于n-1,就是根节点
                root = node;
            }
        }
        if (root == -1) {
            return 0;
        }

        int res = 1;
        for (Map.Entry<Integer, Set<Integer>> entry : entries) {//遍历map,所有节点都能找到父节点就能组成树
            int node = entry.getKey();
            Set<Integer> neighbours = entry.getValue();//所有的出入度
            if (node == root) {//跳过根节点
                continue;
            }
            int currDegree = neighbours.size();//出入度数
            int parent = -1;//父节点
            int parentDegree = Integer.MAX_VALUE;//父节点的出入度数

            /* 根据 degree 的大小找到 node 的父节点 parent */
            for (int neighbour : neighbours) {//遍历出入度,寻找出入度更大,的最小出入度的邻居节点
                if (map.get(neighbour).size() < parentDegree && map.get(neighbour).size() >= currDegree) {
                    parent = neighbour;
                    parentDegree = map.get(neighbour).size();
                }
            }
            if (parent == -1) {//如果存在没有父节点的孤节点就不能组成树
                return 0;
            }

            /* 检测 neighbours 是否是 adj[parent] 的子集 */
            for (int neighbour : neighbours) {
                if (neighbour == parent) {
                    continue;
                }
                if (!map.get(parent).contains(neighbour)) {
                    return 0;
                }
            }
            if (parentDegree == currDegree) {//只要存在父子出入度相等就
                res = 2;
            }
        }
        return res;
    }


    public static int checkWays2(int[][] pairs) {
        int N = 501;//1 <= xi < yi <= 500  501就可以保障不溢出
        int[] counts = new int[N], parent = new int[N];//counts是出入度;parent记录父节点
        boolean[][] graph = new boolean[N][N];//关系矩阵,两节点有关系就是true
        int m = pairs.length;//边的数量
        Set<Integer> nodes = new HashSet<>();//所有节点的集合,用set可以去重
        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            graph[x][y] = graph[y][x] = true;
            counts[x]++;
            counts[y]++;
            nodes.add(x);
            nodes.add(y);
        }
        List<Integer> list = new ArrayList<>(nodes);
        Collections.sort(list, (a,b)->counts[b]-counts[a]);//出入度大到小排序
        int n = list.size();//节点数
        int root = list.get(0);//出入度最大的节点之一
        //节点对数(边数)至少为节点数-1
        if (m < n - 1){//连一层的树也无法形成,假设所有叶子都在根节点上,也会有n-1个边;
            return 0;
        }
        parent[root] = -1;
        for (int i = 1; i < n; i++) {//出入度从大到小遍历节点
            int u = list.get(i);
            int parentId = -1;
            int j = i - 1;
            while(j >= 0) {//寻找最小出入度的父节点,出入度要大于等于本节点
                int v = list.get(j);
                if (graph[u][v]) {
                    parentId = v;
                    break;
                }
                j--;
            }
            if (parentId == -1){//没找到父节点
                return 0;
            }
            parent[u] = parentId;
        }
        int result = 1;
        int count = 0;
        for (int node : nodes) {
            int ancestor = parent[node];//父节点
            while (ancestor != -1) {
                if (!graph[node][ancestor]){//不存在关系
                    return 0;
                }
                // 出现子节点和父节点的出入度一样,就是可以对调的,可以生成不一样的树
                if (counts[node] == counts[ancestor]){
                    result = 2;
                }
                count++;//如果可以生成树,所有的祖宗节点都需要遍历到,最后要等于m
                ancestor = parent[ancestor];
            }

        }

        return count == m ? result : 0;//如果小于m,就是有把非祖宗节点当作父节点
    }
    public static void main(String[] args) {
        System.out.println("checkWays2 = " + checkWays2(new int[][]{{1,3},{7,11},{11,14},{13,14},{3,14},{7,15},{3,10},{3,7},{11,12},{3,9},{7,8},{1,7},{5,6},{13,15},{6,7},{7,13},{3,6},{3,5},{5,9},{9,13},{12,14},{7,10},{8,9},{9,15},{5,14},{1,14},{6,14},{8,11},{9,12},{10,14},{4,14},{2,14},{5,7},{1,6},{2,7},{8,14},{9,14},{6,9},{14,15},{7,12},{9,10},{9,11},{1,9},{7,14},{8,12}}));
    }
}
