public class demo223 {
    //矩形面积
    //推理 简单经典
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return (ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1)-Math.max(Math.min(ax2,bx2)-Math.max(ax1,bx1),0)*Math.max(Math.min(ay2,by2)-Math.max(ay1,by1),0);
    }
    public static void main(String[] args) {

    }
}