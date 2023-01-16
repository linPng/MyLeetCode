public class demo147 {
    //对链表进行插入排序
    //时间：n*n
    public static ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }
        //哨兵
        ListNode ret=new ListNode(0);
        ret.next=head;
        ListNode tn=head,nn=head.next;
        while(nn!=null){
            if(tn.val<=nn.val){
                tn=tn.next;
                nn=nn.next;
            }else{
                ListNode pn=ret;
                while(pn.next.val<nn.val){
                    pn=pn.next;
                }
                tn.next=nn.next;
                nn.next=pn.next;
                pn.next=nn;
                nn=tn.next;
            }
        }
        return ret.next;
    }
    public static void main(String[] args) {
    }

}