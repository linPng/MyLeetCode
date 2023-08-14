package contest.weeklycontest86;

import java.util.ArrayList;
import java.util.List;

public class C {
    //842. 将数组拆分成斐波那契序列
    //重点 回溯+剪枝 dfs
    String s;
    int n;
    public List<Integer> splitIntoFibonacci(String num) {
        s=num;
        n=num.length();
        List<Integer> list = new ArrayList<Integer>();
        dfs(list,0, 0, 0);
        return list;
    }
    public boolean dfs(List<Integer> list,int index,int sum,int pre){
        if(list.size()>2&&index==n){
            return true;
        }
        int count=0;
        for(int i=index;i<n;i++){
            if(i>index&&s.charAt(index)=='0'){
                break;
            }
            long count_l=(count*10)+(s.charAt(i)-'0');
            if(count_l>Integer.MAX_VALUE){
                break;
            }
            count=(int)count_l;
            if(list.size()>=2){
                if(count<sum){
                    continue;
                }else if(count>sum){
                    break;
                }
            }
            list.add(count);
            if(dfs(list,i+1,pre+count,count)){
                return true;
            }else{
                list.remove(list.size()-1);
            }
        }
        return false;
    }



    public List<Integer> splitIntoFibonacci2(String num) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, num, num.length(), 0, 0, 0);
        return list;
    }


    //list:结果集    num:num字符串    length:字符串的长度     index:开始的位置     sum:之前的和
    public boolean backtrack(List<Integer> list, String num, int length, int index, int sum, int prev) {
        if (index == length) {//不需要找到所有的，有满足大于3的就返回了
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {//遍历加长字符串
            if (i > index && num.charAt(index) == '0') {//排除0开头且不为0的数
                break;
            }
            currLong = currLong * 10 + num.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {//f[i]<2^31
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {//如果是第三个就只能等于前两个的和，小于sum就继续加位数，大于就剪枝
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, num, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        C c=new C();
        System.out.println("c.splitIntoFibonacci(\"1101111\") = " + c.splitIntoFibonacci("1101111"));
    }
}
