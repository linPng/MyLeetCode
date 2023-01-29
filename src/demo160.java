import java.util.HashSet;
import java.util.Set;

public class demo160 {
    //相交链表 简单
    //简单哈希
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
    //双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1=headA,h2=headB;
        while(h1!=null||h2!=null){
            if(h1==h2){
                return h1;
            }
            h1=h1==null?headB:h1.next;
            h2=h2==null?headA:h2.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
