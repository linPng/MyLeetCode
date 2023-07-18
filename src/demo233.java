import java.util.Deque;
import java.util.LinkedList;

public class demo233 {
    //数字 1 的个数
    //按位计算，假设十位是1，有多少种情况？1.本位是0 1204-》0010~1119==000~119==120（high*digit）
    //2.本位是1 1214-》0010~1214==000~124==120（high*digit+low+1）
    //3.本位是大于1 1224-》0010~1219==000~129==130（(high+1)*digit）
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}