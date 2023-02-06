import java.util.ArrayList;
import java.util.List;

public class demo204 {
    //计数质数
    //数学 欧拉线性筛素数
    public int countPrimes(int n) {
        return euler_flag_prime(n).size();
    }
    //欧拉线性筛素数 返回n以下的素数
    public static List<Integer> euler_flag_prime(int n){
        boolean[] f=new boolean[n+1];
        List<Integer> r=new ArrayList<>();
        for(int i=2;i<n+1;i++){
            if(!f[i]){
                r.add(i);
            }
            for(int e:r){
                if(i*e>n){
                    break;
                }
                f[i*e]=true;
                if(i%e==0){
                    break;
                }
            }
        }
        return r;
    }
    public static void main(String[] args) {

    }
}
