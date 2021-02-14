import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        int x = arr[0];
        int cnt = 1;
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            if (arr[i] == x + 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            x = arr[i];
            if (cnt >= 3) {
               ans++;
            }
        }
        System.out.println(ans);
    }
}