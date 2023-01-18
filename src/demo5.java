public class demo5 {
    //最长回文子串
    public String longestPalindrome(String s) {
        int max=0;
        int max_i=0;
        for(int i=0;i<s.length();i++){
            int m1=f1(s,i,i);
            int m2=f1(s,i,i+1);
            int m3=Math.max(m1,m2);
            if(m3>max){
                max=m3;
                max_i=i;
            }
        }
        return s.substring(max_i-((max-1)/2),max_i+(max/2)+1);
        //return s.substring(max_i,max_i+1);
    }

    //计算回文长度
    public int f1(String s,int l,int r){
        int f=0;
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            f=r-l;
            l--;r++;
        }
        return f+1;
    }
    public static void main(String[] args) {

    }
}