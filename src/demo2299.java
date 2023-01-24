public class demo2299 {
    //强密码检验器 II
    //模拟
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8){
            return false;
        }
        boolean b1=false,b2=false,b3=false,b4=false;
        Character t=null;
        for(char c:password.toCharArray()){
            if(c>='a'&&c<='z'){
                b1=true;
            }else if(c>='A'&&c<='Z'){
                b2=true;
            }else if(c>='0'&&c<='9'){
                b3=true;
            }else if(c=='!'||c=='@'||c=='!'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='('||c==')'||c=='-'||c=='+') {
                b4 = true;
            }
            if(t!=null&&t==c){
                return false;
            }
            t=c;
        }
        if(b1&&b2&&b3&&b4){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}