public class demo168 {
    //Excel表列名称 简单 模拟
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0){
            int d=(columnNumber-1)%26;
            columnNumber=(columnNumber-1)/26;
            sb.insert(0,(char)(d+'A'));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println("'' = " + (int)'A');
    }
}
