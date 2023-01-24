public class demo29 {
    //两数相除 中等 二分
    public int divide(int a, int b) {
        long dividend=a;
        long divisor=b;
        long r =0;
        boolean issub=false;
        if(dividend<0){
            dividend=-dividend;
            issub=!issub;
        }
        if(divisor<0){
            divisor=-divisor;
            issub=!issub;
        }
        r=div(dividend,divisor);
        if(issub){
            r=-r;
        }
        if(r>Integer.MAX_VALUE||r<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)r;
    }
    public long div(long a,long b){
        if(a<b){
            return 0;
        }
        if(a==b){
            return 1;
        }
        int r=1;
        long t=b;
        while(a>(t+t)){
            r=r+r;
            t=t+t;
        }
        return r+div(a-t,b);
    }
    public static void main(String[] args) {

    }
}