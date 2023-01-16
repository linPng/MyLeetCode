import java.util.List;

public class demo148 {
    //排序链表
    //时间复杂度是 O(n \log n)O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)
    //其中最适合链表的排序算法是归并排序。
    //自顶向下 归并排序
    public ListNode sortList2(ListNode head) {
        return sortList2(head, null);
    }
    public ListNode sortList2(ListNode head,ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode f=head,s=head;
        while(f!=tail){
            f=f.next;
            s=s.next;
            if(f!=tail){
                f=f.next;
            }
        }
        return merage(sortList2(head,s),sortList2(s,tail));
    }
    public ListNode merage(ListNode l1,ListNode l2){
        ListNode ret=new ListNode(0);
        ListNode re=ret;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                re.next=l1;
                l1=l1.next;
            }else{
                re.next=l2;
                l2=l2.next;
            }
            re=re.next;
        }
        if(l1!=null){
            re.next=l1;
        }
        if(l2!=null){
            re.next=l2;
        }
        return ret.next;
    }
    //自底向上 归并排序
    public ListNode sortList(ListNode head){
        if(head==null){
            return head;
        }
        int length=0;
        ListNode t=head;
        while(t!=null){
            length++;
            t=t.next;
        }
        ListNode ret=new ListNode(0);
        ret.next=head;
        for(int l=1;l<=length;l*=2){
            ListNode tl=ret.next;
            ListNode pl=ret;
            while(tl!=null){
                ListNode h1,h2;
                h1=tl;
                for(int i=1;i<l&&tl.next!=null;i++){
                    tl=tl.next;
                }
                h2=tl.next;
                tl.next=null;
                tl=h2;
                for(int i=1;i<l&&tl!=null&&tl.next!=null;i++){
                    tl=tl.next;
                }
                ListNode temp=null;
                if(tl!=null){
                    temp=tl.next;
                    tl.next=null;
                }
                pl.next=merage(h1,h2);
                while(pl.next!=null){
                    pl=pl.next;
                }
                tl=temp;
            }
        }
        return ret.next;
    }
    public static void main(String[] args) {

    }

}