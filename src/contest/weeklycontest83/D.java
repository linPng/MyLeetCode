package contest.weeklycontest83;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D {
    //统计子串中的唯一字符

    //贡献法
    /*只要一个字符作为某一个子串的唯一字符就对结果加一，所以可以计算每个字符对应的唯一字符的字串数再求和;
    * */
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        //计算每个字符对应的唯一字串区域，把每次出现都记下来
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);//起点
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());//终点
            for (int i = 1; i < arr.size() - 1; i++) {//计算每个唯一子串区域的子串和
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
