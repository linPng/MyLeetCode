package contest.weeklycontest88;

public class A {
    //848. 字母移位
    //反序动态规划
    public String shiftingLetters(String s, int[] shifts) {
        int n=s.length();
        char[] ch= new char[n];
        int dp=0;
        for(int i=n-1;i>=0;i--){
            dp=(shifts[i]+dp)%26;
            ch[i]=(char)((s.charAt(i) - 'a' + dp) % 26 + 'a');
        }
        return new String(ch);
    }
    public static void main(String[] args) {

    }
}
