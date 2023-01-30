public class demo171 {
    //Excel 表列序号 简单 模拟
    public int titleToNumber(String columnTitle) {
        int ret=0;
        for(char c:columnTitle.toCharArray()){
            ret*=26;
            ret+=c-'A'+1;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("'' = " + (int)'A');
    }
}
