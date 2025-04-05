import java.util.*;


class MarkerStyle {
    private String icon;
    private String color;

    public MarkerStyle(String icon, String color) {
        this.icon = icon;
        this.color = color;
    }

    public void display(String location) {
        System.out.println(icon + " белгісі " + location + " орнында (" + color + ")");
    }
}


class MarkerStyleFactory {
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


class MapMarker {
    private String location;
    private MarkerStyle style;

    public MapMarker(String location, String icon, String color) {
        this.location = location;
        this.style = MarkerStyleFactory.getStyle(icon, color);
    }

    public void display() {
        style.display(location);
    }
}


public class FlyweightPatternDemo {
    public static void main(String[] args) {
        List<MapMarker> markers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            String location = "Орны" + i;
            String type = (i % 3 == 0) ? "Аурухана" : (i % 3 == 1) ? "Жанармай" : "Мейрамхана";
            String color = (i % 3 == 0) ? "Қызыл" : (i % 3 == 1) ? "Жасыл" : "Көк";
            markers.add(new MapMarker(location, type, color));
        }

        for (int i = 0; i < 5; i++) {
            markers.get(i).display();
        }

        System.out.println("\nБарлық нысан саны: " + markers.size());
        System.out.println("Уникалды стиль саны: " + MarkerStyleFactory.getStyleCount());
    }
}