package contest.biweeklycontest111;

public class B {
    //2825. 循环增长使字符串子序列等于另一个字符串
    //双指针
    public boolean canMakeSubsequence(String str1, String str2) {
        int n=str2.length();
        int i=0,j=0;
        while(i<str1.length()&&j<n){
            char a=str1.charAt(i);
            char b=str2.charAt(j);
            char c=a=='z'?'a':(char)(a+1);
            if(a==b||b==c){
                j++;
            }
            i++;
        }
        if(j==n)return true;
        return false;
    }
    public static void main(String[] args) {

    }
}
