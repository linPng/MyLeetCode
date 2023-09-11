import java.util.Arrays;
import java.util.PriorityQueue;

public class demo630 {
    //630. 课程表 III
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
        int usetime=0;
        for(int[] i:courses){
            if(usetime+i[0]<=i[1]){
                pq.offer(i);
                usetime+=i[0];
            }else{
                if(!pq.isEmpty()){
                    int[] t=pq.peek();
                    if(t[0]>i[0]&&usetime-t[0]+i[0]<=i[1]){//可以优化，只要小与t就可以替换t
                        pq.poll();
                        pq.offer(i);
                        usetime+=i[0]-t[0];
                    }
                }
            }
        }
        return pq.size();
    }
    public int scheduleCourse2(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }
    public static void main(String[] args) {
        int[][] array = {{5, 5}, {4, 6}, {2, 6}};
        demo630 d=new demo630();
        System.out.println("d.scheduleCourse(array) = " + d.scheduleCourse(array));
    }
}
