public class demo61 {
    //旋转链表 中等 链表
    public ListNode rotateRight(ListNode head, int k) {
        ListNode r=head;
        if(head==null){
            return r;
        }
        int i=1;
        while(head.next!=null){
            head=head.next;
            i++;
        }
        int j=i-k%i;
        if(j==i){
            return r;
        }
        head.next=r;
        while(j-->0){
            ListNode n=r.next;
            if(j==0)r.next=null;
            r=n;
        }
        return r;
    }
    public static void main(String[] args) {

    }
}