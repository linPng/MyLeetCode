package planning.BasicDataStructures.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class Backtracking13_753_CrackingTheSafe {

    public String crackSafe(int n, int k) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < n; i++) {
            password.append('0');
        }
        Set<String> visited = new HashSet<>();
        visited.add(password.toString());
        dfs(visited, password, n, k);
        return password.toString();
    }

    private boolean dfs(Set<String> visited, StringBuilder currentPassword, int n, int k) {
        if (visited.size() == Math.pow(k, n)) {
            return true;
        }

        String lastDigits = currentPassword.substring(currentPassword.length() - n + 1);
        System.out.println("lastDigits = " + lastDigits);//可以通过取余来优化效率  
        for (int num = 0; num < k; num++) {
            String newPassword = lastDigits + num;
            System.out.println("newPassword = " + newPassword);
            System.out.println("visited = " + !visited.contains(newPassword));
            if (!visited.contains(newPassword)) {
                System.out.println("dfs in = " + newPassword);
                visited.add(newPassword);
                currentPassword.append(num);
                if (dfs(visited, currentPassword, n, k)) {
                    return true;
                }
                visited.remove(newPassword);
                System.out.println("dfs out = " + newPassword);
                currentPassword.deleteCharAt(currentPassword.length() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Backtracking13_753_CrackingTheSafe b = new Backtracking13_753_CrackingTheSafe();
        System.out.println("b.crackSafe(2,2) = " + b.crackSafe(2,2));
    }
}
