import java.util.ArrayList;
import java.util.List;

public class demo6280 {
    //范围内最接近的两个质数
    public static int[] closestPrimes(int left, int right) {
        int ma_0=-1,ma_1=-1;
        int min=Integer.MAX_VALUE,ret_0=-1,ret_1=-1;
        if(left<=2&&right>=3){
            return new int[]{2,3};
        }
        for(int i=left;i<=right;i++){
            if(f(i)){
                ma_0=ma_1;
                ma_1=i;
                if(ma_1!=-1&&ma_0!=-1){
                    int temp=ma_1-ma_0;
                    if(temp<min){
                        min=temp;
                        ret_0=ma_0;
                        ret_1=ma_1;
                        if(temp==2){
                            return new int[]{ret_0,ret_1};
                        }
                    }
                }
            }
        }
        return new int[]{ret_0,ret_1};
    }
    //判断质数 最基础的方法
    public static boolean f2(int number){
        boolean isFind = true;
        for(int i=2; i<number; i++){
            if(number%i==0){
                isFind=false;
            }
        }
        return isFind;
    }
    //判断质数 较小的质因数一定小于开根号
    public static boolean f(int number){
        boolean isFind = true;
        for(int i=2; i*i<=number; i++){//i<Math.sqrt(number)
            if(number%i==0){
                isFind=false;
            }
        }
        return isFind;
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
        //System.out.println(" = " + closestPrimes(12854,130337));
        System.out.println(" = " + euler_flag_prime(1000));
    }

}
