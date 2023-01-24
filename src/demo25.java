public class demo25 {
    //K 个一组翻转链表 困难 链表 递归
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)return head;
        ListNode r=head;
        ListNode t=null;
        for(int i=0;i<k;i++){
            if(head==null){
                return r;
            }
            head=head.next;
        }
        head=r;
        for(int i=0;i<k;i++){
            ListNode r2=head;
            head=head.next;
            r2.next=t;
            t=r2;
        }
        r.next=reverseKGroup(head,k);
        return t;
    }
    public static void main(String[] args) {

    }
}