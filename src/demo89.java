import java.util.ArrayList;
import java.util.List;

public class demo89 {
    //格雷编码
    public static List<Integer> grayCode(int n) {
        List<Integer> r=new ArrayList();
        r.add(0);
        r.add(1);
        while(--n>0){
            r=f(r);
        }
        return r;
    }
    public static List<Integer> f(List<Integer> l){//最前补01
        int n=l.size();
        for(int i=n-1;i>=0;i--){
            l.add(l.get(i)+n);
        }
        return l;
    }
    public static List<Integer> f2(List<Integer> l){//乘2进位
        List<Integer> r=new ArrayList();
        for(int i=0;i<l.size();i++){
            r.add(l.get(i)*2);
        }
        for(int i=l.size()-1;i>=0;i--){
            r.add(l.get(i)*2+1);
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(" = " + grayCode(2));
    }

}