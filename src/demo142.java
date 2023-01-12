public class demo142 {
    //环形链表 II 快慢指针 经典
    /*f=2s;  f=s+n*b;   s=n*b;    n*b+a一定在环入口，f回到头节点再走a步会在入口会合  */
    public static ListNode detectCycle(ListNode head) {
        ListNode f=head,s=head;
        boolean b=true;
        while(s!=null&&s.next!=null&&s.next.next!=null){
            if (b) {
                f=f.next;
                s=s.next.next;
                if(s.equals(f)){
                    b=false;
                    f=head;
                }
            }else{
                if(s.equals(f)){
                    return s;
                }
                f=f.next;
                s=s.next;
            }
        }
        return null;
    }

}