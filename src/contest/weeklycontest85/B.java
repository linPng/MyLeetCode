package contest.weeklycontest85;

import java.util.*;

public class B {
    //838. 推多米诺
    //经典bfs
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> queue = new ArrayDeque<Integer>();//每一时刻发生的力
        int[] time = new int[n];//发生变化的时间
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; i++) {//初始化一个点可以收到多个力，1对n
            force[i] = new ArrayList<Character>();
        }
        for (int i = 0; i < n; i++) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                queue.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '.');
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (force[i].size() == 1) {//只受到单边的力
                char f = force[i].get(0);
                res[i] = f;
                int ni = f == 'L' ? i - 1 : i + 1;//根据力的方向，确定下一个的索引
                if (ni >= 0 && ni < n) {
                    int t = time[i];
                    if (time[ni] == -1) {
                        queue.offer(ni);
                        time[ni] = t + 1;
                        force[ni].add(f);
                    } else if (time[ni] == t + 1) {//同一时刻左右的力抵消，size>1
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {

    }
}
