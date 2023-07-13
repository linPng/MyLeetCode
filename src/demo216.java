import java.util.ArrayList;
import java.util.List;

public class demo216 {
    //组合总和 III
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < (1 << 9); ++mask) {//便利1~9的所有组合
            if (check(mask, k, n)) {
                ans.add(new ArrayList<Integer>(temp));
            }
        }
        return ans;
    }

    public boolean check(int mask, int k, int n) {
        temp.clear();
        for (int i = 0; i < 9; ++i) {//判断高位9到低位1是否存在
            if (((1 << i) & mask) != 0) {
                temp.add(i + 1);
            }
        }
        if (temp.size() != k) {//组合中的位数不对
            return false;
        }
        int sum = 0;
        for (int num : temp) {//计算组合的和
            sum += num;
        }
        return sum == n;
    }
    public static void main(String[] args) {

    }
}