public class demo141 {
    //环形链表 快慢指针 也可以哈希表
    public static boolean hasCycle(ListNode head) {
        ListNode f=head,s=head;
        while(s!=null&&s.next!=null&&s.next.next!=null){
            f=f.next;
            s=s.next.next;
            if(s.equals(f)){
                return true;
            }
        }
        return false;
    }

}