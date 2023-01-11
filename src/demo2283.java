import java.util.HashMap;
import java.util.Map;

public class demo2283 {
    //判断一个数的数字计数是否等于数位的值 哈希表 简单
    public static boolean digitCount(String num) {
        Map<Integer, Integer> m =new HashMap<>();
        for(char c:num.toCharArray()){
            m.put(c-'0',m.getOrDefault(c-'0',0)+1);
        }
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)-'0'!=m.getOrDefault(i,0)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(" = " + digitCount("1210"));
    }

}
