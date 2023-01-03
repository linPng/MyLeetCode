import java.util.ArrayList;
import java.util.List;

public class demo120 {
    //三角形最小路径和 暴力回溯<回溯+记忆化=动态规划<动态规划+滚动数组
    public static int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> l=triangle.get(i);
            List<Integer> p=triangle.get(i+1);
            for(int j=0;j<l.size();j++){
                l.set(j,l.get(j)+Math.min(p.get(j),p.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
    public static void main(String[] args) {


    }

}
