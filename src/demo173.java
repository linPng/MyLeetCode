import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class demo173 {
    //二叉搜索树迭代器
    //扁平化 栈
    class BSTIterator {
        Deque<Integer> d;
        public BSTIterator(TreeNode root) {
            d=inorderTraversal(root);
        }
        public Deque<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return new ArrayDeque<>();
            }
            Deque<Integer> r=inorderTraversal(root.left);
            r.addLast(root.val);
            r.addAll(inorderTraversal(root.right));
            return r;
        }
        public int next() {
            return d.pollFirst();
        }

        public boolean hasNext() {
            if(d.size()>0){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
