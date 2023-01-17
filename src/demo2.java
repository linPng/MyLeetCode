public class demo2 {
    //两数之和
    //模拟
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode ret=new ListNode(0);
        ListNode t=ret;
        int isover=0;
        while(l1!=null||l2!=null||isover!=0){
            int a=0,b=0;
            if(l1!=null){
                a=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                b=l2.val;
                l2=l2.next;
            }
            ListNode tmp=new ListNode((a+b+isover)%10);
            isover=(a+b+isover)/10;
            t.next=tmp;
            t=t.next;
        }
        return ret.next;
    }

    //递归
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2,int i) {
        if(l1==null&&l2==null&&i==0)return null;
        l1=l1==null?new ListNode():l1;
        l2=l2==null?new ListNode():l2;
        int v =l1.val+l2.val+i;
        l1.val=v%10;
        l1.next=addTwoNumbers(l1.next,l2.next,v>=10?1:0);
        return l1;
    }
    public static void main(String[] args) {

    }
}
