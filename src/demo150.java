import java.util.ArrayDeque;
import java.util.Deque;

public class demo150 {
    //逆波兰表达式求值
    public static int evalRPN(String[] tokens) {
        Deque<Integer> d=new ArrayDeque<>();
        for(String s:tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int a=d.pollLast();
                int b=d.pollLast();
                int r=0;
                if(s.equals("+")){
                    r=b+a;
                }
                else if(s.equals("-")){
                    r=b-a;
                }
                else if(s.equals("*")){
                    r=b*a;
                }
                else if(s.equals("/")){
                    r=b/a;
                }
                d.addLast(r);
            }else{
                d.addLast(Integer.valueOf(s));
            }
        }
        return d.peekLast();
    }
    public static void main(String[] args) {
        System.out.println(" = " + evalRPN(new String[]{"2","1","+","3","*"}));
    }

}