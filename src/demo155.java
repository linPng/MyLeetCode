import java.util.ArrayDeque;
import java.util.Deque;

public class demo155 {
    //最小栈 中等 辅助栈
    class MinStack {
        Deque<Integer> d;
        Deque<Integer> d2;
        public MinStack() {
            d=new ArrayDeque<>();
            d2=new ArrayDeque<>();
            d2.addLast(Integer.MAX_VALUE);
        }

        public void push(int val) {
            d.addLast(val);
            d2.addLast(Math.min(val,d2.peekLast()));
        }

        public void pop() {
            d.pollLast();
            d2.pollLast();
        }

        public int top() {
            return d.peekLast();
        }

        public int getMin() {
            return d2.peekLast();
        }
    }
    public static void main(String[] args) {

    }
}
