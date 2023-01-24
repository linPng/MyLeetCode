public class demo19 {
    //删除链表的倒数第 N 个结点  中等 链表
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0;
        ListNode h=head;
        while(null!=h.next){
            h=h.next;
            i++;
        }
        if(i==0){
            return null;
        }
        ListNode h2=head;
        if(i-n<0){
            return head.next;
        }
        for(int j=0;j<i-n;j++){
            h2=h2.next;
        }
        if(null!=h2.next){
            h2.next=h2.next.next;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}