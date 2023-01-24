public class demo28 {
    //找出字符串中第一个匹配项的下标 简单 枚举
    public int strStr(String haystack, String needle) {
        char[] a=haystack.toCharArray();
        char[] b=needle.toCharArray();
        for(int i=0;i<a.length-b.length+1;i++){
            int j=0;
            while(a[i+j]==b[j++]){
                if(j==b.length){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}