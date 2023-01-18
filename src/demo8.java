public class demo8 {
    //字符串转换整数 (atoi)
    //自动机
    public static int myAtoi(String s) {
        //状态： 前导0   符号位1  数字位2 结束3
        //动作： 空格0   符号位1  数字位2  其他字符3
        int[][] t = new int[][]{{0,1,2,3},{3,3,2,3},{3,3,2,3}};
        char[] c=s.toCharArray();
        int state=0;
        long ret=0;
        long issub=1;
        for(char e:c){
            int ct=toCharType(e);
            state=t[state][ct];
            if(state==3){
                break;
            }else
            if(state==2){
                ret*=10;
                ret=ret+(e-'0');
                if(ret>Integer.MAX_VALUE) {break;}
            }else
            if(state==1&&e=='-'){
                issub=-1;
            }

        }
        ret*=issub;
        //控制范围
        if(ret>Integer.MAX_VALUE){
            ret=Integer.MAX_VALUE;
        }
        if(ret<Integer.MIN_VALUE){
            ret=Integer.MIN_VALUE;
        }
        return (int)ret;
    }
    public static int toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return 2;
        } else if (ch == ' ') {
            return 0;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 3;
        }
    }
    //模拟
    public int myAtoi2(String s) {
        String r="";
        int i=0;
        boolean isNum=false;
        boolean isEnd=false;
        boolean isSub=false;
        boolean isSymbol=false;
        for(char c:s.toCharArray()){
            if(isSymbol&&!(c>=48&&c<58)&&!isNum&&!isEnd){
                return 0;
            }
            if(!((c>=48&&c<58)||c=='+'||c=='-'||c==' ')&&!isNum&&!isEnd){
                return 0;
            }else if(c>=48&&c<58&&!isNum&&!isEnd){
                isNum=true;
                r=r+c;
            }else if(c>=48&&c<58&&isNum&&!isEnd){
                r=r+c;
            }else if(!isNum&&!isEnd&&(c=='+'||c=='-')){
                isSymbol=true;
                if(!isNum&&!isEnd&&c=='-'){
                    isSub=true;
                }
            }else if(isNum&&!isEnd&&!(c>=48&&c<58)){
                isEnd=true;
            }
        }
        if("".equals(r)){
            return 0;
        }
        try{
            i=Integer.parseInt(r);
        }catch(Exception e){
            if(isSub){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }

        if(isSub){
            i=-1*i;
        }
        if(i>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(i<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)i;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
