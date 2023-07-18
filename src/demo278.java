public class demo278 {
    //第一个错误的版本
    public int firstBadVersion(int n) {
        int l=1,r=n;
        while(r>l){
            int m = l + (r - l) / 2; // 防止计算时溢出
            if (isBadVersion(m)) {
                r = m; // 答案在区间 [left, mid] 中
            } else {
                l = m + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        return l;
    }
    boolean isBadVersion(int version){
        if(version>3){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
