public class demo203 {
    //移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(0,head);
        ListNode t=ret;
        while(t.next!=null){
            if(t.next.val==val){
                t.next=t.next.next;
            }else{
                t=t.next;
            }
        }
        return ret.next;
    }
    public static void main(String[] args) {

    }
}
