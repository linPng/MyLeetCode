import java.util.*;

public class demo1632 {
    //矩阵转换后的秩 困难 特别难 不会 并查集 + 拓扑排序
    /*
    * 1.自定义并查集
    * 2.并查集初始化：同行列相同数字在一个集合内
    * 3.遍历行列建立有向图，记录出度
    * 4.拓扑排序
    * */
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        UnionFind uf = new UnionFind(m, n);//初始化
        //将每行相同的数字加入并查集
        for (int i = 0; i < m; i++) {
            Map<Integer, List<int[]>> num2indexList = new HashMap<Integer, List<int[]>>();//将相同的数字放在同一个list中，key是数字
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                num2indexList.putIfAbsent(num, new ArrayList<int[]>());
                num2indexList.get(num).add(new int[]{i, j});
            }
            for (List<int[]> indexList : num2indexList.values()) {
                int[] arr1 = indexList.get(0);
                int i1 = arr1[0], j1 = arr1[1];
                for (int k = 1; k < indexList.size(); k++) {
                    int[] arr2 = indexList.get(k);
                    int i2 = arr2[0], j2 = arr2[1];
                    uf.union(i1, j1, i2, j2);
                }
            }
        }
        //再将每列相同的数字加入并查集
        for (int j = 0; j < n; j++) {
            Map<Integer, List<int[]>> num2indexList = new HashMap<Integer, List<int[]>>();
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                num2indexList.putIfAbsent(num, new ArrayList<int[]>());
                num2indexList.get(num).add(new int[]{i, j});
            }
            for (List<int[]> indexList : num2indexList.values()) {
                int[] arr1 = indexList.get(0);
                int i1 = arr1[0], j1 = arr1[1];
                for (int k = 1; k < indexList.size(); k++) {
                    int[] arr2 = indexList.get(k);
                    int i2 = arr2[0], j2 = arr2[1];
                    uf.union(i1, j1, i2, j2);
                }
            }
        }

        int[][] degree = new int[m][n];//记录入度
        Map<Integer, List<int[]>> adj = new HashMap<Integer, List<int[]>>();//key是序号确定是哪一格，value是出度，指向下一个大的数字
        for (int i = 0; i < m; i++) {
            Map<Integer, int[]> num2index = new HashMap<Integer, int[]>();//key是数字，去重
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                num2index.put(num, new int[]{i, j});
            }
            List<Integer> sortedArray = new ArrayList<Integer>(num2index.keySet());//这一列所有的数字，去重
            Collections.sort(sortedArray);//排序
            for (int k = 1; k < sortedArray.size(); k++) {
                int[] prev = num2index.get(sortedArray.get(k - 1));
                int[] curr = num2index.get(sortedArray.get(k));
                int i1 = prev[0], j1 = prev[1], i2 = curr[0], j2 = curr[1];
                int[] root1 = uf.find(i1, j1);
                int[] root2 = uf.find(i2, j2);
                int ri1 = root1[0], rj1 = root1[1], ri2 = root2[0], rj2 = root2[1];
                degree[ri2][rj2]++;
                adj.putIfAbsent(ri1 * n + rj1, new ArrayList<int[]>());
                adj.get(ri1 * n + rj1).add(new int[]{ri2, rj2});//加入比较大的数，建立有向图
            }
        }
        for (int j = 0; j < n; j++) {
            Map<Integer, int[]> num2index = new HashMap<Integer, int[]>();
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                num2index.put(num, new int[]{i, j});
            }
            List<Integer> sortedArray = new ArrayList<Integer>(num2index.keySet());
            Collections.sort(sortedArray);
            for (int k = 1; k < sortedArray.size(); k++) {
                int[] prev = num2index.get(sortedArray.get(k - 1));
                int[] curr = num2index.get(sortedArray.get(k));
                int i1 = prev[0], j1 = prev[1], i2 = curr[0], j2 = curr[1];
                int[] root1 = uf.find(i1, j1);
                int[] root2 = uf.find(i2, j2);
                int ri1 = root1[0], rj1 = root1[1], ri2 = root2[0], rj2 = root2[1];
                degree[ri2][rj2]++;
                adj.putIfAbsent(ri1 * n + rj1, new ArrayList<int[]>());
                adj.get(ri1 * n + rj1).add(new int[]{ri2, rj2});
            }
        }

        //找到所有根节点，设置为1，ranks只设置根节点
        Set<Integer> rootSet = new HashSet<Integer>();
        int[][] ranks = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] rootArr = uf.find(i, j);
                int ri = rootArr[0], rj = rootArr[1];
                rootSet.add(ri * n + rj);
                ranks[ri][rj] = 1;
            }
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        //入度为0的优先队列
        for (int val : rootSet) {
            if (degree[val / n][val % n] == 0) {
                queue.offer(new int[]{val / n, val % n});
            }
        }
        //拓扑排序
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0], j = arr[1];
            for (int[] adjArr : adj.getOrDefault(i * n + j, new ArrayList<int[]>())) {//遍历所有出度
                int ui = adjArr[0], uj = adjArr[1];
                degree[ui][uj]--;
                if (degree[ui][uj] == 0) {
                    queue.offer(new int[]{ui, uj});
                }
                ranks[ui][uj] = Math.max(ranks[ui][uj], ranks[i][j] + 1);//出度的rank一定大于本节点+1;
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] rootArr = uf.find(i, j);
                int ri = rootArr[0], rj = rootArr[1];
                res[i][j] = ranks[ri][rj];//将根节点反向填充到数组中
            }
        }
        return res;
    }
    class UnionFind {//查并集
        int m, n;//矩阵长宽
        int[][][] root;

        //size非必须，不加也可以，用于判断引用链的大小，避免多的引用少的，优化效率
        int[][] size;

        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            this.root = new int[m][n][2];
            this.size = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    root[i][j][0] = i;
                    root[i][j][1] = j;
                    size[i][j] = 1;
                }
            }
        }

        public int[] find(int i, int j) {
            int[] rootArr = root[i][j];
            int ri = rootArr[0], rj = rootArr[1];
            if (ri == i && rj == j) {
                return rootArr;
            }
            return find(ri, rj);
        }

        public void union(int i1, int j1, int i2, int j2) {
            int[] rootArr1 = find(i1, j1);
            int[] rootArr2 = find(i2, j2);
            int ri1 = rootArr1[0], rj1 = rootArr1[1];
            int ri2 = rootArr2[0], rj2 = rootArr2[1];
            if (ri1 != ri2 || rj1 != rj2) {
                if (size[ri1][rj1] >= size[ri2][rj2]) {
                    root[ri2][rj2][0] = ri1;
                    root[ri2][rj2][1] = rj1;
                    size[ri1][rj1] += size[ri2][rj2];
                } else {
                    root[ri1][rj1][0] = ri2;
                    root[ri1][rj1][1] = rj2;
                    size[ri2][rj2] += size[ri1][rj1];
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}