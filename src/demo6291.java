public class demo6291 {
    //数组元素和与数字和的绝对差
    public static int differenceOfSum(int[] nums) {
        int ret=0;
        for(int n:nums){
            char[] c=String.valueOf(n).toCharArray();
            int t=0;
            for(char e:c){
                t+=e-'0';
            }
            ret+=n-t;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + differenceOfSum(new int[]{1,15,6,3}));
    }

}