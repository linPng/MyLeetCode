public class demo50 {
    public static double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        long N=n;// -231 <= n <= 231-1   避免MIN_VALUE的情况
        return n>0?f(x,N):1/f(x,-N);
    }
    public static double f(double x, long n){
        if(n==0){
            return 1.0;
        }
        double z=f(x,n/2);//避免二次计算
        return z*z*(n%2==1?x:1);
    }
    public static void main(String[] args) {
        myPow(0.00001,2147483647);
    }

}