package machine;


public class StringUtils {
    public static final String EMPTY = "";

    private StringUtils() {
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String string) {
        return string != null && string.isEmpty();
    }
}
