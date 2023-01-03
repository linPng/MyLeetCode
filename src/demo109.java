import java.util.ArrayList;
import java.util.List;

public class demo109 {
    //有序链表转换二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> l=new ArrayList<>();
        while(head!=null){
            l.add(head.val);
            head=head.next;
        }
        return sortedArrayToBST(l);
    }
    public static TreeNode sortedArrayToBST(List<Integer> nums) {
        if(nums.size()==0){
            return null;
        }
        if(nums.size()==1){
            return new TreeNode(nums.get(0));
        }
        int n=nums.size();
        int m=n/2;
        List<Integer> lnum=new ArrayList<>(),rnum=new ArrayList<>();
        for(int i=0;i<m;i++){
            lnum.add(nums.get(i));
        }
        for(int i=m+1;i<n;i++){
            rnum.add(nums.get(i));
        }
        return new TreeNode(nums.get(m),sortedArrayToBST(lnum),sortedArrayToBST(rnum));
    }


    //中序遍历
    ListNode globalHead;
    public TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        //获取链表长度
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return buildTree(0, length - 1);
    }
    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
    public static void main(String[] args) {

    }

}