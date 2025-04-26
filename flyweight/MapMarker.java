public class MapMarker {
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
