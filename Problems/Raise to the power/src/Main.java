import java.util.Scanner;

public class Main {

    public static long power(int n, int m) {
        if (m == 0) {
            return 1;
        }
        long answer = 1;
        while (m != 0) {
            if (1 == (m & 1)) {
                answer *= n;
                m--;
            }
            m >>= 1;
            n *= n;
        }
        return answer;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        System.out.println(power(n, m));
    }
}