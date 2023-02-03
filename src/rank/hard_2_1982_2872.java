package rank;

import java.util.*;

//从子集的和还原数组
public class hard_2_1982_2872 {
    //每次还原一个数
    public int[] recoverArray(int n, int[] sums) {
        // 提前将数组排好序
        Arrays.sort(sums);
        //数组和list互转
        return dfs(n, Arrays.asList(Arrays.stream(sums).boxed().toArray(Integer[]::new))).stream().mapToInt(Integer::intValue).toArray();
    }
    // 返回值为空表示无解，否则表示有解
    public List<Integer> dfs(int n, List<Integer> sums) {
        // 递归到 n=1 时，数组中必然一个为 0，另一个为剩下的最后一个数
        // 如果满足该要求，返回剩下的最后一个数，否则返回表示无解的空数组
        if (n == 1) {
            if (sums.get(0) == 0) {
                return new ArrayList<>(Arrays.asList(sums.get(1)));
            }
            if (sums.get(1) == 0) {
                return new ArrayList<>(Arrays.asList(sums.get(0)));
            }
            return new ArrayList<>();
        }
        int d = sums.get(1) - sums.get(0);
        // 双指针构造 s 和 t
        int left = 0, right = 0;
        List<Integer> s=new ArrayList<>(), t=new ArrayList<>();//s()=t()+d;
        // 记录每个子集和是否选过
        Set<Integer> used=new HashSet<>();
        while (true) {
            // left 指针找到最小的未被选择过的子集和 1 << n == 2的n次方
            while (left < (1 << n) && used.contains(left)) {
                ++left;
            }
            if (left == (1 << n)) {
                break;
            }
            s.add(sums.get(left));
            used.add(left);
            // right 指针找到 sums[left] + d
            while (used.contains(right) || sums.get(right) != sums.get(left) + d) {
                ++right;
            }
            t.add(sums.get(right));
            used.add(right);
        }
        // 尝试包含 d 并递归求解 (n-1, s)
        List<Integer> ans = dfs(n - 1, s);
        if (!ans.isEmpty()) {
            ans.add(d);
            return ans;
        }
        // 尝试包含 -d 并递归求解 (n-1, t)
        ans = dfs(n - 1, t);
        if (!ans.isEmpty()) {
            ans.add(-d);
            return ans;
        }
        // 无解返回空数组
        return new ArrayList<>();
    }
    public int[] recoverArray3(int n, int[] sums) {
        int m=1;
        for (int i=1;i<=n;i++){//2的n次方  1 << n
            m*=2;
        }
        int sumMin=Integer.MAX_VALUE;//-10^4 <= sums[i] <= 10^4
        List<Integer> absList=new ArrayList<>();
        int[] cou=new int[25000];//存sum+10000,sum+10000肯定大于0,且小于200000
        for (int i=0;i<m;i++){
            cou[sums[i]+10000]++;
            if (sums[i]<sumMin){
                sumMin=sums[i];
            }
        }
        for (int i=1;i<=n;i++){
            int mi1=-1;int sum=0;
            int j=0;
            for (j=0;j<=20000&&sum<2;j++){//找出最低的两个,类似基数排序
                if (cou[j]>0){
                    if (mi1==-1){
                        mi1=j;
                    }
                }
                sum+=cou[j];
            }
            int mi2=j-1;//for 循环结束还会+1,要减去
            int sub=mi2-mi1;
            absList.add(sub);
            for (j=0;j<=20000;j++){
                if (sub==0){
                    cou[j]/=2;
                } else {
                    cou[j+sub]-=cou[j];//
                }
            }
        }
        for (int i=0;i<m;i++){
            int x=i;
            int sum=0;
            for (int j=0;j<n;j++){
                if (x%2==1){
                    sum-=absList.get(j);
                }
                x/=2;
            }
            //System.out.println(sum+" "+sumMin);
            if (sum==sumMin){
                int[] ans=new int[n];
                x=i;
                for (int j=0;j<n;j++){
                    if (x%2==1){
                        ans[j]=-absList.get(j);
                    } else {
                        ans[j]=absList.get(j);
                    }
                    x/=2;
                }
                return ans;
            }
        }
        return null;


    }
}
        /*// n 个数构成程度为 2^n 的子集和数组 sums
        // 返回值为空表示无解，否则表示有解
        vector<int> dfs(int n, vector<int>& sums) {
        // 递归到 n=1 时，数组中必然一个为 0，另一个为剩下的最后一个数
        // 如果满足该要求，返回剩下的最后一个数，否则返回表示无解的空数组
        if (n == 1) {
        if (sums[0] == 0) {
        return {sums[1]};
        }
        if (sums[1] == 0) {
        return {sums[0]};
        }
        return {};
        }

        int d = sums[1] - sums[0];
        // 双指针构造 s 和 t
        int left = 0, right = 0;
        vector<int> s, t;
        // 记录每个子集和是否选过
        vector<int> used(1 << n);
        while (true) {
        // left 指针找到最小的未被选择过的子集和
        while (left < (1 << n) && used[left]) {
        ++left;
        }
        if (left == (1 << n)) {
        break;
        }
        s.push_back(sums[left]);
        used[left] = true;
        // right 指针找到 sums[left] + d
        while (used[right] || sums[right] != sums[left] + d) {
        ++right;
        }
        t.push_back(sums[right]);
        used[right] = true;
        }

        // 尝试包含 d 并递归求解 (n-1, s)
        vector<int> ans = dfs(n - 1, s);
        if (!ans.empty()) {
        ans.push_back(d);
        return ans;
        }
        // 尝试包含 -d 并递归求解 (n-1, t)
        ans = dfs(n - 1, t);
        if (!ans.empty()) {
        ans.push_back(-d);
        return ans;
        }
        // 无解返回空数组
        return {};
        }

public:
        vector<int> recoverArray(int n, vector<int>& sums) {
        // 提前将数组排好序
        sort(sums.begin(), sums.end());
        return dfs(n, sums);
        }

//根据性质选择 SS 或 TT
public:
        vector<int> recoverArray(int n, vector<int>& sums) {
        // 提前将数组排好序
        sort(sums.begin(), sums.end());

        vector<int> ans;
        for (int i = n; i >= 2; --i) {
        int d = sums[1] - sums[0];
        // 双指针构造 s 和 t
        int left = 0, right = 0;
        vector<int> s, t;
        // 记录每个子集和是否选过
        vector<int> used(1 << i);
        while (true) {
        // left 指针找到最小的未被选择过的子集和
        while (left < (1 << i) && used[left]) {
        ++left;
        }
        if (left == (1 << i)) {
        break;
        }
        s.push_back(sums[left]);
        used[left] = true;
        // right 指针找到 sums[left] + d
        while (used[right] || sums[right] != sums[left] + d) {
        ++right;
        }
        t.push_back(sums[right]);
        used[right] = true;
        }
        if (find(s.begin(), s.end(), 0) != s.end()) {
        // 包含 d 并求解 (n-1, s)
        ans.push_back(d);
        sums = move(s);
        }
        else {
        // 包含 -d 并求解 (n-1, t)
        ans.push_back(-d);
        sums = move(t);
        }
        }
        // 迭代到 n=1 时，数组中必然一个为 0，另一个为剩下的最后一个数
        ans.push_back(sums[0] + sums[1]);
        return ans;
        }*/



