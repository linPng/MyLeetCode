public class demo86 {
    //分隔链表
    public static ListNode partition(ListNode head, int x) {
        ListNode r=new ListNode();
        ListNode r0=new ListNode();
        ListNode mr=r,mr0=r0;
        while(head!=null){
            if(head.val<x){
                r0.next=head;
                r0=r0.next;
            }else{
                r.next=head;
                r=r.next;
            }
            head=head.next;
        }
        r.next=null;
        r0.next=mr.next;
        return mr0.next;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {

    }

}