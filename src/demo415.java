public class demo415 {
    //字符串相加
    public String addStrings(String n1, String n2) {
        char[] num1=n1.toCharArray();
        char[] num2=n2.toCharArray();
        int i = num1.length - 1, j = num2.length - 1;
        int base = 0;
        int add = 0;
        while (i >= 0 || j >= 0) {
            base=0;
            if (i >= 0) { base += num1[i] - '0'; }
            if (j >= 0) { base += num2[j] - '0'; }
            base+=add;
            if (i >= 0) { num1[i] = (char)('0' + base % 10); }
            if (j >= 0) { num2[j] = (char)('0' + base % 10); }
            if(base>=10){
                add=1;
            }else{
                add=0;
            }
            if ((i < 0 || j < 0) && base<10) {
                break;
            }
            i--;
            j--;
        }
        if (add>0) {
            return "1" + String.valueOf(i > j ? num1 : num2);
        } else {
            return String.valueOf(i > j ? num1 : num2);
        }
    }
    public static void main(String[] args) {

    }
}