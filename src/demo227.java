import java.util.Deque;
import java.util.LinkedList;

public class demo227 {
    //基本计算器 II
    public int calculate(String s) {
        Deque<Long> ops = new LinkedList<Long>();
        int ret = 0;
        int n = s.length();
        int i = 0;
        char sign = '+';

        //遍历字符串
        long num = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {//跳过
                i++;
            } else if (s.charAt(i) == '+'||s.charAt(i) == '-'||s.charAt(i) == '*'||s.charAt(i) == '/') {
                if(sign== '+'){
                    ops.push(num);
                }else if(sign== '-'){
                    ops.push(-num);
                }else if(sign== '*'){
                    ops.push(ops.poll()*num);
                }else if(sign== '/'){
                    ops.push(ops.poll()/num);
                }
                sign=s.charAt(i);
                i++;
                num = 0;
            } else {
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
            }
        }
        if(sign== '+'){
            ops.push(num);
        }else if(sign== '-'){
            ops.push(-num);
        }else if(sign== '*'){
            ops.push(ops.poll()*num);
        }else if(sign== '/'){
            ops.push(ops.poll()/num);
        }
        while(ops.size()>0){
            ret+=ops.poll();
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}