package planning.BasicDataStructures.Backtracking;

public class Backtracking14_1240_TilingARectangleWithTheFewestSquares {
        int ans;
        public int tilingRectangle(int n, int m) {
            ans = Math.max(n, m);
            boolean[][] rect = new boolean[n][m];//标记是否铺过
            dfs(0, 0, rect, 0);
            return ans;
        }

        public void dfs(int x, int y, boolean[][] rect, int cnt) {
            int n = rect.length, m = rect[0].length;
            if (cnt >= ans) {//超过了不再计算
                return;
            }
            if (x >= n) {//全部铺满了
                ans = cnt;
                return;
            }
            /* 检测下一行 */
            if (y >= m) {//这一行铺满了
                dfs(x + 1, 0, rect, cnt);
                return;
            }
            /* 如当前已经被覆盖，则直接尝试下一个位置 */
            if (rect[x][y]) {
                dfs(x, y + 1, rect, cnt);
                return;
            }

            int len = Math.min(n - x, m - y);//当前可以放下的最大瓷砖
            while (len >= 1 && !isAvailable(rect, x, y, len)) {
                len--;
            }
            for (int k = len; k >= 1; k--) {
                /* 将长度为 k 的正方形区域标记覆盖 */
                fillUp(rect, x, y, k, true);
                /* 跳过 k 个位置开始检测 */
                dfs(x, y + k, rect, cnt + 1);
                fillUp(rect, x, y, k, false);
            }
        }

        public boolean isAvailable(boolean[][] rect, int x, int y, int k) {//判断瓷砖能不能放得下
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (rect[x + i][y + j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {//标记是否被覆盖
            for (int i = 0; i < k; i++){
                for (int j = 0; j < k; j++) {
                    rect[x + i][y + j] = val;
                }
            }
        }
}
