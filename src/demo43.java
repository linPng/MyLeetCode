public class demo43 {
    //字符串相乘
    public static String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        int[] t = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int x=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int y=num2.charAt(j)-'0';
                int r=x*y+t[i+j+1];
                t[i+j+1]=r%10;
                t[i+j]+=r/10;
            }
        }
        String ret="";
        for(int k=0;k<t.length;k++){
            if(k==0&&t[k]==0){
                continue;
            }
            ret+=t[k];
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("multiply = " + multiply("123","456"));;
    }

}