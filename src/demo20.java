public class demo20 {
    //有效的括号 简单 栈
    public boolean isValid(String s) {
        boolean r=false;
        char[] c=new char[s.length()];
        int ci=0;
        char[] cs=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(cs[i]=='('||cs[i]=='{'||cs[i]=='['){
                c[ci++]=cs[i];
            }else{
                if(ci==0)return false;
                if((c[ci-1]=='('&&cs[i]==')')||(c[ci-1]=='['&&cs[i]==']')||(c[ci-1]=='{'&&cs[i]=='}')){
                    ci--;
                }else{
                    return false;
                }
            }
        }
        if(ci==0)return true;
        else return false;
    }
    public static void main(String[] args) {

    }
}