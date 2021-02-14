import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] income = new int[n];
        for (int i = 0; i < n; ++i) {
            income[i] = scanner.nextInt();
        }
        int ans = 0;
        double val = 0d;
        for (int i = 0 ; i < n; ++i) {
            double rate = scanner.nextDouble();
            double tmp = income[i] * rate;
            if (tmp > val) {
                val = tmp;
                ans = i + 1;
            }
        }
        System.out.println(ans);
    }
}