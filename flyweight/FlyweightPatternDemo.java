import java.util.ArrayList;
import java.util.List;

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
