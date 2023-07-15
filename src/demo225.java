import java.util.Deque;
import java.util.LinkedList;

public class demo225 {
    //用队列实现栈
    class MyStack {
        Deque<Integer> d = new LinkedList<Integer>();
        public MyStack() {

        }

        public void push(int x) {
            d.offerFirst(x);
        }

        public int pop() {
            return d.poll();
        }

        public int top() {
            return d.peek();
        }

        public boolean empty() {
            return d.size()==0;
        }
    }

    public static void main(String[] args) {

    }
}