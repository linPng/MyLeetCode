import java.util.ArrayList;
import java.util.List;

public class demo118 {
    //杨辉三角 递归
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        f(numRows,0,null,ret);
        return ret;
    }
    public static void f(int n,int i,List<Integer> list,List<List<Integer>> ret){
        if(n<=i){
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
    //非递归
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + generate(5));
    }

}
