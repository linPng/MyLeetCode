public class demo344 {
    //反转字符串
    public void reverseString(char[] s) {
        int l=0;int r=s.length-1;
        while(l<r){
            char t=s[l];
            s[l]=s[r];
            s[r]=t;
            l++;
            r--;
        }
    }
    public static void main(String[] args) {

    }
}
