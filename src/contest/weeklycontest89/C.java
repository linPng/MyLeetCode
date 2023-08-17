package contest.weeklycontest89;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class C {
    //855. 考场就座

    public static void main(String[] args) {

    }
}
//延迟删除 + 有序集合 + 优先队列
class ExamRoom {
    int n;
    TreeSet<Integer> seats;
    PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<Integer>();
        this.pq = new PriorityQueue<int[]>((a, b) -> {//根据区间的长度排序
            int d1 = a[1] - a[0], d2 = b[1] - b[0];
            return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first(), right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            int[] p = pq.peek();
            if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                int d = p[1] - p[0];
                if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                    break;
                }
                pq.poll();
                pq.offer(new int[]{p[0], p[0] + d / 2});
                pq.offer(new int[]{p[0] + d / 2, p[1]});
                seats.add(p[0] + d / 2);
                return p[0] + d / 2;
            }
            pq.poll(); // leave 函数中延迟删除的区间在此时删除
        }
        if (right > left) { // 最右的位置更优
            pq.offer(new int[]{seats.last(), n - 1});
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.offer(new int[]{0, seats.first()});
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            int prev = seats.lower(p), next = seats.higher(p);
            pq.offer(new int[]{prev, next});//不删除,只加新区间
        }
        seats.remove(p);
    }
}
//超时
class ExamRoom_TimeOut {
    int[] s;
    int si;
    public ExamRoom_TimeOut(int n) {
        s=new int[n];
        si=0;
    }

    public int seat() {
        int ret=0;
        if(si==0){
            s[0]=1;
        }else{
            ret=maxDistToClosest(s);
            s[ret]=1;
        }
        si++;
        return ret;
    }

    public void leave(int p) {
        s[p-1]=0;
        si--;
    }


    public int maxDistToClosest(int[] seats) {
        long ret=0;
        int reti=0;
        int n=seats.length;
        long[] l=new long[n];
        long[] r=new long[n];
        l[0]=seats[0]==1?0:2 * 100000;
        for(int i=1;i<n;i++){
            if(seats[i]==1){
                l[i]=0;
            }else{
                l[i]=l[i-1]+1;
            }
        }
        r[n-1]=seats[n-1]==1?0:2 * 1000000000;
        for(int i=n-2;i>=0;i--){
            if(seats[i]==1){
                r[i]=0;
            }else{
                r[i]=r[i+1]+1;
            }
        }
        for(int i=0;i<n;i++){
            long t=Math.min(r[i],l[i]);
            if(t>ret){
                ret=t;
                reti=i;
            }
        }
        return reti;
    }
}
