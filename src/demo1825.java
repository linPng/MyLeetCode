import java.util.*;

public class demo1825 {
    //求出 MK 平均值
    //三个有序集合 分别保存最小,中间,最大
    class MKAverage {
        private int m, k;
        private Deque<Integer> q;//数据流
        private TreeMap<Integer, Integer> s1;//有序集合
        private TreeMap<Integer, Integer> s2;
        private TreeMap<Integer, Integer> s3;
        private int size1, size2, size3;
        private long sum2;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            this.q = new ArrayDeque<Integer>();
            this.s1 = new TreeMap<Integer, Integer>();
            this.s2 = new TreeMap<Integer, Integer>();
            this.s3 = new TreeMap<Integer, Integer>();
            this.size1 = 0;
            this.size2 = 0;
            this.size3 = 0;
            this.sum2 = 0;
        }

        public void addElement(int num) {
            q.offer(num);//offerLast == add
            if (q.size() <= m) {
                s2.put(num, s2.getOrDefault(num, 0) + 1);
                size2++;
                sum2 += num;
                if (q.size() == m) {//达到临界,将s2多余的移到s13
                    while (size1 < k) {
                        int firstNum = s2.firstKey();
                        s1.put(firstNum, s1.getOrDefault(firstNum, 0) + 1);
                        size1++;
                        sum2 -= firstNum;
                        s2.put(firstNum, s2.get(firstNum) - 1);
                        if (s2.get(firstNum) == 0) {
                            s2.remove(firstNum);
                        }
                        size2--;
                    }
                    while (size3 < k) {
                        int lastNum = s2.lastKey();
                        s3.put(lastNum, s3.getOrDefault(lastNum, 0) + 1);
                        size3++;
                        sum2 -= lastNum;
                        s2.put(lastNum, s2.get(lastNum) - 1);
                        if (s2.get(lastNum) == 0) {
                            s2.remove(lastNum);
                        }
                        size2--;
                    }
                }
                return;
            }

            if (num < s1.lastKey()) {//加入s1
                s1.put(num, s1.getOrDefault(num, 0) + 1);
                int lastNum = s1.lastKey();
                s2.put(lastNum, s2.getOrDefault(lastNum, 0) + 1);
                size2++;
                sum2 += lastNum;
                s1.put(lastNum, s1.get(lastNum) - 1);
                if (s1.get(lastNum) == 0) {
                    s1.remove(lastNum);
                }
            } else if (num > s3.firstKey()) {//加入s3
                s3.put(num, s3.getOrDefault(num, 0) + 1);
                int firstNum = s3.firstKey();
                s2.put(firstNum, s2.getOrDefault(firstNum, 0) + 1);
                size2++;
                sum2 += firstNum;
                s3.put(firstNum, s3.get(firstNum) - 1);
                if (s3.get(firstNum) == 0) {
                    s3.remove(firstNum);
                }
            } else {//加入s2
                s2.put(num, s2.getOrDefault(num, 0) + 1);
                size2++;
                sum2 += num;
            }

            int x = q.poll();//pollfirst 移出第一个,最老的一个
            if (s1.containsKey(x)) {
                s1.put(x, s1.get(x) - 1);
                if (s1.get(x) == 0) {
                    s1.remove(x);
                }
                int firstNum = s2.firstKey();
                s1.put(firstNum, s1.getOrDefault(firstNum, 0) + 1);
                sum2 -= firstNum;
                s2.put(firstNum, s2.get(firstNum) - 1);
                if (s2.get(firstNum) == 0) {
                    s2.remove(firstNum);
                }
                size2--;
            } else if (s3.containsKey(x)) {
                s3.put(x, s3.get(x) - 1);
                if (s3.get(x) == 0) {
                    s3.remove(x);
                }
                int lastNum = s2.lastKey();
                s3.put(lastNum, s3.getOrDefault(lastNum, 0) + 1);
                sum2 -= lastNum;
                s2.put(lastNum, s2.get(lastNum) - 1);
                if (s2.get(lastNum) == 0) {
                    s2.remove(lastNum);
                }
                size2--;
            } else {
                s2.put(x, s2.get(x) - 1);
                if (s2.get(x) == 0) {
                    s2.remove(x);
                }
                size2--;
                sum2 -= x;
            }
        }

        public int calculateMKAverage() {
            if (q.size() < m) {
                return -1;
            }
            return (int) (sum2 / (m - 2 * k));
        }
    }

    //暴力解不可取
    class MKAverage2 {
        Deque<Integer> d = new ArrayDeque<>();
        int mv,kv;
        public MKAverage2(int m, int k) {
            mv=m;kv=k;
        }

        public void addElement(int num) {
            d.addLast(num);
            while(d.size()>mv){
                d.pollFirst();
            }
        }

        public int calculateMKAverage() {
            if(d.size()<mv){
                return -1;
            }else{
                int[] t=new int[d.size()];
                int i=0;
                for(int e:d){
                    t[i]=e;
                    i++;
                }
                Arrays.sort(t);
                long sum=0;
                for(int x=kv;x<mv-kv;x++){
                    sum+=t[x];
                }
                return (int)sum/(mv-kv-kv);
            }
        }
    }
    public static void main(String[] args) {

    }
}
