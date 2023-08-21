import java.math.BigInteger;
import java.util.List;

public class demo2816 {
    //2816. 翻倍以链表形式表示的数字
    public ListNode doubleIt(ListNode head) {
        BigInteger t=BigInteger.valueOf(0);
        while(head!=null) {
            t = t.multiply(BigInteger.TEN).add(BigInteger.valueOf(head.val));
            head = head.next;
        }
        t=t.multiply(BigInteger.valueOf(2));
        head=new ListNode(0);
        ListNode doli=head;
        String s=String.valueOf(t);
        int n=s.length();
        for(int i=0;i<n;i++){
            ListNode te = new ListNode(s.charAt(i)-'0');
            doli.next=te;
            doli=doli.next;
        }
        return head.next;
    }
    public static void main(String[] args) {

    }
}
