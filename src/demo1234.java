public class demo1234 {
    //替换子串得到平衡字符串
    //滑动窗口
    public int balancedString(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
        for (char c : s){
            ++cnt[c];
        }
        int n = s.length, m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m){
            return 0; // 已经符合要求啦
        }
        int ans = n, left = 0;
        for (int right = 0; right < n; right++) {
            --cnt[s[right]];
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++cnt[s[left++]];
            }
        }
        return ans;
    }
    public static int balancedString2(String s) {
        int q=0,w=0,e=0,r=0,ret=Integer.MAX_VALUE,n=s.length(),d=n/4;
        for(char c:s.toCharArray()){
            if(c=='Q'){
                q++;
            }else if(c=='W'){
                w++;
            }else if(c=='E'){
                e++;
            }else if(c=='R'){
                r++;
            }
        }
        q=q-d>0?q-d:0;
        w=w-d>0?w-d:0;
        e=e-d>0?e-d:0;
        r=r-d>0?r-d:0;
        int count=q+w+e+r;
        if(count==0){
            return 0;
        }
        int L=0,R=count,q1=0,w1=0,e1=0,r1=0;
        for(int i=0;i<count;i++){
            char c=s.charAt(i);
            if(c=='Q'){
                q1++;
            }else if(c=='W'){
                w1++;
            }else if(c=='E'){
                e1++;
            }else if(c=='R'){
                r1++;
            }
        }
        while(L<n&&R<n){
            if(q1>=q&&w1>=w&&e1>=e&&r1>=r){
                ret=Math.min(q1+w1+e1+r1,ret);
            }
            R++;
            char c=s.charAt(R-1);
            if(c=='Q'){
                q1++;
            }else if(c=='W'){
                w1++;
            }else if(c=='E'){
                e1++;
            }else if(c=='R'){
                r1++;
            }
            boolean f=true;
            while(f){
                f=false;
                c=s.charAt(L);
                if(c=='Q'){
                    if(q1>q){f=true;
                        L++;
                        q1--;
                    }
                }else if(c=='W'){
                    if(w1>w){f=true;
                        L++;
                        w1--;
                    }
                }else if(c=='E'){
                    if(e1>e){f=true;
                        L++;
                        e1--;
                    }
                }else if(c=='R'){
                    if(r1>r){f=true;
                        L++;
                        r1--;
                    }
                }
            }
            if(q1>=q&&w1>=w&&e1>=e&&r1>=r){
                ret=Math.min(q1+w1+e1+r1,ret);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("=" + balancedString2("QQQWQQQRWRWQREQRWEWQWEEEEWWEEEWRERWEERRWWEERWEERWWEEQQQEEEQQRQRQRWERQREWRWEWWQQQQWEEEREWREQQEWQR"));
    }
}
