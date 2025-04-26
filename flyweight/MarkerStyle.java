public class MarkerStyle {
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
