import java.util.ArrayList;
import java.util.List;

public class demo77 {
    //组合 回溯算法
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        for(int i=1;i<=n;i++){
            t.add(i);
        }
        List<Integer> d=new ArrayList<>();
        f(t,d,0,k,n,r);
        return r;
    }
    public static void f(List<Integer> t,List<Integer> d,int p,int k,int n,List<List<Integer>> r){
        if(d.size()==k){
            r.add(new ArrayList<>(d));
            return;
        }
        for(int i=p;i<n;i++){
            d.add(t.get(i));
            f(t,d,i+1,k,n,r);
            d.remove(t.get(i));
        }
    };
    public static void main(String[] args) {

        System.out.println("combine(4, 2) = " + combine(4, 2));

    }

}