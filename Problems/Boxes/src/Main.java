import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] box1  = new int[3];
        int[] box2  = new int[3];
        for (int i = 0; i < 3; ++i) {
            box1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; ++i) {
            box2[i] = scanner.nextInt();
        }
        Arrays.sort(box1);
        Arrays.sort(box2);
        boolean b1 = true;
        boolean b2 = true;
        for (int j = 0; j < 3; ++j) {
            if (box1[j] >= box2[j]) {
                b1 = false;
            }
            if (box1[j] <= box2[j]) {
                b2 = false;
            }
        }
        if (b1) {
            System.out.println("Box 1 < Box 2");
            return;
        }
        if (b2) {
            System.out.println("Box 1 > Box 2");
            return;
        }
        System.out.println("Incompatible");
    }

    private static void rotate(int[] arr) {
        int tmp = arr[2];
        arr[2] = arr[1];
        arr[1] = arr[0];
        arr[0] = tmp;
    }
}