import java.util.*;

public class demo241 {
    //为运算表达式设计优先级
    //分治 递归  等效于对符号优先级排序
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftExpr = input.substring(0, i);
                String rightExpr = input.substring(i + 1);
                List<Integer> leftResults = diffWaysToCompute(leftExpr);
                List<Integer> rightResults = diffWaysToCompute(rightExpr);
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int result = 0;
                        switch (c) {
                            case '+':
                                result = left + right;
                                break;
                            case '-':
                                result = left - right;
                                break;
                            case '*':
                                result = left * right;
                                break;
                        }
                        results.add(result);
                    }
                }
            }
        }

        // 如果结果列表为空，表示表达式中只有数字，没有运算符
        if (results.isEmpty()) {
            results.add(Integer.parseInt(input));
        }

        return results;
    }
    public static void main(String[] args) {

    }
}