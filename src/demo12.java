public class demo12 {
    //整数转罗马数字
    //模拟 枚举
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
    //模拟 暴力版
    public String intToRoman2(int num) {
        StringBuilder s=new StringBuilder();
        for(int M=num/1000;M>0;M--){
            s.append("M");
        }
        num=num%1000;
        for(int M=num/900;M>0;M--){
            s.append("CM");
        }
        num=num%900;
        for(int M=num/500;M>0;M--){
            s.append("D");
        }

        num=num%500;
        for(int M=num/400;M>0;M--){
            s.append("CD");
        }
        num=num%400;
        for(int M=num/100;M>0;M--){
            s.append("C");
        }
        num=num%100;
        for(int M=num/90;M>0;M--){
            s.append("XC");
        }
        num=num%90;
        for(int M=num/50;M>0;M--){
            s.append("L");
        }
        num=num%50;
        for(int M=num/40;M>0;M--){
            s.append("XL");
        }
        num=num%40;
        for(int M=num/10;M>0;M--){
            s.append("X");
        }
        num=num%10;
        for(int M=num/9;M>0;M--){
            s.append("IX");
        }
        num=num%9;
        for(int M=num/5;M>0;M--){
            s.append("V");
        }
        num=num%5;
        for(int M=num/4;M>0;M--){
            s.append("IV");
        }
        num=num%4;
        for(int M=num;M>0;M--){
            s.append("I");
        }
        return s.toString();
    }
    public static void main(String[] args) {

    }
}