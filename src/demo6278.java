public class demo6278 {
    //统计能整除数字的位数
    public static int countDigits(int num) {
        int r=0;
        int yu,sh=num;
        while(sh>0){
            yu=sh%10;
            if(num%yu==0){
                r++;
            }
            sh=sh/10;
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(" = " + countDigits(1248));
    }

}