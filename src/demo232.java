import java.util.Deque;
import java.util.LinkedList;

public class demo232 {
    //用栈实现队列
    class MyQueue {
        Deque<Integer> d=new LinkedList<>();
        public MyQueue() {

        }

        public void push(int x) {
            d.addLast(x);
        }

        public int pop() {
            return d.pollFirst();
        }

        public int peek() {
            return d.peekFirst();
        }

        public boolean empty() {
            return d.isEmpty();
        }
    }
    public static void main(String[] args) {

    }
}