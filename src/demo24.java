public class demo24 {
    //两两交换链表中的节点 简单 链表 递归
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode r=head.next;
        head.next=swapPairs(r.next);
        r.next=head;
        return r;
    }
    public static void main(String[] args) {

    }
}