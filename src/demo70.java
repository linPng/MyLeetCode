public class demo70 {
    //删除排序链表中的重复元素
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode r=head;
        while(head!=null&&head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        return r;
    }
    public static void main(String[] args) {

        System.out.println("=== = " + deleteDuplicates(new ListNode()));
    }

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
