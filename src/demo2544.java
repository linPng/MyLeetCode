public class demo2544 {
    //交替数字和
    public int alternateDigitSum(int n) {
        String s=String.valueOf(n);
        int ret=0;
        int i=1;
        for(char c:s.toCharArray()){
            ret+=i*(c-48);
            i=i*-1;
        }
        return ret;
    }
    public static void main(String[] args) {
        char c='0';
        System.out.println(c-0);
    }
}