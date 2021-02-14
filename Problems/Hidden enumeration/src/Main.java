import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    // write your program here
        long ans = Arrays.stream(Secret.values())
                .map(Enum::name)
                .filter(name -> name.startsWith("STAR"))
                .count();
        System.out.println(ans);
    }
}
