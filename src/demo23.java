public class demo23 {
    //合并K个升序链表 困难 分治
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        int min=Integer.MAX_VALUE;
        int min_i=0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]==null){
                ListNode[] newlist=new ListNode[lists.length-1];
                for(int j=0;j<lists.length-1;j++){
                    if(j<i){
                        newlist[j]=lists[j];
                    }else{
                        newlist[j]=lists[j+1];
                    }
                }
                return mergeKLists(newlist);
            }
            if(lists[i].val<min){
                min=lists[i].val;
                min_i=i;
            }
        }
        ListNode r=lists[min_i];
        lists[min_i]=lists[min_i].next;
        r.next=mergeKLists(lists);
        return r;
    }
    public static void main(String[] args) {

    }
}