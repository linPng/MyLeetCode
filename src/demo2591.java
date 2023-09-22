public class demo2591 {
    //2591. 将钱分给最多的儿童
    public int distMoney(int money, int children) {
        if(money<children){
            return -1;
        }
        int m7=money-children;
        int u7=m7/7;
        int d7=m7%7;
        if(u7>children){
            return children-1;
        }
        if(u7==children&&d7!=0){
            return children-1;
        }
        if(u7==children-1&&d7==3){
            return children-2;
        }
        return u7;
    }
    public static void main(String[] args) {

    }
}
