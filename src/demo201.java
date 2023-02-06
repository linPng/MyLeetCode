public class demo201 {
    //数字范围按位与
    //公共前缀
    public int rangeBitwiseAnd(int left, int right) {
        int t=0;
        while(left<right){
            left>>=1;
            right>>=1;
            t++;
        }
        return left<<t;
    }
    public static void main(String[] args) {

    }
}
