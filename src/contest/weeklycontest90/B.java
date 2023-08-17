package contest.weeklycontest90;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class B {
    //856. 括号的分数
    //栈
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {

    }
}
