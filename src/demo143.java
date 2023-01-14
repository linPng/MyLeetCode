import java.util.ArrayDeque;
import java.util.Deque;

public class demo143 {
    //重排链表
    public static void reorderList(ListNode head) {
        ListNode t=new ListNode(0,head);
        Deque<ListNode> d =new ArrayDeque<>();
        while(head!=null){
            d.addLast(head);
            head=head.next;
            d.peekLast().next=null;
        }
        boolean b=true;
        while(d.size()>0){
            if(b){
                t.next=d.peekFirst();
                t=d.pollFirst();
            }else{
                t.next=d.peekLast();
                t=d.pollLast();
            }
            b=!b;
        }
        return;
    }

}