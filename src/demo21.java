public class demo21 {
    //合并两个有序链表 简单 链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list1==null){
            return list1;
        }
        ListNode r=new ListNode(0);
        ListNode t=r;
        while(list1!=null||list2!=null){
            if(list1==null){
                t.next=list2;
                break;
            }
            if(list2==null){
                t.next=list1;
                break;
            }
            if(list1.val<list2.val){
                t.next=list1;
                list1=list1.next;
                t=t.next;
            }else{
                t.next=list2;
                list2=list2.next;
                t=t.next;
            }
        }
        return r.next;
    }
    public static void main(String[] args) {

    }
}