import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo110 {
    //平衡二叉树
    public static boolean levelOrder(TreeNode root) {
        if(-1==maxDepth(root)){
            return false;
        }
        return true;
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            if(leftHeight-rightHeight>1||rightHeight-leftHeight>1||leftHeight==-1||rightHeight==-1){
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public static void main(String[] args) {

    }

}