package contest.weeklycontest83;

public class B {
    //隐藏个人信息
    //简单模拟
    String[] country = {"", "+*-", "+**-", "+***-"};
    public String maskPII(String s) {
        int at = s.indexOf("@");
        if (at > 0) {
            s = s.toLowerCase();
            return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
        }
        s = s.replaceAll("[^0-9]", "");
        return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }
    public static void main(String[] args) {

    }
}
