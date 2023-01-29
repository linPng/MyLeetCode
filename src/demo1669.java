public class demo1669 {
    //合并两个链表
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ret=new ListNode(0,list1){};
        ListNode la=ret,lb=ret;
        for(int i=0;i<a;i++){
            la=la.next;
        }
        for(int i=0;i<=b+1;i++){
            lb=lb.next;
        }
        la.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=lb;
        return ret.next;
    }
    public static void main(String[] args) {

    }
}