public class demo234 {
    //回文链表
    StringBuilder sb=new StringBuilder();
    public boolean isPalindrome(ListNode head) {
        while(head!=null){
            sb.append(head.val);
            head=head.next;
        }
        return isPalindrome(sb.toString());
    }
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    //递归栈
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    public static void main(String[] args) {

    }
}