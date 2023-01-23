public class demo2303 {
    //计算应缴税款总额
    public static double calculateTax(int[][] brackets, int income) {
        double ret=0;
        int t=0;
        for(int[] e:brackets){
            if(e[0]>income){
                ret+=(double)(income-t)*e[1]/100;
                break;
            }
            ret+=(double)(e[0]-t)*e[1]/100;
            t=e[0];
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(calculateTax(new int[][]{{3,50},{7,10},{12,25}},10));
    }
}