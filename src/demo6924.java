import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo6924 {
    //最长合法子字符串的长度
    //超时
    public int longestValidSubstring2(String word, List<String> forbidden) {
        int maxLength = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String subStr = word.substring(i, j);
                boolean isForbidden = false;
                for (String forbid : forbidden) {//1 <= forbidden.length <= 10^5  1 <= forbidden[i].length <= 10   所以遍历forbidden是不对的
                    if (subStr.contains(forbid)) {
                        isForbidden = true;
                        break;
                    }
                }
                if (!isForbidden) {
                    maxLength = Math.max(maxLength, subStr.length());
                }
            }
        }
        return maxLength;
    }
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set fb = new HashSet<String>();
        fb.addAll(forbidden);
        int ans = 0, left = 0, n = word.length();
        for (int right = 0; right < n; right++) {
            for (int i = right; i >= left && i > right - 10; i--) {//1 <= forbidden[i].length <= 10
                if (fb.contains(word.substring(i, right + 1))) {
                    left = i + 1; // 当子串右端点 >= right 时，合法子串一定不能包含 word[i]
                    break;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /*
    *
    * fb = set(forbidden) # 0(L)
ans=0
left = 0
# 0(nM^2) M=10
for right in range (len(word)):
for i in range(right, max(right-10, left-1), -1):
if word[i: right+1] in fb:
left=i+1
break
ans = max(ans, right - left + 1)
return ans
*/
    public static void main(String[] args) {

    }
}