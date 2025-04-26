import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {
    private static final Map<String, MarkerStyle> styles = new HashMap<>();

    public static MarkerStyle getStyle(String icon, String color) {
        String key = icon + "_" + color;
        if (!styles.containsKey(key)) {
            styles.put(key, new MarkerStyle(icon, color));
        }
        return styles.get(key);
    }

    public static int getStyleCount() {
        return styles.size();
    }
}
