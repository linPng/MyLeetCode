import java.util.TreeMap;

public class demo82 {
    //删除排序链表中的重复元素 II
    //正解
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode r=new ListNode();
        r.next=head;
        ListNode ret=r;
        while(r.next!=null&&r.next.next!=null){
            if(r.next.val!=r.next.next.val){
                r=r.next;
            }else{
                int i=r.next.val;
                while(r.next!=null&&r.next.val==i){
                    r.next=r.next.next;
                }
            }
        }
        return ret.next;
    }
    //瞎做
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(head!=null){
            map.put(head.val,map.getOrDefault(head.val,0)+1);
            head=head.next;
        }
        ListNode r=new ListNode(0);
        ListNode ret=r;
        for(int i:map.keySet()){
            if(map.get(i)==1){
                r.next=new ListNode(i);
                r=r.next;
            }
        }
        return ret.next;
    }
    public static void main(String[] args) {


    }
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}