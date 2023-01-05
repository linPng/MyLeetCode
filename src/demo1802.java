public class demo1802 {
    //有界数组中指定下标处的最大值
    public static int maxValue(int n, int index, int maxSum) {
        int ret=0,l=1,r=maxSum;
        while(l<=r){
            int m=(l+r)/2;
            long s=m+f(m,index)+f(m,n-index-1);
            if(s==maxSum){
                ret=m;
                break;
            }else if(s<maxSum){
                ret=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ret;
    }
    //求两边的面积 递归不可取 StackOverflowError
    public static long f2(int n,int l){
        if(l==0)return 0;
        return (long)Math.max(1,n-1)+f2(n-1,l-1);
    }
    public static long f(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }
    public static void main(String[] args) {
        //System.out.println(" = " + maxValue(6,2,931384943));//155230825
        System.out.println(" = " + maxValue(8257285,4828516,850015631));//155230825
    }
}
