import java.util.*;

public class demo206 {
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//链表尾是null
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;//next需要缓存
            curr.next = prev;//修改next到前一个
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {

    }
}
