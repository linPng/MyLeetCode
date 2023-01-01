public class demo91 {
    //解码方法 动态规划 类似爬楼梯

    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        //int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
                //a+=b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
                //a+=c;
            }
            //c=b;b=a;a=0;//bc都为0可以提前结束
        }
        return f[n];
    }
    public static void main(String[] args) {
        System.out.println(" = " + numDecodings("06"));
    }

}