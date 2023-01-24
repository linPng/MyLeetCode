public class demo32 {
    //最长有效括号 栈
    public int longestValidParentheses(String s) {
        int r=0;
        int r2=0;
        int a=0;
        int b=0;
        char[] c=s.toCharArray();
        for(char i:c){
            if(i=='('){
                a++;b++;
            }else
            if(i==')'&&a>0){
                a--;b++;
            }else
            if(i==')'&&a<=0){
                a=0;b=0;
            }
            int q=b-a;
            if(a==0)
                if(r<q)r=q;
        }
        a=0;b=0;
        for(int e=c.length-1;e>=0;e--){
            char i=c[e];
            if(i==')'){
                a++;b++;
            }else
            if(i=='('&&a>0){
                a--;b++;
            }else
            if(i=='('&&a<=0){
                a=0;b=0;
            }
            int q=b-a;
            if(a==0)
                if(r2<q)r2=q;
        }
        return Math.max(r,r2);
    }
    public static void main(String[] args) {

    }
}