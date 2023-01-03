import java.util.ArrayList;
import java.util.List;

public class demo119 {
    //杨辉三角 II
    public static List<Integer> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        f(numRows,0,null,ret);
        return ret.get(ret.size()-1);
    }
    public static void f(int n,int i,List<Integer> list,List<List<Integer>> ret){
        if(n<i){
            return;
        }
        List<Integer> l=new ArrayList<>();
        if(i==0){
            l.add(1);
            ret.add(l);
        }else{
            l.add(1);
            for(int j=1;j<list.size();j++){
                l.add(list.get(j-1)+list.get(j));
            }
            l.add(1);
            ret.add(l);
        }
        f(n,i+1,l,ret);
    }
    //非递归 计算组合数
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
    public static void main(String[] args) {
        System.out.println(" = " + generate(5));
    }

}
