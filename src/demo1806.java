public class demo1806 {
    //还原排列的最少操作步数
    //数学
    public static int reinitializePermutation(int n) {
        int ret=0,i=1;
        do{
            ret++;
            i=i*2%(n-1);
        }
        while(i!=1);
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + reinitializePermutation(6));
        System.out.println(" = " + reinitializePermutation(8));
        System.out.println(" = " + reinitializePermutation(10));
    }

}