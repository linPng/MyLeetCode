public class demo69 {
    //x 的平方根
    public static int mySqrt(int x) {
        int l=0,r=x,ans=0;
        while(l<=r){
            int m=(l+r)/2;
            if((long)m*m==x){
                return m;
            }else if((long)m*m>x){
                r=m-1;
            }else{
                ans=m;
                l=m+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        System.out.println("=== = " + mySqrt(2147395599));
    }

}
