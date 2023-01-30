import java.util.HashMap;
import java.util.Map;

public class demo166 {
    //分数到小数 中等 不会
    //长除法
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        //除得尽就直接返回结果
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        //先计算符号
        StringBuffer sb = new StringBuffer();
        if (numeratorLong < 0 ^ denominatorLong < 0) {//异或
            sb.append('-');
        }

        // 去掉符号 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        // 小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;//开始循环的位置
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {//余数不为零且不重复
            remainderIndexMap.put(remainder, index);
            remainder *= 10;//每次计算一位
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        if (remainder != 0) { // 有循环节
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');//插入字符
            fractionPart.append(')');
        }
        sb.append(fractionPart.toString());

        return sb.toString().replaceAll("\\.","[\\.]");
    }
    public static void main(String[] args) {

    }
}
