public class demo66 {
    //加一 简单
    public int[] plusOne(int[] digits) {
        int n=digits.length-1;
        while(n>=0){
            digits[n]++;
            if(digits[n]==10){
                if(n==0){
                    int[] r=new int[digits.length+1];
                    r[0]=1;
                    return r;
                }
                digits[n]=0;
            }else{
                break;
            }
            n--;
        }
        return digits;
    }
    public static void main(String[] args) {

    }
}